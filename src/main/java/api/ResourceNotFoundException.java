package api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Person is not found in the db!")
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
    	super(message);
    }
}