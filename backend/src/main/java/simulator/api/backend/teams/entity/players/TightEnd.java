package simulator.api.backend.teams.entity.players;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simulator.api.backend.teams.entity.Team;
import simulator.api.backend.teams.enums.Position;

@Entity(name = "tight_end")
@Getter
@Setter
@NoArgsConstructor
public class TightEnd extends Player{
    private int catching;
    private int iq;
    private int blocking;
    private int physicality;

    private TightEnd(String name, Team team, int catching, int iq, int blocking, int physicality) {
        super(name, Position.TIGHT_END, team);
        this.catching = catching;
        this.iq = iq;
        this.blocking = blocking;
        this.physicality = physicality;
    }

    public static TightEnd tightEnd(String name, Team team,
                                    int catching, int iq, int block, int physical){
        return new TightEnd(name, team, catching, iq, block, physical);
    }

    public int getReceiving(){
        return (catching + iq + physicality) / 3;
    }

    @Override
    public int totalStats(){
        return this.physicality + this.iq + this.catching + this.blocking;
    }
}
