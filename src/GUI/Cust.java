package GUI;
/**
 * Author: Sakai Alexander
 * Date: 9/1/2022
 * File used to handle customer interactions
 */
import java.awt.*;

public class Cust extends Frame{
    public void movieView(){

        Label prompt = new Label("Please choose what movie you would like to see below: ");

        // creating a button
        Button screen1 = new Button("Ponyo");
        Button screen2 = new Button("Scream 2");
        Button screen3 = new Button("Fast and Furious");
        Button screen4 = new Button("Warm Bodies");
        Button screen5 = new Button("Bleach");

        Menu numTickets = new Menu("# of tickets");
        numTickets.add(new MenuItem("1"));
        numTickets.add(new MenuItem("2"));
        numTickets.add(new MenuItem("3"));
        numTickets.add(new MenuItem("4"));
        numTickets.add(new MenuItem("5"));

        // setting button position on screen
        prompt.setBounds(100, 50, 500, 50);
        screen1.setBounds(60,200,80,30);
        screen2.setBounds(160,200,80,30);
        screen3.setBounds(260,200,80,30);
        screen4.setBounds(360,200,80,30);
        screen5.setBounds(460,200,80,30);

        // adding button into frame
        add(screen1);
        add(screen2);
        add(screen3);
        add(screen4);
        add(screen5);
        add(prompt);


        // frame size 300 width and 300 height
        setSize(700,500);

        // setting the title of Frame
        setTitle("Welcome to the Theaters!");

        // no layout manager
        setLayout(null);

        // now frame will be visible, by default it is not visible
        setVisible(true);
    }

    public static void main(String[] args) {
        Cust start = new Cust();
        start.movieView();
    }
}
