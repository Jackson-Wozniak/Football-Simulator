package simulator.api.backend.teams.entity.players;

import lombok.Getter;
import lombok.Setter;
import simulator.api.backend.teams.enums.Position;

@Getter
@Setter
public class TightEnd extends Player{
    private int catching;
    private int iq;
    private int blocking;
    private int physicality;

    private TightEnd(String name, int catching, int iq, int blocking, int physicality) {
        super(name, Position.TIGHT_END);
        this.catching = catching;
        this.iq = iq;
        this.blocking = blocking;
        this.physicality = physicality;
    }

    public static TightEnd tightEnd(String name, int catching, int iq, int block, int physical){
        return new TightEnd(name, catching, iq, block, physical);
    }
}
