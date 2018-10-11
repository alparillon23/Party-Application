package info;

public class Event {

    private int id; //DON'T MODIFY
    private int personId; //DON'T MODIFY
    private String name; //MODIFY
    private String location; //MODIFY
    private String date; //MODIFY
    private String time; //MODIFY

    public Event(int id_event, int id_user, String name_event, String location_event, String date_event, String time_event)
    {
        id = id_event;
        personId = id_user;
        name = name_event;
        location = location_event;
        date = date_event;
        time = time_event;
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
    public int getPersonId()
    {
        return personId;
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

}
