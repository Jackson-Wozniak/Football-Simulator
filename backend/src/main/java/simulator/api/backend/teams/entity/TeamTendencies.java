package simulator.api.backend.teams.entity;

import lombok.Getter;
import lombok.Setter;
import simulator.api.backend.simulator.enums.PersonnelType;
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
}
