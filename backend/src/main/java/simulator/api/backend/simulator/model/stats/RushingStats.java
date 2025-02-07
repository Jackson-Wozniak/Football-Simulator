package simulator.api.backend.simulator.model.stats;

import lombok.Getter;
import simulator.api.backend.teams.entity.players.Player;

@Getter
public class RushingStats {
    private final Player player;
    private int yards;
    private int carries;
    private int touchdowns;
    private int fumbles;
    //private int brokenTackles;

    public RushingStats(Player player){
        this.player = player;
        this.yards = 0;
        this.carries = 0;
        this.touchdowns = 0;
        this.fumbles = 0;
    }

    public double yardsPerAttempt(){
        return (double) this.yards / this.carries;
    }

    public void touchdown(int yards){
        this.carries++;
        this.yards += yards;
        this.touchdowns++;
    }

    public void carry(int yards){
        this.carries++;
        this.yards += yards;
    }

    public void fumble(int yards){
        this.carries++;
        this.fumbles++;
        this.yards += yards;
    }
}
