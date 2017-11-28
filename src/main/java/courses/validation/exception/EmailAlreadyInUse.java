package courses.validation.exception;

public class EmailAlreadyInUse extends Throwable {

    public EmailAlreadyInUse(final String message) {
        super(message);
    }
}
