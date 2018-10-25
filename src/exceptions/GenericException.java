package exceptions;

public class GenericException extends Exception {

    @Override
    public String getMessage() {
        return "GENERAL ERROR MESSAGE";
    }
}
