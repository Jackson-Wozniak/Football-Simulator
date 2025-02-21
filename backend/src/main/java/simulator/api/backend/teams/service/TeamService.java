package simulator.api.backend.teams.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import simulator.api.backend.teams.entity.Team;
import simulator.api.backend.teams.exceptions.TeamNotFoundException;
import simulator.api.backend.teams.repository.TeamRepository;

@Service
@AllArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Team findTeamByName(String name){
        return teamRepository.findById(name)
                .orElseThrow(() -> new TeamNotFoundException("Team: '" + name + "' not found"));
    }
}
