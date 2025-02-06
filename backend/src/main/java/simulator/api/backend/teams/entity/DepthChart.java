package simulator.api.backend.teams.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DepthChart {

    private final List<Player> quarterbacks = new ArrayList<>();
}
