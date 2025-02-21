package simulator.api.backend.teams.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TeamNotFoundException extends RuntimeException{
    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public TeamNotFoundException(String message){
        super(message);
    }
}
