package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class AddBookController {



    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField editionField;

    @FXML
    private TextField IDField;

    @FXML
    public void onButtonAddClicked(ActionEvent e)
    {
        String title = titleField.getText();
        String author = authorField.getText();
        String edition = editionField.getText();
        String ID = IDField.getText();

        if(title.length()==0)
        {
            Popup p = new Popup("Error Dialog","Invalid Data", "Title field is empty!");
            p.warning();
        }

        else if(author.length()==0)
        {
            Popup p = new Popup("Error Dialog","Invalid Data", "Author field is empty!");
            p.warning();
        }

        else if(ID.length()==0)
        {
            Popup p = new Popup("Error Dialog","Invalid Data", "ID field is empty!");
            p.warning();
        }
    }



}
