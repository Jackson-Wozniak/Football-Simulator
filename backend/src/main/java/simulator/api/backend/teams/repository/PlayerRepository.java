package simulator.api.backend.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import simulator.api.backend.teams.entity.players.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
