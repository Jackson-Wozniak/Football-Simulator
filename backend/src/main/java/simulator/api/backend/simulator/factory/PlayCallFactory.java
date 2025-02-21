package simulator.api.backend.simulator.factory;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayCallFactory {

    /*
    TODO:
        - this class acts a manager for all play calls, offense & defense, based on
            both team tendencies and game state
        - does NOT keep information in memory, rather the GameManager class is what keeps track
            of the specifics of simulating the game, and this class generates isolated play calls
     */
}
