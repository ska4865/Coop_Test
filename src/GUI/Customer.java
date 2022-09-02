package GUI;
/**
 * Author: Sakai Alexander
 * Date: 9/1/2022
 * File used to handle customer interactions
 */
import Sales.Tickets;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class Customer extends Application{
    private String customer_input;

    public void init(){
        String stu = Tickets.getSCREEN_1();
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bPane = new BorderPane();
        bPane.setTop(new Text("Choose what movie you would like"));

        BorderPane bPaneCenter = new BorderPane();
        bPane.setCenter(bPaneCenter);

        Button eh = new Button();

        Button screen1 = new Button("ponyo");

        Button screen2 = new Button("Tickets.getSCREEN_2()");
        Button screen3 = new Button("Tickets.getSCREEN_3()");
        Button screen4 = new Button("Tickets.getSCREEN_4()");
        Button screen5 = new Button("Tickets.getSCREEN_5()");

        /*GridPane gPane = new GridPane();
        bPane.setLeft(screen1);
        gPane.add(screen1, 0, 0);
        gPane.add(screen2, 0, 1);
        gPane.add(screen3, 0, 2);
        gPane.add(screen4, 0, 3);
        gPane.add(screen5, 0, 4);*/

        Scene scene = new Scene(bPane, 700, 500);
        stage.setScene(scene);
        stage.setTitle("Welcome to the movies!");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
