package exceptions;

public class SignUpSuccessfulException extends Exception {
    @Override
    public String getMessage() {
        return "SIGN UP SUCCESSFUL";
    }
}
