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
       else
           eventLists.replace(user,el);
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
    public void displayEvents() {

        for(EventList el: eventLists.values())
        {
            System.out.println("This is Event Collection"+el.toString());

        }

    }
}
