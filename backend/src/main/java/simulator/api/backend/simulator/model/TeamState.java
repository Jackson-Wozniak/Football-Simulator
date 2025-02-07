package simulator.api.backend.simulator.model;

import lombok.Getter;
import lombok.Setter;
import simulator.api.backend.simulator.enums.PersonnelType;
import simulator.api.backend.teams.entity.TeamTendencies;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class TeamState {
    private Map<PersonnelType, Personnel> offensivePersonnel = new HashMap<>();
    private Map<PersonnelType, Personnel> defensivePersonnel = new HashMap<>();
    private TeamTendencies teamTendencies;
}
