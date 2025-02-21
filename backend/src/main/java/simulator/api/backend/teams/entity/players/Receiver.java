package simulator.api.backend.teams.entity.players;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simulator.api.backend.teams.entity.Team;
import simulator.api.backend.teams.enums.Position;

@Entity(name = "receiver")
@Getter
@Setter
@NoArgsConstructor
public class Receiver extends Player{
    private int catching;
    private int iq;
    private int elusiveness;
    private int physicality;

    private Receiver(String name, Team team, int catching, int iq, int elusiveness, int physicality) {
        super(name, Position.RECEIVER, team);
        this.catching = catching;
        this.iq = iq;
        this.elusiveness = elusiveness;
        this.physicality = physicality;
    }

    public static Receiver receiver(String name, Team team,
                                    int catching, int iq, int elusive, int physical){
        return new Receiver(name, team, catching, iq, elusive, physical);
    }

    public int getReceiving(){
        return (catching + iq + elusiveness + physicality) / 4;
    }

    @Override
    public int totalStats(){
        return this.catching + this.iq + this.elusiveness + this.physicality;
    }
}
