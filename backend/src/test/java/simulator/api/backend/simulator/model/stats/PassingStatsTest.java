package simulator.api.backend.simulator.model.stats;

import org.junit.jupiter.api.Test;
import simulator.api.backend.teams.entity.players.Player;
import simulator.api.backend.teams.entity.players.Quarterback;

import static org.junit.jupiter.api.Assertions.*;

class PassingStatsTest {

    @Test
    void testCompletionPercent(){
        Player testQB = Quarterback.quarterback("Test", null, 100, 100, 100, 100);
        PassingStats stats = new PassingStats(testQB);

        stats.attempt(true, 10);
        assertEquals(100.0, stats.completionPercent());

        stats.attempt(false, 0);
        assertEquals(50.0, stats.completionPercent());

        stats.attempt(false, 0);
        assertEquals(33.33, stats.completionPercent());
    }

    @Test
    void testYardsPerAttempt(){
        Player testQB = Quarterback.quarterback("Test", null, 100, 100, 100, 100);
        PassingStats stats = new PassingStats(testQB);

        stats.attempt(true, 10);
        assertEquals(10.0, stats.yardsPerAttempt());

        stats.attempt(false, 0);
        assertEquals(5.0, stats.yardsPerAttempt());

        stats.attempt(true, 25);
        assertEquals(11.67, stats.yardsPerAttempt());
    }

    @Test
    void testPasserRating(){
        Player testQB = Quarterback.quarterback("Test", null,100, 100, 100, 100);
        PassingStats stats = new PassingStats(testQB);

        stats.attempt(true, 10);
        assertEquals(108.3, stats.passerRating());

        stats.attempt(false, 0);
        assertEquals(64.5, stats.passerRating());

        stats.attempt(false, 0);
        assertEquals(43.7, stats.passerRating());

        stats.interception();
        assertEquals(0.0, stats.passerRating());

        stats.touchdown(40);
        assertEquals(77.0, stats.passerRating());

        stats.attempt(true, 15);
        assertEquals(88.8, stats.passerRating());
    }
}