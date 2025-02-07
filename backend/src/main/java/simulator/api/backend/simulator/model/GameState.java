package simulator.api.backend.simulator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameState {
    private TeamState homeTeam;
    private int homeTeamPoints;
    private TeamState awayTeam;
    private int awayTeamPoints;
    private boolean homeTeamPossession;
    private int fieldPosition;
    private int down;
    private int quarter;
    private double secondsLeft;
}
