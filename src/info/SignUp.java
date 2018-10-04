package info;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

public class SignUp extends SaveAndLoad {

    public SignUp()
    {
        super();
    }

    public int signUp(String name, String pass)
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
                return 1;

            }
            else
                return 0;

        }
        catch (Exception e)
        {
                System.out.print(e.getMessage());
                return 2;
        }
    }
}
