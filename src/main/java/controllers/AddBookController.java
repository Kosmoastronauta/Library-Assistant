package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import menu.library.assistant.Book;
import menu.library.assistant.Member;

public class AddBookController {



    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField editionField;

    @FXML
    private TextField yearField;

    @FXML
    public void onButtonAddClicked(ActionEvent e)
    {
        String title = titleField.getText();
        String author = authorField.getText();
        String edition = editionField.getText();

        int year = Integer.valueOf(yearField.getText());

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



        else
        {
            DataSource data = new DataSource();
            Book book = new Book(1, title, author, edition, year);
            data.add(book);
            System.out.println("Ok book added");

            Popup p = new Popup("Confirmation", "Adding New Member", "Data: " +
                    book.getTitle() + ", " +
                    book.getAuthor() + ", " +
                    book.getEdition() + ", " +
                    book.getYear());

            p.confirmation();
        }

    }



}
