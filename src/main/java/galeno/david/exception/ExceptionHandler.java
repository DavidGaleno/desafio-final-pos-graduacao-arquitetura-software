package galeno.david.exception;

import galeno.david.model.ErrorResponse;
import jakarta.persistence.PersistenceException;
import jakarta.ws.rs.core.Response;
import org.hibernate.exception.ConstraintViolationException;

public class ExceptionHandler {
    public static Response handlePersistenceException(PersistenceException exception) {
        if (exception instanceof ConstraintViolationException constraintEx) {
            int errorCode = constraintEx.getSQLException().getErrorCode();

            if (errorCode == 1062) {
                // UNIQUE constraint violation
                String message = constraintEx.getSQLException().getMessage();

                return Response.status(Response.Status.CONFLICT) // HTTP 409
                        .entity(new ErrorResponse(message))
                        .build();
            }
        }
        throw exception;
    }
}
