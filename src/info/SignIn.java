package info;

import java.io.*;

public class SignIn extends SaveAndLoad{


    public SignIn() {
        super();
    }

    public int signIn(String user, String pass)
    {
        if (nameList.equals(null))
        {
            return 0;
        }
        else {
            if (nameList.contains(user)) {
                if (passwordList.get(nameList.indexOf(user)).equals(pass)) {
                    return 2; //Good Match Dialog
                } else {
                    return 1; //Incorrect Password Dialog
                }
            } else return 0; //User doesn't exist
        }
    }
}
