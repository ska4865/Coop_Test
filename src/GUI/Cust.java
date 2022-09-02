package GUI;
/*
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
    private Label label = new Label();
    private Label visibleResponse = new Label ();

    /**
     * Initializes the tickets class so it can be used globally and updates the movie names of each screen
     */
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

    /**
     * separated for an easier reading of movieView
     * It adds listeners and handles closing the program at the end of the day
     */
    public void events(){
        //Adding listeners to track events
        screen1.addActionListener(new ButtonClickListener());
        screen2.addActionListener(new ButtonClickListener());
        screen3.addActionListener(new ButtonClickListener());
        screen4.addActionListener(new ButtonClickListener());
        screen5.addActionListener(new ButtonClickListener());

        //Will close the program at the end of the day
        //And print the report on tickets and screenings
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                tix.getTotalSales();
                System.exit(0);
            }
        });
    }

    /**
     * Creates the frames, buttons and windows that the customer will use and interact on a window
     */
    public void movieView() {

        Label prompt = new Label("Please choose what movie you would like to see below: ");

        // creating a button
        screen1 = new Button(tix.getSCREEN_1());
        screen2 = new Button(tix.getSCREEN_2());
        screen3 = new Button(tix.getSCREEN_3());
        screen4 = new Button(tix.getSCREEN_4());
        screen5 = new Button(tix.getSCREEN_5());

        Label ticketLabel = new Label("# of Tickets you desire:");
        numTickets = new List(6);
        numTickets.add("1");
        numTickets.add("2");
        numTickets.add("3");
        numTickets.add("4");
        numTickets.add("5");

        // setting button position on screen
        prompt.setBounds(150, 50, 500, 50);
        screen1.setBounds(70, 200, 80, 30);
        screen2.setBounds(170, 200, 80, 30);
        screen3.setBounds(270, 200, 80, 30);
        screen4.setBounds(370, 200, 80, 30);
        screen5.setBounds(470, 200, 80, 30);
        numTickets.setBounds(360, 300, 50, 50);
        ticketLabel.setBounds(330, 260, 150, 50);

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

        // frame size 700 width and 500 height
        setSize(700, 500);

        // setting the title of Frame
        setTitle("Welcome to the Movie Theater!");

        // no layout manager
        setLayout(null);

        // now frame will be visible, by default it is not visible
        setVisible(true);

        // adds the listeners to each button
        events();

    }

    /**
     * Button event handler class created here for easier development.
     * Knowingly not the best practice, but was satisfactory for the scale
     * of the problem
     */
    public class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = e.getActionCommand(); //name represents the name of the movie/what screen

            label.setText("Amount of Tickets left: " +
                    screenInfo.get(name).toString());

            if(numTickets.getSelectedItem() != null){ //needed to prevent throwing an error when just
                                                        //calling ticketsale

                String response = tix.ticketSale(Integer.parseInt(numTickets.getSelectedItem()), name);
                visibleResponse.setText(response);
                remove(visibleResponse);  /* removes the component so the updated version can be added*/
                revalidate();
                repaint(); /* refreshes the window */
                visibleResponse.setText(response);
                visibleResponse.setBounds(130, 150, 400, 50);
                visibleResponse.setBackground(Color.RED);
                add(visibleResponse);

            }
            remove(label);
            revalidate();
            repaint();
            numTickets.deselect(numTickets.getSelectedIndex()); /*deselects from the list so unintentional tickets
                                                                     aren't purchased*/
            label.setText("Amount of Tickets left: " +
                    screenInfo.get(name).toString());  //updates the amount of tickets left for a screening

            label.setBounds(150, 300, 150, 50);

            add(label);

        }
    }
}
