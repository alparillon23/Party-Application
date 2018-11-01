package info;

import java.io.*;
import java.util.*;

public abstract class EventMaker {

    protected Map<User,HashSet<Event>> userList;
    protected HashSet<Event> allEvents;
    //protected int tempEventID;
    protected File eventRecords;
    protected BufferedReader in_events;
    protected PrintWriter out_eventRec;

    //MODIFIES: this
    public EventMaker() //Deals only with User defined Events
    {

        allEvents = new HashSet<>();
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
                allEvents.add(new Event(Integer.parseInt(splitLine[0]),Integer.parseInt(splitLine[1]),splitLine[2],splitLine[3],splitLine[4],splitLine[5]));
                //compare the userID to the ID -> if that's good then we add it to the list
               // if(Integer.parseInt(splitLine[1])==id) //User ID matches the Events
               // {
               //     list.add(new Event(Integer.parseInt(splitLine[0]),Integer.parseInt(splitLine[1]),splitLine[2],splitLine[3],splitLine[4],splitLine[5]));
               // }
                //nameList.add(line);

            }
            in_events.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public abstract void setUserList(User user);

    public HashSet<Event> getUserList(User user) {
        return userList.get(user);
    }

    //MODIFIES: this, eventRecords.txt
    //EFFECTS: Adds an Event to the List
    public void addEvent(int userID, String name, String location, String date, String time)
    {
       try {
           eventRecords = new File("src/info/eventFile/EventsRecords.txt");
           in_events = new BufferedReader(new FileReader(eventRecords));
           out_eventRec = new PrintWriter(new FileOutputStream(eventRecords,true));
           int j = getNewID(in_events);
           allEvents.add(new Event(j,userID,name,location,date,time));
           out_eventRec.append(j+","+userID+","+name+","+location+","+date+","+time+"\n");
           out_eventRec.flush();
       }
       catch (IOException er)
       {
           System.out.println(er.getMessage());
       }
    }

    //EFFECTS: Returns a New ID for Event
    private int getNewID(BufferedReader in_events) throws IOException {//Returns a unique ID that will be used in implementations
        Random rn = new Random();
        ArrayList<Integer> ListOfIDs = new ArrayList<>();
        String line = "";
        while ((line = in_events.readLine()) != null) {
            String[] splitLine = line.split(",");
            ListOfIDs.add(Integer.parseInt(splitLine[0]));
        }
        int value = rn.nextInt(10000);
        while(ListOfIDs.contains(value))
                value = rn.nextInt();
        in_events.close();
        return value;
    }

    //MODIFIES: this, eventsRecords.txt
    //EFFECT: removes event from list
    public void removeEvent(User user, Event event) {
        setUserList(user);
        HashSet<Event> userEvent = getUserList(user);
        for (Event e : userEvent) {
            if ((e.getId() == event.getId()) && (e.getCreator().getUser_Id() == user.getUser_Id())) {
                allEvents.remove(e);
                userEvent.remove(e);
                try {
                    eventRecords = new File("src/info/eventFile/EventsRecords.txt");
                    File temp = new File("src/info/eventFile/temp.txt");
                    PrintWriter out_temp = new PrintWriter(new FileOutputStream(temp, true));
                    out_eventRec = new PrintWriter(new FileOutputStream(eventRecords, false));
                    String line = "";
                    String temp_read = "";
                    in_events = new BufferedReader(new FileReader(eventRecords));
                    BufferedReader in_temp = new BufferedReader(new FileReader(temp));
                    while ((line = in_events.readLine()) != null) {
                        //find the line that we want to change
                        String[] splitLine = line.split(",");
                        if ((Integer.parseInt(splitLine[0]) == event.getId()) && (Integer.parseInt(splitLine[1]) == user.getUser_Id())) {

                        } else {
                            out_temp.append(line + "\n");
                        }

                    }
                    out_temp.flush();
                    while ((line = in_temp.readLine()) != null) {
                        temp_read += (line + "\n");
                    }
                    out_eventRec.write(temp_read);
                    out_eventRec.flush();
                    in_events.close();
                } catch (IOException er) {
                    System.out.println(er.getMessage());
                }

            }
        }
    }

/*
    public void modifyEventName(int eventID, int userID, String name)
    {
        for (Event e: list)
        {
            if((e.getId()==eventID) && (e.getPersonId() == userID))
            {
                e.setName(name);
                try
                {
                    setEventRecords(eventID,userID,e);
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
                    setEventRecords(eventID,userID,e);
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
                    setEventRecords(eventID,userID,e);
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
                   setEventRecords(eventID,userID,e);
                }
                catch(IOException er)
                {
                    System.out.println(er.getMessage());
                }

            }
        }
    }

    public void setEventRecords(int eventID, int userID, Event e) throws IOException
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
*/

}
