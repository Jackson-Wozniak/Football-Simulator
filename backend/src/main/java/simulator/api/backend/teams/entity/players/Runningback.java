package simulator.api.backend.teams.entity.players;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simulator.api.backend.teams.entity.Team;
import simulator.api.backend.teams.enums.Position;

@Entity(name = "runningback")
@Getter
@Setter
@NoArgsConstructor
public class Runningback extends Player{
    private int elusiveness;
    private int power;
    private int iq;
    private int blocking;
    private int receiving;

    private Runningback(String name, Team team, int elusiveness, int power, int iq, int blocking, int receiving) {
        super(name, Position.RUNNING_BACK, team);
        this.elusiveness = elusiveness;
        this.power = power;
        this.iq = iq;
        this.blocking = blocking;
        this.receiving = receiving;
    }

    public static Runningback runningback(String name, Team team,
                                          int elusive, int pow, int iq, int block, int receive) {
        return new Runningback(name, team, elusive, pow, iq, block, receive);
    }

    @Override
    public int totalStats(){
        return this.iq + this.blocking + this.power + this.elusiveness + this.receiving;
    }
}
