package simulator.api.backend.teams.entity.players;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simulator.api.backend.teams.entity.Team;
import simulator.api.backend.teams.enums.Position;

@Entity(name = "offensive_line")
@Getter
@Setter
@NoArgsConstructor
public class OffensiveLine extends Player{
    private int runBlocking;
    private int passBlocking;
    private int physicality;
    private int strength;

    private OffensiveLine(String name, Team team, int run, int pass, int physical, int strength){
        super(name, Position.OFFENSIVE_LINE, team);
        this.runBlocking = run;
        this.passBlocking = pass;
        this.physicality = physical;
        this.strength = strength;
    }

    public static OffensiveLine offensiveLine(String name, Team team,
                                              int run, int pass, int physical, int strength){
        return new OffensiveLine(name, team, run, pass, physical, strength);
    }

    @Override
    protected int totalStats(){
        return this.strength + this.physicality + this.passBlocking + this.runBlocking;
    }
}
