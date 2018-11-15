package ui.menu_windows;

import info.User;
import ui.Window;

import javax.swing.*;
import java.awt.*;

public class EditPartyWindow extends Window {

    public EditPartyWindow(User user)
    {
        super("Change Up The Party",new ImageIcon(),user);
    }

    @Override
    public void setPanel() {
        LayoutManager box = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(box);
        JPanel grid = new JPanel();

        grid.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        JButton prev = new JButton("<<"); JButton next = new JButton(">>");
        JLabel namelabel = new JLabel("Name of Party"); JTextField name = new JTextField(20); name.setMaximumSize(new Dimension(200,10));
        JLabel locationlabel = new JLabel("Location");  JTextField location = new JTextField(20); location.setMaximumSize(new Dimension(200,10));
        JLabel datelabel = new JLabel("Date"); JTextField date = new JTextField(20); date.setMaximumSize(new Dimension(200,10));
        JLabel timelabel = new JLabel("Time"); JTextField time = new JTextField(20); time.setMaximumSize(new Dimension(200,10));
        JButton editEvent = new JButton("Edit Party"); JButton removeEvent = new JButton("Delete Party"); JButton cancelEditEvent = new JButton("Cancel");


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.ipadx = 1;
        grid.add(prev,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 5;
        gbc.gridy = 1;
        //gbc.gridwidth = 3;
        grid.add(next,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        grid.add(namelabel,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        grid.add(name,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        grid.add(locationlabel,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 5;
        grid.add(location,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        grid.add(datelabel,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        grid.add(date,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        grid.add(timelabel,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 5;
        grid.add(time,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        grid.add(editEvent,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        grid.add(removeEvent,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 5;
        gbc.gridy = 6;
        //gbc.gridwidth = 3;
        grid.add(cancelEditEvent,gbc);

        panel.add(grid);

        start.setVisible(true);
    }
}
