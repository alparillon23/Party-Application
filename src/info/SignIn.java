package info;

import exceptions.PasswordDoesNotMatchException;
import exceptions.SignInSuccessfulException;
import exceptions.UserDoesNotExistException;

import java.io.*;

public class SignIn extends SaveAndLoad{


    public SignIn() {
        super();
    }

    public void signIn(String user, String pass)
            throws UserDoesNotExistException, SignInSuccessfulException, PasswordDoesNotMatchException
    {
        if (nameList.equals(null))
        {
            throw new UserDoesNotExistException();
        }
        else {
            if (nameList.contains(user)) {
                if (passwordList.get(nameList.indexOf(user)).equals(pass)) {
                    throw new SignInSuccessfulException();
                } else {
                    throw new PasswordDoesNotMatchException();
                }
            } else throw new UserDoesNotExistException();
        }
    }
}
