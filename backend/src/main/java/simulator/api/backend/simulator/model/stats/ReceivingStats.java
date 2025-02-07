package simulator.api.backend.simulator.model.stats;

import lombok.Getter;
import simulator.api.backend.teams.entity.players.Player;

@Getter
public class ReceivingStats {
    private final Player player;
    private int receptions;
    private int targets;
    private int drops;
    private int yards;
    private int touchdowns;

    public ReceivingStats(Player player){
        this.player = player;
        this.receptions = 0;
        this.targets = 0;
        this.drops = 0;
        this.yards = 0;
        this.touchdowns = 0;
    }

    public double yardsPerCatch(){
        return (double) this.yards / this.receptions;
    }

    public void caught(int yards){
        this.receptions++;
        this.targets++;
        this.yards += yards;
    }

    public void touchdown(int yards){
        this.receptions++;
        this.targets++;
        this.yards += yards;
        this.touchdowns++;
    }

    public void target(boolean isDropped){
        this.targets++;
        this.drops += isDropped ? 1 : 0;
    }
}
