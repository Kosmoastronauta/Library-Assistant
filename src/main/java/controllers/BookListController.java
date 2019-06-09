package controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import menu.library.assistant.Book;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BookListController implements Initializable {

    ObservableList<ViewBook> list = FXCollections.observableArrayList();
    List<Book> dataList = new ArrayList<>();


    @FXML
    private TableView<ViewBook> tableView;
    @FXML
    private TableColumn<ViewBook, String> colTitle;
    @FXML
    private TableColumn<ViewBook, String> colAuthor;
    @FXML
    private TableColumn<ViewBook, Integer> colID;
    @FXML
    private TableColumn<ViewBook, String> colEdition;
    @FXML
    private TableColumn<ViewBook, Integer> colYear;




    public void initialize(URL location, ResourceBundle resources)
    {
        initiateCols();
        loadData();
    }

    private void initiateCols()
    {

        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEdition.setCellValueFactory(new PropertyValueFactory<>("edition"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));

    }

    private void loadData ()
    {
        list.removeAll(list);

        DataSource data = new DataSource();
        dataList = data.queryBook();

        for(Book book : dataList)
        {
            list.addAll(new ViewBook(Integer.toString(book.getID()), book.getTitle(), book.getAuthor(), book.getEdition(), Integer.toString(book.getYear())));
        }

        tableView.getItems().addAll(list);
    }


    public static class ViewBook
    {
         private SimpleStringProperty id;
         private SimpleStringProperty title;
         private SimpleStringProperty author;
         private SimpleStringProperty edition;
         private SimpleStringProperty year;

        public ViewBook()
        {
        }

        public ViewBook(String id, String title, String author, String edition, String year)
        {
            this.id = new SimpleStringProperty(id);
            this.title = new SimpleStringProperty(title);
            this.author = new SimpleStringProperty(author);
            this.edition = new SimpleStringProperty(edition);
            this.year = new SimpleStringProperty(year);
        }

        public String getId() {
            return id.get();
        }

        public  void setId(String id){
            this.id.set(id);
        }

        public String getTitle(){
            return title.get();
        }

        public void setTitle(String title){
            this.title.set(title);
        }


        public String getAuthor(){
            return author.get();
        }

        public void setAuthor(String author)
        {
            this.author.set(author);
        }

        public void setEdition(String edition)
        {
            this.edition.set(edition);
        }

        public String getEdition()
        {
            return edition.get();
        }

        public void setYear(String year)
        {
            this.year.set(year);
        }

        public String getYear()
        {
            return this.year.get();
        }
    }






}
