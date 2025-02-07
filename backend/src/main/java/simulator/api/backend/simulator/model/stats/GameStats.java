package simulator.api.backend.simulator.model.stats;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GameStats {
    private List<PassingStats> passingStats = new ArrayList<>();
    private List<RushingStats> rushingStats = new ArrayList<>();
    private List<ReceivingStats> receivingStats = new ArrayList<>();
    private List<DefensiveStats> defensiveStats = new ArrayList<>();
}
