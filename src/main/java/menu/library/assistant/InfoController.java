package menu.library.assistant;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
        this.openWindow("Add Member", "addmember.fxml",370,350);
    }

    @FXML
    public void onButtonAddBookClicked(ActionEvent event)
    {
        this.openWindow("Add Book","addbook.fxml", 370, 340);
    }

    @FXML
    public void onButtonMemberListClicked(ActionEvent event)
    {
        this.openWindow("Member List","memberlist.fxml", 840, 390);
    }

    @FXML
    public void onButtonBookListController(ActionEvent event)
    {
        this.openWindow("Book List", "bookList.fxml", 840, 390);
    }

    @FXML
    public void onButtonReservationClicked(ActionEvent event)
    {
        this.openWindow("Reservation", "reservation.fxml", 1000, 600);
    }

    private void openWindow(String title, String fxmlFile, int x, int y)
    {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/"+fxmlFile));
            Scene scene = new Scene(root, x, y);
            scene.getStylesheets().add(getClass().getResource("/stylesheet.css").toExternalForm());
            primaryStage.setTitle(title);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Can not load new window");
        }
    }







}
