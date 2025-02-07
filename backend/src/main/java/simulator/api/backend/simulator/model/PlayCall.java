package simulator.api.backend.simulator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayCall {
    private boolean isPass;
    private Personnel offensivePersonnel;
    private Personnel defensivePersonnel;
}
