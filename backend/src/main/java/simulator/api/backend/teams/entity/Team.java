package simulator.api.backend.teams.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simulator.api.backend.teams.entity.players.Player;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "team")
@Getter
@Setter
@NoArgsConstructor
public class Team {
    @Id
    private String name;

    @Embedded
    private TeamTendencies tendencies;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players = new ArrayList<>();

    public Team(String name, TeamTendencies tendencies, List<Player> players){
        this.name = name;
        this.tendencies = tendencies;
        this.players.addAll(players);
    }

    public DepthChart getDepthChart(){
        return new DepthChart(players);
    }
}
