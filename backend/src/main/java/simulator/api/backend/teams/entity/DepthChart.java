package simulator.api.backend.teams.entity;

import simulator.api.backend.teams.entity.players.Player;
import simulator.api.backend.teams.enums.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthChart {

    private final Map<Position, ArrayList<Player>> players = new HashMap<>();

    public DepthChart(List<Player> players){
        players.forEach(player -> {
            if(!this.players.containsKey(player.getPosition())){
                this.players.put(player.getPosition(), new ArrayList<>());
            }
            this.players.get(player.getPosition()).add(player);
        });

        /*
        now that players are added, we want to sort them once for each position group
        as opposed to doing it multiple times in the loop above
         */
        this.players.forEach((position, playerList) -> playerList.sort(Player.compareDepthChart()));
    }

    public List<Player> quarterbacks(){
        return this.players.get(Position.QUARTER_BACK);
    }

    public List<Player> runningBacks(){
        return this.players.get(Position.RUNNING_BACK);
    }

    public List<Player> receivers(){
        return this.players.get(Position.RECEIVER);
    }

    public List<Player> tightEnds(){
        return this.players.get(Position.TIGHT_END);
    }

    public List<Player> offensiveLine(){
        return this.players.get(Position.OFFENSIVE_LINE);
    }
}
