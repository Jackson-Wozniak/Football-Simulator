package simulator.api.backend.teams.entity;

import lombok.Getter;
import lombok.Setter;
import simulator.api.backend.teams.entity.players.Player;
import simulator.api.backend.teams.enums.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class DepthChart {

    private Map<Position, ArrayList<Player>> players = new HashMap<>();

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
        this.players.forEach((position, playerList) -> {
            playerList.sort(Player.compareDepthChart());
        });
    }
}
