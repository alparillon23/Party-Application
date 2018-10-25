package exceptions;

public class SignInSuccessfulException extends Exception {
    @Override
    public String getMessage() {
        return "SIGN IN SUCCESSFUL";
    }
}
