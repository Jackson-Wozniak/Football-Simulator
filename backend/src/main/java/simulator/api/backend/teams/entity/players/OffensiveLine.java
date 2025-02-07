package simulator.api.backend.teams.entity.players;

import lombok.Getter;
import lombok.Setter;
import simulator.api.backend.teams.enums.Position;

@Getter
@Setter
public class OffensiveLine extends Player{
    private int runBlocking;
    private int passBlocking;
    private int physicality;
    private int strength;

    private OffensiveLine(String name, int run, int pass, int physical, int strength){
        super(name, Position.OFFENSIVE_LINE);
        this.runBlocking = run;
        this.passBlocking = pass;
        this.physicality = physical;
        this.strength = strength;
    }

    public static OffensiveLine offensiveLine(String name, int run, int pass, int physical, int strength){
        return new OffensiveLine(name, run, pass, physical, strength);
    }
}
