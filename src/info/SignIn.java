package info;

import java.io.*;

public class SignIn {

    File records;
    FileReader reader;
    FileWriter writer;
    String rec = "";

    public SignIn() throws IOException {
        records = new File("src/info/Records.txt");
        reader = new FileReader (records);
        writer = new FileWriter (records, true);
    }

    public String signUp(String user, String pass) throws IOException {
            String str = user + " " + pass + "\n";
            if (existing(user))
            {
                return "Sorry this name is already in use";
            }
            else
            {
                writer.append(str);
                writer.close();
                return "Welcome to the Party "+ user;
            }

    }

    public void signIn(){


    }

    public boolean existing(String userName) throws IOException {
        boolean here = false;
        int ch = 0;
        while ((ch=reader.read())!=-1)
        {
            while ((char)ch != '\n')
            {
                rec += (char)ch;
            }
            if (recordMatch(rec, userName))
                here=true;

        }
        reader.close();
        return here;
    }

    public boolean recordMatch(String rec, String userName) {
        String name = "";
        for(int i=0;i<rec.length();i++)
        {
            if (rec.charAt(i)!= ' ')
                name+=rec.charAt(i);
            else
                break;
        }

        return (name == userName);
    }
}
