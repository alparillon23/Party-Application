package exceptions;

public class PasswordDoesNotMatchException extends Exception {

    @Override
    public String getMessage() {
        return "INCORRECT PASSWORD USED";
    }
}
