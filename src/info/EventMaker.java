package info;

import java.io.*;
import java.util.*;

public class EventMaker {
    //HIGH COUPLING
    //LOW COHESION
    //SOLVED THE PROBLEM OF APPLYING CHANGES TO THE PART OF SETS BY COMBINING USER AND EVENT AS PARAMETERS
    //AND DRAWING THEIR ADD FUNCTIONS IN UNISON
    //SUBTYPES ARE ALL SUBSTITUTABLE - BUT THIS IS NOT WARRANTED HERE
    //FIND EVEENTS FROM DOCUMENT, LOADS EVENTS FOR USERS, LOADS ALL EVENTS, ADDS EVENTS

   // protected Map<User,HashSet<Event>> userList;
    protected HashSet<Event> allEvents;
    protected User userMain;
    protected File eventRecords;
    protected BufferedReader in_events;
    protected PrintWriter out_eventRec;
    protected EventCollection ec;
    protected UserEvents ue;
    protected ArrayList<Integer> userList ;
    protected ArrayList<Event> eventList ;
    protected EventCollection evc;
    //MODIFIES: this
    public EventMaker(User user) //Deals only with User defined Events
    {
        userMain = user;
        evc = new EventCollection();
        userList = new ArrayList<>();
        eventList = new ArrayList<>() ;
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
                Event event = new Event(Integer.parseInt(splitLine[0]),Integer.parseInt(splitLine[1]),splitLine[2],splitLine[3],splitLine[4],splitLine[5]);
                allEvents.add(event);
                if(!(userMain.geteOwned().containsKey(event.getId())))
                {
                    if(userMain.getUser_Id()== Integer.parseInt(splitLine[1]))
                    {
                        userMain.addEvent(Integer.parseInt(splitLine[0]),event);
                        eventList.add(event);
                    }
                }
                if(!(userList.contains(Integer.parseInt(splitLine[1]))))
                    userList.add(Integer.parseInt(splitLine[1]));


                }

            ue = new UserEvents(userMain,eventList);
            evc.addEventList(userMain,ue);
            evc.displayEvents();
            in_events.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public HashSet<Event> getAllEvents() {
        return allEvents;
    }

    public HashSet<Event> loadEvents(User user)
    {
      HashMap<Integer,Event> userEvents = new HashMap<>();
      try {
          eventRecords = new File("src/info/eventFile/EventsRecords.txt");
          in_events = new BufferedReader(new FileReader(eventRecords));
          String line = "";
          while ((line = in_events.readLine()) != null) {
              String[] splitLine = line.split(",");
              if(Integer.parseInt(splitLine[1]) == user.getUser_Id())
                  userEvents.put(Integer.parseInt(splitLine[0]),new Event(Integer.parseInt(splitLine[0]),user,splitLine[2],splitLine[3],splitLine[4],splitLine[5]));

          }
          user.resetList(userEvents);
          in_events.close();
          HashSet<Event> userEven = new HashSet<>();
          userEven.addAll(userEvents.values());
          return userEven;
      }
      catch(IOException e)
      {
          e.getMessage();
          return null;
      }
    }

    //MODIFIES: this, eventRecords.txt
    //EFFECTS: Adds an Event to the List
    public void addEvent(User user, Event event) {
        try{

           eventRecords = new File("src/info/eventFile/EventsRecords.txt");
           in_events = new BufferedReader(new FileReader(eventRecords));
           out_eventRec = new PrintWriter(new FileOutputStream(eventRecords,true));
           event.setId(getNewID(in_events));
           user.addEvent(event.getId(),event);
           allEvents.add(event);
           out_eventRec.append(event.eventInformation()+"\n");
           out_eventRec.flush();
           in_events.close();
       }
       catch (IOException er)
       {
           System.out.println(er.getMessage());
       }
    }

    public void removeEvent(User user, Event event) {
        try{
            eventRecords = new File("src/info/eventFile/EventsRecords.txt");
            createList(eventRecords);
            removeFromList(user,event);
            updateListDoc(eventRecords);
        }
        catch (IOException er)
        {
            System.out.println(er.getMessage());
        }

    }

    private void createList(File eventRecords) throws IOException
    {
        in_events = new BufferedReader(new FileReader(eventRecords));
        String line = "";
        allEvents.clear();
        while((line = in_events.readLine()) != null) {
            String[] splitLine = line.split(",");
            allEvents.add(new Event(Integer.parseInt(splitLine[0]),Integer.parseInt(splitLine[1]),splitLine[2],splitLine[3],splitLine[4],splitLine[5]));
        }
        in_events.close();
    }

    private void removeFromList(User user, Event event)
    {
        for(Event e: allEvents)
        {
            if((user.getUser_Id() == e.getCreator().getUser_Id())&&(event.getId()==e.getId()))
            {
                allEvents.remove(e);
                user.removeEvent(event.getId());
            }
        }
    }

    private void updateListDoc(File eventRecords) throws IOException
    {
        out_eventRec = new PrintWriter(new FileOutputStream(eventRecords,false));
        String eventRec = "";
        for(Event e: allEvents)
        {
            eventRec += (e.eventInformation()+"\n");
        }
        out_eventRec.write(eventRec);
        out_eventRec.flush();
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
    /*
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
