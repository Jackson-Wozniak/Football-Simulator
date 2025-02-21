package simulator.api.backend.teams.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@Embeddable
@Getter
@Setter
public class TeamTendencies {
    @Column(name = "pass_rate_prob")
    private double passRate;
    @Enumerated(EnumType.STRING)
    private Aggressiveness aggressiveness;
    @Enumerated(EnumType.STRING)
    private PassingStyle passingStyle;

    public Map<PersonnelType, Double> defensivePersonnelRate(){
        return null;
    }

    public Map<PersonnelType, Double> offensivePersonnelRate(){
        return null;
    }

    public Map<Player, Double> receiverTargetProbabilities(DepthChart depthChart){
        Map<Player, Double> targetProbabilities = new HashMap<>();

        Map<Player, Integer> playerStats = new HashMap<>();
        int totalStats = 0;
        for(Player player : depthChart.receivers()){
            Receiver receiver = (Receiver) player;
            totalStats += receiver.getReceiving();
            playerStats.put(receiver, receiver.getReceiving());
        }
        for(Player player : depthChart.tightEnds()){
            TightEnd receiver = (TightEnd) player;
            totalStats += receiver.getReceiving();
            playerStats.put(receiver, receiver.getReceiving());
        }
        for(Player player : depthChart.runningBacks()){
            Runningback receiver = (Runningback) player;
            totalStats += receiver.getReceiving();
            playerStats.put(receiver, receiver.getReceiving());
        }

        int finalTotalStats = totalStats;
        playerStats.forEach((player, avg) -> {
            double percent = ((double) avg / finalTotalStats) * 100;
            targetProbabilities.put(player, percent);
        });
        return targetProbabilities;
    }
}
