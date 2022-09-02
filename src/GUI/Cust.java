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
    private Button screen1;
    private Button screen2;
    private Button screen3;
    private Button screen4;
    private Button screen5;
    private Button done;

    public void init() {
        tix = new Tickets();
        String[] movieNames = {"Ponyo", "Bleach", "Fast&Furious", "2012", "Scream 2"};
        tix.swapMovies(movieNames);
        screenInfo = tix.getInfo();
    }

    public static void main(String[] args) {
        Cust start = new Cust();
        start.init();
        start.movieView();
    }

    public void events(){
        //Adding listeners to track events
        screen1.addActionListener(new ButtonClickListener());
        screen2.addActionListener(new ButtonClickListener());
        screen3.addActionListener(new ButtonClickListener());
        screen4.addActionListener(new ButtonClickListener());
        screen5.addActionListener(new ButtonClickListener());
        done.addActionListener(new ButtonClickListener());

        //Will close the program at the end of the day
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void movieView() {

        Label prompt = new Label("Please choose what movie you would like to see below: ");

        // creating a button
        screen1 = new Button(tix.getSCREEN_1());
        screen2 = new Button(tix.getSCREEN_2());
        screen3 = new Button(tix.getSCREEN_3());
        screen4 = new Button(tix.getSCREEN_4());
        screen5 = new Button(tix.getSCREEN_5());
        done = new Button("Purchase");

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
        done.setBounds(600, 440, 60, 50);

        // adding components to frame
        add(screen1);
        add(screen2);
        add(screen3);
        add(screen4);
        add(screen5);
        add(prompt);
        add(numTickets);
        add(ticketLabel);
        add(done);

        //commands to keep track of what ticket is being used for what movie
        screen1.setActionCommand(tix.getSCREEN_1());
        screen2.setActionCommand(tix.getSCREEN_2());
        screen3.setActionCommand(tix.getSCREEN_3());
        screen4.setActionCommand(tix.getSCREEN_4());
        screen5.setActionCommand(tix.getSCREEN_5());
        done.setActionCommand("done");

        // frame size 300 width and 300 height
        setSize(700, 500);

        // setting the title of Frame
        setTitle("Welcome to the Movie Theater!");

        // no layout manager
        setLayout(null);

        // now frame will be visible, by default it is not visible
        setVisible(true);

        events();

    }

    public class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = e.getActionCommand();
            Label label = new Label();

            if (!name.equals("done")){
                label.setText("Amount of Tickets left: " +
                        screenInfo.get(name).toString());
                System.out.println(screenInfo.get(name));
                tix.ticketSale(Integer.parseInt(numTickets.getSelectedItem()), name);
                System.out.println(screenInfo.get(name));
                label.setText("Amount of Tickets left: " +
                        screenInfo.get(name).toString());

            }


            /*if (name.equals(tix.getSCREEN_1())) {
                label.setText("Amount of Tickets left: " +
                        screenInfo.get(tix.getSCREEN_1()).toString());
                tix.ticketSale(Integer.parseInt(numTickets.getSelectedItem()), tix.getSCREEN_1());

            } else if (name.equals(tix.getSCREEN_2())) {
                label.setText("Amount of Tickets left: " +
                        screenInfo.get(tix.getSCREEN_2()).toString());
                tix.ticketSale(Integer.parseInt(numTickets.getSelectedItem()), tix.getSCREEN_2());

            } else if (name.equals(tix.getSCREEN_3())) {
                label.setText("Amount of Tickets left: " +
                        screenInfo.get(tix.getSCREEN_3()).toString());
                tix.ticketSale(Integer.parseInt(numTickets.getSelectedItem()), tix.getSCREEN_3());

            } else if (name.equals(tix.getSCREEN_4())) {
                label.setText("Amount of Tickets left: " +
                        screenInfo.get(tix.getSCREEN_4()).toString());
                tix.ticketSale(Integer.parseInt(numTickets.getSelectedItem()), tix.getSCREEN_4());

            } else {
                label.setText("Amount of Tickets left: " +
                        screenInfo.get(tix.getSCREEN_5()).toString());
                tix.ticketSale(Integer.parseInt(numTickets.getSelectedItem()), tix.getSCREEN_5());

            }*/
            label.setBounds(150, 300, 150, 50);

            remove(label);
            add(label);

        }
    }
}
