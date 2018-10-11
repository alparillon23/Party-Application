package info;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class EventMaker {

    protected ArrayList<Event> list;
    protected int userId;
    //protected int tempEventID;
    protected File eventRecords;
    protected BufferedReader in_events;
    protected PrintWriter out_eventRec;


    public EventMaker(int id) //Deals only with User defined Events
    {
        userId = id;
        list = new ArrayList<Event>();
        try
        {
            eventRecords = new File("src/info/eventFile/EventsRecords.txt");
            String line = "";
            in_events = new BufferedReader(new FileReader(eventRecords));
            while ((line = in_events.readLine()) != null)
            {
                //get the lineX
                //split the lineX
                String[] splitLine = line.split(",");
                //compare the userID to the ID -> if that's good then we add it to the list
                if(Integer.parseInt(splitLine[1])==id) //User ID matches the Events
                {
                    list.add(new Event(Integer.parseInt(splitLine[0]),Integer.parseInt(splitLine[1]),splitLine[2],splitLine[3],splitLine[4],splitLine[5]));
                }
                //nameList.add(line);

            }
            in_events.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void addEvent(int userID, String name, String location, String date, String time)
    {

       try {
           eventRecords = new File("src/info/eventFile/EventsRecords.txt");
           in_events = new BufferedReader(new FileReader(eventRecords));
           out_eventRec = new PrintWriter(new FileOutputStream(eventRecords,true));
           int j = getNewID(in_events);
           list.add(new Event(j,userID,name,location,date,time));
           out_eventRec.append(j+","+userID+","+name+","+location+","+date+","+time+"\n");
           out_eventRec.flush();
       }
       catch (IOException er)
       {
           System.out.println(er.getMessage());
       }
    }

    private int getNewID(BufferedReader in_events) throws IOException {
        Random rn = new Random();
        ArrayList<Integer> ListOfIDs = new ArrayList<>();
        String line = "";
        while ((line = in_events.readLine()) != null) {
            String[] splitLine = line.split(",");
            ListOfIDs.add(Integer.parseInt(splitLine[0]));
        }
        int value = rn.nextInt();
        while(ListOfIDs.contains(value))
                value = rn.nextInt();
        in_events.close();
        return value;
    }


    public void removeEvent(int eventID, int userID) //Complete this implementation
    {
        for(Event e: list)
        {
            if ((e.getId()==eventID)&&(e.getPersonId()==userID))
                list.remove(e);
            try
            {
                eventRecords = new File("src/info/eventFile/EventsRecords.txt");
                File temp = new File ("src/info/eventFile/temp.txt");
                PrintWriter out_temp = new PrintWriter(new FileOutputStream(temp,true));
                out_eventRec = new PrintWriter(new FileOutputStream(eventRecords,false));
                String line = "";
                String temp_read = "";
                in_events = new BufferedReader(new FileReader(eventRecords));
                BufferedReader in_temp = new BufferedReader(new FileReader(temp));
                while ((line = in_events.readLine()) != null)
                {
                    //find the line that we want to change
                    String[] splitLine = line.split(",");
                    if((Integer.parseInt(splitLine[0])==eventID)&&(Integer.parseInt(splitLine[1])==userID))
                    {

                    }
                    else
                    {
                        out_temp.append(line+"\n");
                    }

                }
                out_temp.flush();
                while ((line = in_temp.readLine()) != null)
                {
                    temp_read += (line + "\n");
                }
                out_eventRec.write(temp_read);
                out_eventRec.flush();
                in_events.close();
            }
            catch(IOException er)
            {
                System.out.println(er.getMessage());
            }

        }
    }


    public void modifyEventName(int eventID, int userID, String name)
    {
        for (Event e: list)
        {
            if((e.getId()==eventID) && (e.getPersonId() == userID))
            {
                e.setName(name);
                try
                {
                    eventRecords = new File("src/info/eventFile/EventsRecords.txt");
                    File temp = new File ("src/info/eventFile/temp.txt");
                    PrintWriter out_temp = new PrintWriter(new FileOutputStream(temp,true));
                    out_eventRec = new PrintWriter(new FileOutputStream(eventRecords,false));
                    String line = "";
                    String temp_read = "";
                    in_events = new BufferedReader(new FileReader(eventRecords));
                    BufferedReader in_temp = new BufferedReader(new FileReader(temp));
                    while ((line = in_events.readLine()) != null)
                    {
                        //find the line that we want to change
                        String[] splitLine = line.split(",");
                        if((Integer.parseInt(splitLine[0])==eventID)&&(Integer.parseInt(splitLine[1])==userID))
                        {

                        }
                        else
                        {
                            out_temp.append(line+"\n");
                        }

                    }
                    out_temp.append(e.getId()+","+e.getPersonId()+","+e.getName()+","+e.getLocation()+","+e.getDate()+","+e.getTime());
                    out_temp.flush();
                    while ((line = in_temp.readLine()) != null)
                    {
                        temp_read += (line + "\n");
                    }
                    out_eventRec.write(temp_read);
                    out_eventRec.flush();
                    in_events.close();
                }
                catch(IOException er)
                {
                    System.out.println(er.getMessage());
                }
            }
        }
    }

    public void modifyEventLocation(int eventID, int userID, String location)
    {
        for (Event e: list)
        {
            if((e.getId()==eventID) && (e.getPersonId() == userID))
            {
                e.setLocation(location);
                try
                {
                    eventRecords = new File("src/info/eventFile/EventsRecords.txt");
                    File temp = new File ("src/info/eventFile/temp.txt");
                    PrintWriter out_temp = new PrintWriter(new FileOutputStream(temp,true));
                    out_eventRec = new PrintWriter(new FileOutputStream(eventRecords,false));
                    String line = "";
                    String temp_read = "";
                    in_events = new BufferedReader(new FileReader(eventRecords));
                    BufferedReader in_temp = new BufferedReader(new FileReader(temp));
                    while ((line = in_events.readLine()) != null)
                    {
                        //find the line that we want to change
                        String[] splitLine = line.split(",");
                        if((Integer.parseInt(splitLine[0])==eventID)&&(Integer.parseInt(splitLine[1])==userID))
                        {

                        }
                        else
                        {
                            out_temp.append(line+"\n");
                        }

                    }
                    out_temp.append(e.getId()+","+e.getPersonId()+","+e.getName()+","+e.getLocation()+","+e.getDate()+","+e.getTime());
                    out_temp.flush();
                    while ((line = in_temp.readLine()) != null)
                    {
                        temp_read += (line + "\n");
                    }
                    out_eventRec.write(temp_read);
                    out_eventRec.flush();
                    in_events.close();
                }
                catch(IOException er)
                {
                    System.out.println(er.getMessage());
                }
            }
        }
    }

    public void modifyEventDate(int eventID, int userID, String date)
    {
        for (Event e: list)
        {
            if((e.getId()==eventID) && (e.getPersonId() == userID))
            {
                e.setDate(date);
                try
                {
                    eventRecords = new File("src/info/eventFile/EventsRecords.txt");
                    File temp = new File ("src/info/eventFile/temp.txt");
                    PrintWriter out_temp = new PrintWriter(new FileOutputStream(temp,true));
                    out_eventRec = new PrintWriter(new FileOutputStream(eventRecords,false));
                    String line = "";
                    String temp_read = "";
                    in_events = new BufferedReader(new FileReader(eventRecords));
                    BufferedReader in_temp = new BufferedReader(new FileReader(temp));
                    while ((line = in_events.readLine()) != null)
                    {
                        //find the line that we want to change
                        String[] splitLine = line.split(",");
                        if((Integer.parseInt(splitLine[0])==eventID)&&(Integer.parseInt(splitLine[1])==userID))
                        {

                        }
                        else
                        {
                            out_temp.append(line+"\n");
                        }

                    }
                    out_temp.append(e.getId()+","+e.getPersonId()+","+e.getName()+","+e.getLocation()+","+e.getDate()+","+e.getTime());
                    out_temp.flush();
                    while ((line = in_temp.readLine()) != null)
                    {
                        temp_read += (line + "\n");
                    }
                    out_eventRec.write(temp_read);
                    out_eventRec.flush();
                    in_events.close();
                }
                catch(IOException er)
                {
                    System.out.println(er.getMessage());
                }
            }
        }
    }

    public void modifyEventTime(int eventID, int userID, String time)
    {
        for (Event e: list)
        {
            if((e.getId()==eventID) && (e.getPersonId() == userID))
            {
                e.setTime(time);
                try
                {
                    eventRecords = new File("src/info/eventFile/EventsRecords.txt");
                    File temp = new File ("src/info/eventFile/temp.txt");
                    PrintWriter out_temp = new PrintWriter(new FileOutputStream(temp,true));
                    out_eventRec = new PrintWriter(new FileOutputStream(eventRecords,false));
                    String line = "";
                    String temp_read = "";
                    in_events = new BufferedReader(new FileReader(eventRecords));
                    BufferedReader in_temp = new BufferedReader(new FileReader(temp));
                    while ((line = in_events.readLine()) != null)
                    {
                        //find the line that we want to change
                        String[] splitLine = line.split(",");
                        if((Integer.parseInt(splitLine[0])==eventID)&&(Integer.parseInt(splitLine[1])==userID))
                        {

                        }
                        else
                        {
                            out_temp.append(line+"\n");
                        }

                    }
                    out_temp.append(e.getId()+","+e.getPersonId()+","+e.getName()+","+e.getLocation()+","+e.getDate()+","+e.getTime());
                    out_temp.flush();
                    while ((line = in_temp.readLine()) != null)
                    {
                        temp_read += (line + "\n");
                    }
                    out_eventRec.write(temp_read);
                    out_eventRec.flush();
                    in_events.close();
                }
                catch(IOException er)
                {
                    System.out.println(er.getMessage());
                }
            }
        }
    }



}
