package simulator.api.backend.teams.entity;

import org.junit.jupiter.api.Test;
import simulator.api.backend.teams.entity.players.Player;
import simulator.api.backend.teams.entity.players.Quarterback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepthChartTest {

    @Test
    void constructorOrdersPositionGroup(){
        List<Player> quarterbacks = List.of(
                Quarterback.quarterback("4th", null, 0, 0, 0, 100),
                Quarterback.quarterback("2nd", null, 100, 0, 100, 100),
                Quarterback.quarterback("1st", null, 100, 100, 100, 100),
                Quarterback.quarterback("3rd", null, 100, 50, 50, 50)
        );
        DepthChart depthChart = new DepthChart(quarterbacks);

        assertNotNull(depthChart.quarterbacks());
        assertEquals("1st", depthChart.quarterbacks().get(0).getName());
        assertEquals("2nd", depthChart.quarterbacks().get(1).getName());
        assertEquals("3rd", depthChart.quarterbacks().get(2).getName());
        assertEquals("4th", depthChart.quarterbacks().get(3).getName());
    }
}