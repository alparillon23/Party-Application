package info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class EventCollection implements EventList {


    HashMap<User,EventList> eventLists;

    public EventCollection()
    {
        eventLists = new HashMap<>();
    }

    public void addEventList(User user, EventList el)
    {
       if(!(eventLists.containsKey(user)))
           eventLists.put(user,el);
    }

    public void removeEvent(User user, EventList el)
    {
        if(eventLists.containsKey(user))
            eventLists.remove(user);
    }

    public UserEvents getEventList(User user)
    {
        return (UserEvents) eventLists.get(user);
    }
    @Override
    public ArrayList<Event> displayEvents() {
        ArrayList<UserEvents> ue = new ArrayList<>();
        ArrayList<Event> events = new ArrayList<>();
        for(EventList el: eventLists.values())
        {
            ue.add((UserEvents) el);
        }
        for(UserEvents e: ue)
        {
            events.addAll(e.displayEvents());
        }
        return events;
    }
}
