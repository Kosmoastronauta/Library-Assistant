package menu.library.assistant;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.time.LocalDate;


public class InfoController {

    private static InfoController instance;
    @FXML
    private TextField bookFieldTitle;
    @FXML
    private TextField bookFieldAuthor;

    @FXML
    private TextField bookFieldId;

    @FXML
    private Label Day;

    @FXML
    private Label DayOfWeek;

    @FXML
    private Label Month;

    public InfoController()
    {
        instance = this;
    }

    public InfoController getInstance()
    {
        return instance;
    }


    @FXML
    public void onButtonSearchClicked(ActionEvent e)
    {
            System.out. println(bookFieldTitle.getText());
    }

    @FXML
    public void initialize()
    {
        LocalDate date = LocalDate.now();

        Day.setText(Integer.toString(date.getDayOfMonth()));
        DayOfWeek.setText(date.getDayOfWeek().name());
        Month.setText(date.getMonth().name());
    }

    @FXML
    public void onButtonAddMemberClicked(ActionEvent event)
    {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/addmember.fxml"));
            Scene scene = new Scene(root, 370, 350);
            scene.getStylesheets().add(getClass().getResource("/stylesheet.css").toExternalForm());
            primaryStage.setTitle("Add Member");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Can not load new window");
        }
    }

    @FXML
    public void onButtonAddBookClicked(ActionEvent event)
    {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/addbook.fxml"));
            Scene scene = new Scene(root, 370, 340);
            scene.getStylesheets().add(getClass().getResource("/stylesheet.css").toExternalForm());
            primaryStage.setTitle("Add Book");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Can not load new window");
        }
    }

    @FXML
    public void onButtonMemberListClicked(ActionEvent event)
    {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/memberlist.fxml"));
            Scene scene = new Scene(root, 840, 390);
            scene.getStylesheets().add(getClass().getResource("/stylesheet.css").toExternalForm());
            primaryStage.setTitle("Member List");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Can not load new window");
        }
    }





}
