package info;

import exceptions.GenericException;
import exceptions.SignUpSuccessfulException;
import exceptions.UserAlreadyExistsException;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class SignUp extends SaveAndLoad {

    public SignUp()
    {
        super();
    }

    public void signUp(String name, String pass) throws SignUpSuccessfulException, GenericException, UserAlreadyExistsException
    {
        try
        {
            if(userList.equals(null) || !(existsUser(name)))
            {
                out_user = new PrintWriter(new FileOutputStream(new File ("src/info/dataFile/NameRecords.txt"),true));
                in_user = new BufferedReader(new FileReader(userRecord));
                int id = genUserID(in_user);
                out_user.append(id+","+name+","+pass+"\n");
                current_user = new User(id,name,pass);
                userList.add(current_user);
                out_user.flush();
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

    private int genUserID(BufferedReader in_user) throws IOException {//Returns a unique ID that will be used in implementations
        Random rn = new Random();
        ArrayList<Integer> ListOfIDs = new ArrayList<>();
        String line = "";
        while ((line = in_user.readLine()) != null) {
            String[] splitLine = line.split(",");
            ListOfIDs.add(Integer.parseInt(splitLine[0]));
        }
        int value = rn.nextInt(10000);
        while(ListOfIDs.contains(value))
            value = rn.nextInt();
        in_user.close();
        return value;
    }

    private boolean existsUser(String name)
    {
        boolean isPresent = false;
        for(User u: userList)
        {
            if(u.getUser_Name().equals(name))
                isPresent = true;
        }
        return isPresent;
    }
}
