package simulator.api.backend.teams.entity.players;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simulator.api.backend.teams.entity.Team;
import simulator.api.backend.teams.enums.Position;

import java.util.Comparator;

@Entity(name = "player")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public abstract class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "player_name")
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "player_position")
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    protected Player(String name, Position position, Team team){
        this.name = name;
        this.position = position;
        this.team = team;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof Player)) return false;
        return ((Player) obj).getName().equals(this.getName());
    }

    protected abstract int totalStats();


    //used to sort players by their depth chart position
    //Accurate when comparing players at the same position
    public static Comparator<Player> compareDepthChart(){
        return Comparator.comparing(Player::totalStats).reversed();
    }
}
