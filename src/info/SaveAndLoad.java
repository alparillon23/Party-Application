package info;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class SaveAndLoad  {

    protected List<String> nameList;
    protected List<String> passwordList;
    protected File nameRecord;
    protected File passRecord;
    protected BufferedReader in_name;
    protected BufferedReader in_pass;
    protected PrintWriter out_name;
    protected PrintWriter out_pass;

    public SaveAndLoad()
    {
        try {
            nameList = new ArrayList<>();
            passwordList = new ArrayList<>();
            nameRecord = new File("src/info/dataFile/NameRecords.txt");
            passRecord = new File("src/info/dataFile/PassRecords.txt");
            String line = "";
            in_name = new BufferedReader(new FileReader(nameRecord));
            in_pass = new BufferedReader(new FileReader(passRecord));
            while ((line = in_name.readLine()) != null)
            {
                nameList.add(line);

            }
            line= "";
            while ((line = in_pass.readLine()) != null)
            {
                passwordList.add(line);
            }
            in_name.close();
            in_pass.close();

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
