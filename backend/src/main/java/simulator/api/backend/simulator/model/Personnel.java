package simulator.api.backend.simulator.model;

import lombok.Getter;
import lombok.Setter;
import simulator.api.backend.simulator.enums.PersonnelType;
import simulator.api.backend.teams.entity.players.Player;
import simulator.api.backend.teams.enums.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
This class is used for both offensive and defensive personnel.
We keep track of each possible personnel type and the corresponding players based on the depth chart,
so that when a play is called that matches the personnel the simulation knows what players are on the field.
 */
@Getter
@Setter
public class Personnel {
    private PersonnelType personnelType;
    private Map<Position, ArrayList<Player>> players = new HashMap<>();
}
