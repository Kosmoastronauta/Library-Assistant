package menu.library.assistant;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;


public class InfoController {
    @FXML
    private TextField bookFieldTitle;
    @FXML
    private TextField bookFieldAuthor;

    @FXML
    private TextField bookFieldId;

    @FXML
    public void onButtonSearchClicked(ActionEvent e)
        {
            System.out.println(bookFieldTitle.getText());
        }
}
