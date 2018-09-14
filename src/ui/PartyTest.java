package ui;

import java.util.*;


public class PartyTest {


    public static void main(String[] args) {
        //accepts users input in console
        Scanner input = new Scanner(System.in);

        //Print messages as required by deliverable P1
        System.out.println("Welcome to PARTY! What's your name?");
        Party user = new Party(input.nextLine()); //New user created with the name as the field

        //These are two ways of implementing print statements
        // through methods - 1. Passing the entire object as an argument
        // and               2. Passing the objects field as an argument
        normalMessage(user);
        fancyText(user.getName()); //Spaced out text greeting
    }


    //Returns the information (name)
    private static void normalMessage(Party name) {

        System.out.println("Hello "+ name.getName() +", let's Party!");
    }

    //Manipulating the String - Just for Fun
    private static void fancyText(String name)
    {
        System.out.println("I T ' S P A R T Y T I M E ");
        String upperName = name.toUpperCase();
        for(int n=0; n<upperName.length(); n++)
        {
            System.out.print(upperName.charAt(n)+" ");
        }
        System.out.println("! ! !");

    }

}
