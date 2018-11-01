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
        int confirm_value = 0;
        if (userList.equals(null))
        {
            throw new UserDoesNotExistException();
        }
        else {
            for(User u:userList)
            {
                if(u.getUser_Name().equals(user)) {
                    if (u.pass_Match(user, pass)) {
                        current_user = u;       //SUCCESSFUL
                        throw new SignInSuccessfulException();
                    }
                }else
                {
                    confirm_value = 1;
                }
            }
            switch (confirm_value) {
                case 1:
                    throw new PasswordDoesNotMatchException();
                default:
                    throw new UserDoesNotExistException();
            }

        }
    }
}
