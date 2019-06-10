package menu.library.assistant;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        LocalDate date = LocalDate.now();
        date = date.plusMonths(1);
        long nextmonth = date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(LocalDate.ofInstant(Instant.ofEpochMilli(nextmonth), ZoneId.systemDefault()));


        Parent root= FXMLLoader.load(getClass().getResource("/menu.fxml"));
        Scene scene = new Scene(root,1300,600);
        scene.getStylesheets().add(getClass().getResource("/stylesheet.css").toExternalForm());
        primaryStage.setTitle("Library Assistant");
        primaryStage.setScene(scene);
        primaryStage.show();



    }

    public static void main(String[] args){
        launch(args);
    }


}
