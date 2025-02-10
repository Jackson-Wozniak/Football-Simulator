package simulator.api.backend.teams.entity.players;

import lombok.Getter;
import lombok.Setter;
import simulator.api.backend.teams.enums.Position;

@Getter
@Setter
public abstract class Player {
    private String name;
    private Position position;

    protected Player(String name, Position position){
        this.name = name;
        this.position = position;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof Player)) return false;
        return ((Player) obj).getName().equals(this.getName());
    }
}
