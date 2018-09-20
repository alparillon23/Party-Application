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

    public String fancyText()
    {
        String upperName = userName.toUpperCase();
        String message = "I T ' S P A R T Y T I M E ";

        for(int n=0; n<upperName.length(); n++)
        {
            message += (upperName.charAt(n)+" ");
        }

        message += ("! ! !");
        return message;

    }

}
