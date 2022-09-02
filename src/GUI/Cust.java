package GUI;
/**
 * Author: Sakai Alexander
 * Date: 9/1/2022
 * File used to handle customer interactions
 */
import Sales.Tickets;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

public class Cust extends Frame {

    protected Tickets tix;
    private List numTickets;
    private Map<String, Integer> screenInfo;

    public Tickets init() {
        tix = new Tickets();
        String[] movieNames = {"Ponyo", "Bleach", "Fast&Furious", "2012", "Scream 2"};
        tix.swapMovies(movieNames);
        screenInfo = tix.getInfo();
        return tix;
    }

    public void movieView() {

        Label prompt = new Label("Please choose what movie you would like to see below: ");

        // creating a button
        Button screen1 = new Button(tix.getSCREEN_1());
        Button screen2 = new Button(tix.getSCREEN_2());
        Button screen3 = new Button(tix.getSCREEN_3());
        Button screen4 = new Button(tix.getSCREEN_4());
        Button screen5 = new Button(tix.getSCREEN_5());

        Label ticketLabel = new Label("# of Tickets you desire:");
        numTickets = new List(6);
        numTickets.add("1");
        numTickets.add("2");
        numTickets.add("3");
        numTickets.add("4");
        numTickets.add("5");

        // setting button position on screen
        prompt.setBounds(100, 50, 500, 50);
        screen1.setBounds(60, 200, 80, 30);
        screen2.setBounds(160, 200, 80, 30);
        screen3.setBounds(260, 200, 80, 30);
        screen4.setBounds(360, 200, 80, 30);
        screen5.setBounds(460, 200, 80, 30);
        numTickets.setBounds(330, 300, 50, 50);
        ticketLabel.setBounds(300, 260, 150, 50);

        // adding components to frame
        add(screen1);
        add(screen2);
        add(screen3);
        add(screen4);
        add(screen5);
        add(prompt);
        add(numTickets);
        add(ticketLabel);

        //commands to keep track of what ticket is being used for what movie
        screen1.setActionCommand(tix.getSCREEN_1());
        screen2.setActionCommand(tix.getSCREEN_2());
        screen3.setActionCommand(tix.getSCREEN_3());
        screen4.setActionCommand(tix.getSCREEN_4());
        screen5.setActionCommand(tix.getSCREEN_5());

        //Adding listeners to track events
        screen1.addActionListener(new ButtonClickListener());
        screen2.addActionListener(new ButtonClickListener());
        screen3.addActionListener(new ButtonClickListener());
        screen4.addActionListener(new ButtonClickListener());
        screen5.addActionListener(new ButtonClickListener());
        numTickets.addActionListener(new ButtonClickListener());



        // frame size 300 width and 300 height
        setSize(700, 500);

        // setting the title of Frame
        setTitle("Welcome to the Movie Theater!");

        // no layout manager
        setLayout(null);

        // now frame will be visible, by default it is not visible
        setVisible(true);

        //Will close the program at the end of the day
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        Cust start = new Cust();
        start.init();
        start.movieView();
    }

    public class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = e.getActionCommand();
            Label label = new Label();
            if (name.equals(tix.getSCREEN_1())) {
                System.out.print(screenInfo);
                label.setText("Amount of Tickets left: " +
                        screenInfo.get(tix.getSCREEN_1()).toString());
                numTickets.getSelectedItem();


            } else if (name.equals(tix.getSCREEN_2())) {
                label.setText("df");
            } else if (name.equals(tix.getSCREEN_3())) {
                label.setText("asd");
            } else if (name.equals(tix.getSCREEN_4())) {
                label.setText("omv");
            } else {
                label.setText("five");
            }
            label.setBounds(150, 300, 150, 50);

            remove(label);
            add(label);

        }
    }
}
