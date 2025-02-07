package simulator.api.backend.simulator.model.stats;

import lombok.Getter;
import simulator.api.backend.teams.entity.players.Player;

@Getter
public class PassingStats {
    private final Player player;
    private int completions;
    private int attempts;
    private double yards;
    private int touchdowns;
    private int interceptions;

    public PassingStats(Player player){
        this.player = player;
        this.completions = 0;
        this.attempts = 0;
        this.yards = 0;
        this.touchdowns = 0;
        this.interceptions = 0;
    }

    public double passerRating(){
        double completionFactor = ((completionPercent() / 100.0) - .3) * 5;
        double ypaFactor = (yardsPerAttempt() - 3) * .25;
        double touchdownFactor = ((double) this.touchdowns / this.attempts) * 20;
        double interceptionFactor = 2.375 - (((double) this.interceptions / this.attempts) * 25);

        if(completionFactor > 2.375) completionFactor = 2.375;
        if(completionFactor < 0) completionFactor = 0;

        if(ypaFactor > 2.375) ypaFactor = 2.375;
        if(ypaFactor < 0) ypaFactor = 0;

        if(touchdownFactor > 2.375) touchdownFactor = 2.375;
        if(touchdownFactor < 0) touchdownFactor = 0;

        if(interceptionFactor > 2.375) interceptionFactor = 2.375;
        if(interceptionFactor < 0) interceptionFactor = 0;

        double unweighted = ((completionFactor + ypaFactor + touchdownFactor + interceptionFactor) / 6);
        return Math.floor((unweighted * 100) * 10.0) / 10.0;
    }

    public double completionPercent(){
        double unweighted = (double) this.completions / this.attempts;
        return Math.round((unweighted * 100.00) * 100.0) / 100.0;
    }

    public double yardsPerAttempt(){
        double unweighted = this.yards / this.attempts;
        return Math.round((unweighted) * 100.0) / 100.0;
    }

    public void attempt(boolean isComplete, int yards){
        this.attempts++;
        if(isComplete){
            this.completions++;
            this.yards += yards;
        }
    }

    public void touchdown(int yards){
        this.touchdowns++;
        this.completions++;
        this.attempts++;
        this.yards += yards;
    }

    public void interception(){
        this.attempts++;
        this.interceptions++;
    }
}
