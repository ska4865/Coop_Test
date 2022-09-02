package GUI;
/**
 * Author: Sakai Alexander
 * Date: 9/1/2022
 * File used to handle customer interactions
 */
import Sales.Tickets;

import java.awt.*;

public class Cust extends Frame{
    Tickets tix = new Tickets();
    public void movieView(){

        Label prompt = new Label("Please choose what movie you would like to see below: ");

        // creating a button
        Button screen1 = new Button(tix.getSCREEN_1());
        Button screen2 = new Button(tix.getSCREEN_2());
        Button screen3 = new Button(tix.getSCREEN_3());
        Button screen4 = new Button(tix.getSCREEN_4());
        Button screen5 = new Button(tix.getSCREEN_5());

        List numTickets = new List(10);
        numTickets.add("1");
        numTickets.add("2");
        numTickets.add("3");
        numTickets.add("4");
        numTickets.add("5");

        // setting button position on screen
        prompt.setBounds(100, 50, 500, 50);
        screen1.setBounds(60,200,80,30);
        screen2.setBounds(160,200,80,30);
        screen3.setBounds(260,200,80,30);
        screen4.setBounds(360,200,80,30);
        screen5.setBounds(460,200,80,30);
        numTickets.setBounds(300,300,80,50);

        // adding button into frame
        add(screen1);
        add(screen2);
        add(screen3);
        add(screen4);
        add(screen5);
        add(prompt);
        add(numTickets);


        // frame size 300 width and 300 height
        setSize(700,500);

        // setting the title of Frame
        setTitle("Welcome to the Theaters!");

        // no layout manager
        setLayout(null);

        // now frame will be visible, by default it is not visible
        setVisible(true);
    }

    public void init(){
        String[] movieNames = {"Ponyo", "Bleach", "Fast&Furious", "2012","Scream 2"};
        tix.swapMovies(movieNames);
    }

    public static void main(String[] args) {
        Cust start = new Cust();
        start.init();
        start.movieView();
    }
}
