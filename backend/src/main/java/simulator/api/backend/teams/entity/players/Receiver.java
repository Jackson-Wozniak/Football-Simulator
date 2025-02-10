package simulator.api.backend.teams.entity.players;

import lombok.Getter;
import lombok.Setter;
import simulator.api.backend.teams.enums.Position;

@Getter
@Setter
public class Receiver extends Player{
    private int catching;
    private int iq;
    private int elusiveness;
    private int physicality;

    private Receiver(String name, int catching, int iq, int elusiveness, int physicality) {
        super(name, Position.RECEIVER);
        this.catching = catching;
        this.iq = iq;
        this.elusiveness = elusiveness;
        this.physicality = physicality;
    }

    public static Receiver receiver(String name, int catching, int iq, int elusive, int physical){
        return new Receiver(name, catching, iq, elusive, physical);
    }

    public int getReceiving(){
        return (catching + iq + elusiveness + physicality) / 4;
    }
}
