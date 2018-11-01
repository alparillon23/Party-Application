package info;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class SaveAndLoad  {

    protected List<User> userList;
    protected User current_user;
    protected File userRecord;
    protected BufferedReader in_user;
    protected PrintWriter out_user;

    public SaveAndLoad()
    {
        try {
            userList = new ArrayList<>();
            userRecord = new File("src/info/dataFile/NameRecords.txt");
            String line = "";
            in_user = new BufferedReader(new FileReader(userRecord));
            while ((line = in_user.readLine()) != null)
            {
                String[] splitLine = line.split(",");
                userList.add(new User(Integer.parseInt(splitLine[0]),splitLine[1],splitLine[2]));
            }
            in_user.close();

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public User getCurrent_user() {
        return current_user;
    }
}
