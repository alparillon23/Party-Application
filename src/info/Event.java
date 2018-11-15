package info;

import java.util.List;
import java.util.Objects;

public class Event {

    //HIGH COHESION - DEALS WITH THE EVENT
    //MODERATE COUPLING - REQUIRES ONLY USER ID OR USER A CHANGE IN THIS
    //
    private int id; //MODIFY ONLY ONCE (TO GET THE ID)
    private User creator; //DON'T MODIFY
    private int creatorId; //DON'T MODIFY
    private String name; //MODIFY
    private String location; //MODIFY
    private String date; //MODIFY
    private String time; //MODIFY


    public Event(int id_event, User user, String name_event, String location_event, String date_event, String time_event)
    {
        id = id_event;
        creator = user;
        creatorId = user.getUser_Id();
        name = name_event;
        location = location_event;
        date = date_event;
        time = time_event;
    }

    public Event(int id_event, int user_id, String name_event, String location_event, String date_event, String time_event)
    {
        id = id_event;
        creatorId = id;
        SignIn s = new SignIn();
        for(User u: s.userList)
        {
            if(u.getUser_Id()==user_id)
                creator = u;
        }
        name = name_event;
        location = location_event;
        date = date_event;
        time = time_event;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public void setName(String name_event)
    {
        name = name_event;
    }
    public void setLocation(String location_event)
    {
        location = location_event;
    }
    public void setDate(String date_event)
    {
        date = date_event;
    }
    public void setTime(String time_event)
    {
        time = time_event;
    }
    public int getId()
    {
        return id;
    }
    public User getCreator()
    {
        return creator;
    }
    public String getName()
    {
        return name;
    }
    public String getLocation()
    {
        return location;
    }
    public String getDate()
    {
        return date;
    }
    public String getTime()
    {
        return time;
    }

    public String eventInformation()
    {
        return (id+","+creatorId+","+name+","+location+","+date+","+time);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public void setUser(User user) {
        this.creator = user;
    }
}
