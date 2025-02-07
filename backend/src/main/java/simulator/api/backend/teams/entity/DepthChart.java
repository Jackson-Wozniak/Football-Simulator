package simulator.api.backend.teams.entity;

import lombok.Getter;
import lombok.Setter;
import simulator.api.backend.teams.entity.players.Player;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DepthChart {

    private final List<Player> quarterbacks = new ArrayList<>();
    private final List<Player> runningBacks = new ArrayList<>();
    private final List<Player> receivers = new ArrayList<>();
    private final List<Player> tightEnds = new ArrayList<>();
    private final List<Player> offensiveLine = new ArrayList<>();

}
