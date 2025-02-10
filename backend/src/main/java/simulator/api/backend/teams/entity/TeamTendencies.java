package simulator.api.backend.teams.entity;

import lombok.Getter;
import lombok.Setter;
import simulator.api.backend.simulator.enums.PersonnelType;
import simulator.api.backend.teams.entity.players.Player;
import simulator.api.backend.teams.entity.players.Receiver;
import simulator.api.backend.teams.entity.players.Runningback;
import simulator.api.backend.teams.entity.players.TightEnd;
import simulator.api.backend.teams.enums.Aggressiveness;
import simulator.api.backend.teams.enums.PassingStyle;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class TeamTendencies {
    private double passRate;
    private Aggressiveness aggressiveness;
    private PassingStyle passingStyle;
    private Map<PersonnelType, Double> offensivePersonnelRate = new HashMap<>();
    private Map<PersonnelType, Double> defensivePersonnelRate = new HashMap<>();
    private Map<Player, Double> receiverTargetProbabilities = new HashMap<>();

    public void setTargetProbabilities(DepthChart depthChart){
        Map<Player, Integer> playerStats = new HashMap<>();
        int totalStats = 0;
        int receivers = 0;
        for(Player player : depthChart.getReceivers()){
            Receiver receiver = (Receiver) player;
            totalStats += receiver.getReceiving();
            receivers++;
            playerStats.put(receiver, receiver.getReceiving());
        }
        for(Player player : depthChart.getTightEnds()){
            TightEnd receiver = (TightEnd) player;
            totalStats += receiver.getReceiving();
            receivers++;
            playerStats.put(receiver, receiver.getReceiving());
        }
        for(Player player : depthChart.getRunningBacks()){
            Runningback receiver = (Runningback) player;
            totalStats += receiver.getReceiving();
            receivers++;
            playerStats.put(receiver, receiver.getReceiving());
        }
        int finalTotalStats = totalStats;
        playerStats.forEach((player, avg) -> {
            double percent = ((double) avg / finalTotalStats) * 100;
            receiverTargetProbabilities.put(player, percent);
        });
    }
}
