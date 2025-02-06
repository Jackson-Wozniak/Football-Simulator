package simulator.api.backend.simulator.model;

import lombok.Getter;
import lombok.Setter;
import simulator.api.backend.simulator.enums.OffensivePersonnel;
import simulator.api.backend.teams.entity.DepthChart;
import simulator.api.backend.teams.entity.Player;
import simulator.api.backend.teams.enums.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class OffensivePlay {
    private OffensivePersonnel personnel;
    private int passRate;
    private final Map<Position, ArrayList<Player>> players = new HashMap<>();

    public OffensivePlay(OffensivePersonnel personnel, int passRate){
        this.personnel = personnel;
        this.passRate = passRate;
    }

    public static OffensivePlay elevenFormation(DepthChart depthChart){
        OffensivePlay play = new OffensivePlay(OffensivePersonnel.ELEVEN, 60);
        play.getPlayers().put(Position.QUARTER_BACK, new ArrayList<>());
        play.getPlayers().put(Position.RUNNING_BACK, new ArrayList<>());
        play.getPlayers().put(Position.TIGHT_END, new ArrayList<>());
        play.getPlayers().put(Position.OFFENSIVE_LINE, new ArrayList<>());

        play.getPlayers().get(Position.QUARTER_BACK).add(depthChart.getQuarterbacks().get(0));

        /*
        TODO:
            - add rest of players
         */

        return play;
    }
}
