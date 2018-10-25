package info;

import exceptions.GenericException;
import exceptions.SignUpSuccessfulException;
import exceptions.UserAlreadyExistsException;

import java.io.*;

public class SignUp extends SaveAndLoad {

    public SignUp()
    {
        super();
    }

    public void signUp(String name, String pass) throws SignUpSuccessfulException, GenericException, UserAlreadyExistsException
    {
        try
        {
            if(nameList.equals(null) || (!(nameList.contains(name))))
            {
                out_name = new PrintWriter(new FileOutputStream(new File ("src/info/dataFile/NameRecords.txt"),true));
                out_pass = new PrintWriter(new FileOutputStream(new File ("src/info/dataFile/PassRecords.txt"),true));
                out_name.append(name+"\n");
                out_pass.append(pass+"\n");
                nameList.add(name);
                passwordList.add(pass);
                out_name.flush();
                out_pass.flush();
                throw new SignUpSuccessfulException();

            }
            else
                throw new UserAlreadyExistsException();

        }
        catch (IOException e)
        {
                System.out.print(e.getMessage());
                throw new GenericException();
        }
    }
}
