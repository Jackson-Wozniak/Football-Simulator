package simulator.api.backend.teams.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import simulator.api.backend.teams.repository.PlayerRepository;

@Service
@AllArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
}
