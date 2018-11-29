package ui.message_windows;

import info.Event;
import info.EventsBuilder;
import info.User;
import ui.Window;
import ui.menu_windows.EditPartyWindow;
import ui.menu_windows.FindPartiesWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EventInformationWindow extends Window {

    private Event eve;
    public EventInformationWindow(User user, Event event)
    {
        super("Event Information",new ImageIcon(),user);

    }

    @Override
    public void setPanel() {
        panel.setLayout(new FlowLayout());
        ArrayList<JPanel> messageArea = new ArrayList<>();
        JPanel centre = new JPanel(new GridLayout(2,1));
        JTextArea txtArea = new JTextArea(5,10);
        JButton bt = new JButton("OK");
        ArrayList<Event> ev = new ArrayList<>();
        EventsBuilder eb = new EventsBuilder();
        ev = eb.getAllEvents();
        eve = ev.get(0);
        String evee = "Event Id: "+eve.getId()+"\n"+
                "Event Name: "+eve.getName()+"\n"+
                "Event Location: "+eve.getLocation()+"\n"+
                "Event Date: "+eve.getDate()+"\n"+
                "Event Time: "+eve.getTime();
        txtArea.setText(evee);
        txtArea.setEditable(false);
        for(int i=0; i<2; i++)
        {
            messageArea.add(new JPanel());
        }
        messageArea.get(0).add(txtArea);
        messageArea.get(1).add(bt);

        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EventInformationWindow.super.closeWindow();
                start.setVisible(false);
                User m_current_session = current_session;
                new FindPartiesWindow(m_current_session);
            }
        });

        for(JPanel p: messageArea)
        {
            centre.add(p);
        }
        panel.add(centre);

    }
}
