package simulator.api.backend.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import simulator.api.backend.teams.entity.Team;

public interface TeamRepository extends JpaRepository<Team, String> {
}
