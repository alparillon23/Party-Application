package info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class User {

    private int user_Id;
    private String user_Name;
    private String user_Pass;
    private HashMap<Integer,Event> eOwned;

    //TODO: Add profile information object as more customization is allowed

    public User(int user_Id,String user_Name,String user_Pass)
    {
        this.user_Id = user_Id;
        this.user_Name = user_Name;
        this.user_Pass = user_Pass;
        this.eOwned = new HashMap<>();
    }

    public void loadEvents()
    {
        EventMaker em = new EventMaker(this);
        em.loadEvents(this);
    }
    public void addEvent(int id, Event e)
    {
        eOwned.put(id,e);
        e.setUser(this);
    }

    public void removeEvent(Event e)
    {
        eOwned.remove(e.getId());
        e.setUser(null);
    }
    public void removeEvent(int eventId)
    {
        eOwned.remove(eventId);
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

    public HashMap<Integer, Event> geteOwned() {
        return eOwned;
    }

    public void resetList(HashMap<Integer,Event> events)
    {
        eOwned.clear();
        eOwned = events;
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
