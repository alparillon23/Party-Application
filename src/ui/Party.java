package ui;

public class Party {

    private String userName;

    //constructor - only userName is a declared field for now
    public Party(String name)
    {
        this.userName = name;
    }

    //Get method - returns field required
    String getName()
    {
        return this.userName;
    }

}
