package simulator.api.backend.teams.entity.players;

import lombok.Getter;
import lombok.Setter;
import simulator.api.backend.teams.enums.Position;

@Getter
@Setter
public class Runningback extends Player{
    private int elusiveness;
    private int power;
    private int iq;
    private int blocking;
    private int receiving;

    private Runningback(String name, int elusiveness, int power, int iq, int blocking, int receiving) {
        super(name, Position.RUNNING_BACK);
        this.elusiveness = elusiveness;
        this.power = power;
        this.iq = iq;
        this.blocking = blocking;
        this.receiving = receiving;
    }

    public static Runningback runningback(String name, int elusive, int pow, int iq, int block, int receive) {
        return new Runningback(name, elusive, pow, iq, block, receive);
    }
}
