package simulator.api.backend.simulator.helper;

public class PlaySimulator {

    /*
    TODO:
        - there is an offensive & defensive play that has formation/personnel info
        - decide whether run/pass depending on the team and personnel tendency
        - simulate the play
            - each position group affects play outcome on their own
            - OL/DL has pressure/protection rates on passes
                - if DL gets a pressure, QB accuracy is lowered depending on QB's PocketAwareness
                - if DL gets a sack, sacks are given based on rating (best DL has highest chance to get credit for sack)
            - if pass is thrown
                - accuracy affects chance that its complete
                - a receiver target is chosen, with high rated receivers having better chance to get the target
                - completion chance depends on QB, WR, DB ratings
                - if completed, yards gained also depends on the ratings & tendencies
                - tackles have a high % chance of being from the covering DB
            - if ran, RB & OL/DL ratings determine outcome
                - tackles depend on the defense ratings on who gets credit
     */
}
