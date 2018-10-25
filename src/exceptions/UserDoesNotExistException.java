package exceptions;

public class UserDoesNotExistException extends Exception {

    @Override
    public String getMessage()
    {
        return "USER DOES NOT EXIST";
    }


}
