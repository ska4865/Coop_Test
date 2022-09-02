package Sales;

import java.util.ArrayList;

public class Tickets {

    private static int MAX_TICKETS = 10;
    private int totalSales = 0;
    private static String SCREEN_1;
    private static String SCREEN_2;
    private static String SCREEN_3;
    private static String SCREEN_4;
    private static String SCREEN_5;

    public void swapMovies(ArrayList<String> movieName){
        SCREEN_1 = movieName.get(0);
        SCREEN_2 = movieName.get(1);
        SCREEN_3 = movieName.get(2);
        SCREEN_4 = movieName.get(3);
        SCREEN_5 = movieName.get(4);

    }

    public void ticketSale(int amount){
        totalSales += amount;
    }

    public int getTotalSales(){
        return totalSales;
    }

    public static String getSCREEN_1() {
        return SCREEN_1;
    }
    public static String getSCREEN_2() {
        return SCREEN_2;
    }
    public static String getSCREEN_3() {
        return SCREEN_3;
    }
    public static String getSCREEN_4() {
        return SCREEN_4;
    }
    public static String getSCREEN_5() {
        return SCREEN_5;
    }
}
