package simulator.api.backend.simulator.model.stats;

import lombok.Getter;
import simulator.api.backend.teams.entity.players.Player;

@Getter
public class DefensiveStats {
    private final Player player;
    private double tackles;
    private double sacks;
    private int interceptions;
    private int deflections;

    public DefensiveStats(Player player){
        this.player = player;
        this.tackles = 0;
        this.sacks = 0;
        this.interceptions = 0;
        this.deflections = 0;
    }

    public void tackle(boolean isSolo){
        this.tackles += isSolo ? 1 : .5;
    }

    public void sack(boolean isSolo){
        this.sacks += isSolo ? 1 : .5;
    }

    public void interception(){
        this.interceptions++;
    }

    public void deflections(){
        this.deflections++;
    }
}
