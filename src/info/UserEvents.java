package info;

import java.util.ArrayList;
import java.util.HashSet;

public class UserEvents implements EventList{

    User mainUser;
    EventMaker eventMaker; //R/W applet
    ArrayList<Event> createdEvents = new ArrayList<>();

    public UserEvents(User user)
    {
        mainUser = user;
    }

    public void loadEvent()
    {
        HashSet<Event> event = eventMaker.loadEvents(mainUser);
        for (Event e:event) {
            createdEvents.add(e);
        }
    }
    

    @Override
    public ArrayList<Event> displayEvents() {
        return null;
    }
}
