package simulator.api.backend.teams.entity;

import lombok.Getter;
import lombok.Setter;
import simulator.api.backend.teams.enums.Position;

@Getter
@Setter
public class Quarterback extends Player{
    private int accuracy;
    private int iq;
    private int pocketAwareness;
    private int mobility;

    private Quarterback(String name, int acc, int iq, int pocketAwareness, int mobility){
        super(name, Position.QUARTER_BACK);
        this.accuracy = acc;
        this.iq = iq;
        this.pocketAwareness = pocketAwareness;
        this.mobility = mobility;
    }

    public static Quarterback quarterback(String name, int acc, int iq, int pocketAwareness, int mobility){
        return new Quarterback(name, acc, iq, pocketAwareness, mobility);
    }
}
