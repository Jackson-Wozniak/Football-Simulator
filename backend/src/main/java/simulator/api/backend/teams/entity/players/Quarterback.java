package simulator.api.backend.teams.entity.players;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simulator.api.backend.teams.entity.Team;
import simulator.api.backend.teams.enums.Position;

@Entity(name = "quarterback")
@Getter
@Setter
@NoArgsConstructor
public class Quarterback extends Player{
    private int accuracy;
    private int iq;
    private int pocketAwareness;
    private int mobility;

    private Quarterback(String name, Team team, int acc, int iq, int pocketAwareness, int mobility){
        super(name, Position.QUARTER_BACK, team);
        this.accuracy = acc;
        this.iq = iq;
        this.pocketAwareness = pocketAwareness;
        this.mobility = mobility;
    }

    public static Quarterback quarterback(String name, Team team,
                                          int acc, int iq, int pocketAwareness, int mobility){
        return new Quarterback(name, team, acc, iq, pocketAwareness, mobility);
    }

    @Override
    public int totalStats(){
        return this.iq + this.accuracy + this.mobility + this.pocketAwareness;
    }
}
