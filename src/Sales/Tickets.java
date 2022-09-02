package Sales;

import java.util.HashMap;
import java.util.Map;

public class Tickets {

    private static Integer MAX_TICKETS = 5;
    private int totalSales = 0;
    private String SCREEN_1;
    private String SCREEN_2;
    private String SCREEN_3;
    private String SCREEN_4;
    private String SCREEN_5;
    private Map<String, Integer> screensInfo;

    public void swapMovies(String[] movieName){
        screensInfo = new HashMap<String, Integer>(){{
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

    public void ticketSale(int amount){
        totalSales += amount;
    }

    public int getTotalSales(){
        return totalSales;
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
    public Map<String, Integer> getInfo(){
        return screensInfo;
    }
}
