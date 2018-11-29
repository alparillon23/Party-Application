package info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class User {

    private int user_Id;
    private String user_Name;
    private String user_Pass;
    private EventsJoined eventsJoined;
    private EventsOwned eventsOwned;


    //TODO: Add profile information object as more customization is allowed

    public User(int user_Id,String user_Name,String user_Pass)
    {
        this.user_Id = user_Id;
        this.user_Name = user_Name;
        this.user_Pass = user_Pass;
        eventsJoined = new EventsJoined(user_Id);
        eventsOwned = new EventsOwned(user_Id);
    }


    public void addEvent(Event e)
    {
       eventsOwned.addEvent(user_Id,e);
       eventsOwned.refresh();
    }
    public void removeEvent(Event e)
    {
        eventsOwned.removeEvent(user_Id,e);
        eventsOwned.refresh();
    }
    public void editEvent(Event e)
    {
        eventsOwned.editEvent(user_Id,e);
        eventsOwned.refresh();
    }
    public void joinEvent(Event e)
    {
        eventsJoined.joinEvent(user_Id,e);
        eventsJoined.rewriteGuests();
    }

    public void unJoinEvent(Event e)
    {
        eventsJoined.unJoinEvent(user_Id,e);
        eventsJoined.rewriteGuests();
    }

    public EventsJoined getEventsJoined() {
        return eventsJoined;
    }

    public EventsOwned getEventsOwned() {
        return eventsOwned;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public void setUser_Pass(String user_Pass) {
        this.user_Pass = user_Pass;
    }

    public String getUser_Pass() {
        return user_Pass;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public ArrayList<Event> getOwnersList()
    {
        ArrayList<Event> ev = new ArrayList<>();
        for(Event e: eventsOwned)
        {
            ev.add(e);
        }
        return ev;
    }

    public ArrayList<Event> getJoinedList()
    {
        ArrayList<Event> ev = new ArrayList<>();
        for(Event e: eventsJoined)
        {
            ev.add(e);
        }
        return ev;
    }


    public User getUser(String name)
    {
        return (new User(user_Id,user_Name,user_Pass));
    }

    public boolean pass_Match(String uname, String upass)
    {
        return (user_Name.equals(uname)&&user_Pass.equals(upass));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(user_Name, user.user_Name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user_Name);
    }
}
