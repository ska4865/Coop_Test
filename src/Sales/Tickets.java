package Sales;

import java.util.HashMap;
import java.util.Map;

/**
 * Liberties, Assumptions and Flaws: This code is built assuming the customer will not make
 * wrong choices with the exception of buying non existent tickets. In order to "lock in"
 * the customers choice for both movie and tickets they must also click on the movie after
 * choosing the amount of tickets. Meaning first click on movie -> amount of tix available,
 * clicks on number of tickets -> no change, click on movie -> data is updated.
 *
 * The day is considered complete when the window is closed and the report is printed via
 * terminal.
 *
 * On a side note I did have to change from javafx to awt because of pathing issues so
 * if there are remnants of javafx I didn't catch, that's why they're there in the first place
 */

public class Tickets {

    private static Integer MAX_TICKETS = 5; /*It wasn't specified how many tickets so I
                                                made it 5 to make it easier on myself*/
    private int totalSales = 0;
    private String SCREEN_1;
    private String SCREEN_2;
    private String SCREEN_3;
    private String SCREEN_4;
    private String SCREEN_5;
    private Map<String, Integer> screensInfo;
    private Map<String, Integer> salesInfo = new HashMap<>();

    /**
     * allows the movies on each screen to be update.
     * I wasn't sure if it was a "it needs to change thoughout the day" thing
     * or a it'll change when all the movies are out/end of the day so I provided
     * the possibility but used hardcoded values when calling the function
     * @param movieName array of string with the names of the movies that will showing
     *                  this is with the assumption that index 0 of the array corresponds
     *                  with screen_1 etc.
     */
    public void swapMovies(String[] movieName){
        screensInfo = new HashMap<>(){{
            put(movieName[0], MAX_TICKETS);
            put(movieName[1], MAX_TICKETS);
            put(movieName[2], MAX_TICKETS);
            put(movieName[3], MAX_TICKETS);
            put(movieName[4], MAX_TICKETS);
        }};

        SCREEN_1 = movieName[0];
        SCREEN_2 = movieName[1];
        SCREEN_3 = movieName[2];
        SCREEN_4 = movieName[3];
        SCREEN_5 = movieName[4];
    }

    /**
     * updates the total sales every time a purchase is made
     * prevents customers from buying tickets that don't exist
     * and doesn't count those non-existant tickets
     * @param amount the amount of tickets sold in the one transaction for one screening
     * @param screen the name of the movie the the tickets were purchased for
     * @return a string showing insight to how the customers transaction went/if it went through
     */
    public String ticketSale(int amount, String screen){

        int remainder = screensInfo.get(screen) - amount;
        if(remainder < 0){
            return "Please lower the amount of tickets or choose a different screening";
        }
        else{
            totalSales += amount;
            salesInfo.merge(screen, amount, Integer::sum);/*adds or updates the map of the sales
                                                                information for the day*/
            screensInfo.put(screen, remainder); //updates the remaining amount of tickets a customer can buy
            return "Success! Enjoy the movie!";
        }
    }

    /**
     * gets, calculates and returns the report on sales for the day
     * the information is sent to the command line because the
     * GUI is technically a customer interface and not meant to the "team"
     */
    public void getTotalSales(){
        System.out.println("Detailed report: ");
        for(String movie: salesInfo.keySet()){
            System.out.println(movie + " sold " + salesInfo.get(movie) + " tickets ");
        }
        System.out.print("Total ticket sales today: ");
        System.out.println(totalSales);
    }

    public String getSCREEN_1() {
        return SCREEN_1;
    }
    public String getSCREEN_2() {
        return SCREEN_2;
    }
    public String getSCREEN_3() {
        return SCREEN_3;
    }
    public String getSCREEN_4() {
        return SCREEN_4;
    }
    public String getSCREEN_5() {
        return SCREEN_5;
    }

    /**
     * returns the instance of the map so it can be viewed outside of the class
     * @return map of strings to integers with the keys being the string names
     * of each movie
     */
    public Map<String, Integer> getInfo(){
        return screensInfo;
    }
}
