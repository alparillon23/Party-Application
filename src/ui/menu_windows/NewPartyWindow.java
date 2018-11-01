package ui.menu_windows;

import info.User;
import ui.Window;

import javax.swing.*;

public class NewPartyWindow extends Window {

    public NewPartyWindow(User user)
    {
        super("Add Party",new ImageIcon(),user);
    }

    @Override
    public void setPanel() {

    }
}
