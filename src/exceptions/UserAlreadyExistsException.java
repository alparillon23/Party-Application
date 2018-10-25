package exceptions;

public class UserAlreadyExistsException extends Exception {

    @Override
    public String getMessage() {
        return "SIGN UP WITH EXISTING USERNAME";
    }
}
