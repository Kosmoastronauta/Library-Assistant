package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import menu.library.assistant.Book;
import menu.library.assistant.Member;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationController
{
    ObservableList<MemberListController.Person> listMember = FXCollections.observableArrayList();
    List<Member> dataListMember = new ArrayList<>();
    ObservableList<BookListController.ViewBook> listBook = FXCollections.observableArrayList();
    List<Book> dataListBook = new ArrayList<>();

    static MemberListController.Person person;
    static BookListController.ViewBook viewBook;

    @FXML
    private TextField memberName;

    @FXML
    private TextField memberLastName;

    @FXML
    private TextField memberID;

    @FXML
    private TextField bookTitle;

    @FXML
    private TextField bookAuthor;

    @FXML
    private TextField bookID;



    @FXML
    private TableView<MemberListController.Person> tableViewMember;
    @FXML
    private TableColumn<MemberListController.Person, String> colNameMember;
    @FXML
    private TableColumn<MemberListController.Person, String> colLastNameMember;
    @FXML
    private TableColumn<MemberListController.Person, Integer> colIDMember;
    @FXML
    private TableColumn<MemberListController.Person, Integer> colEmailMember;

    @FXML
    private TableView<BookListController.ViewBook> tableViewBook;
    @FXML
    private TableColumn<BookListController.ViewBook, String> colTitleBook;
    @FXML
    private TableColumn<BookListController.ViewBook, String> colAuthorBook;
    @FXML
    private TableColumn<BookListController.ViewBook, Integer> colIDBook;
    @FXML
    private TableColumn<BookListController.ViewBook, String> colEditionBook;



    @FXML
    public void onButtonSearchMemberClicked(ActionEvent e)
    {

        initiateColsMember();
        loadDataMember();


    }

    @FXML
    public void onButtonSearchBookClicked(ActionEvent e)
    {
        DataSource data = new DataSource();
        initiateColsBook();
        loadDataBook();

    }


    private void initiateColsMember()
    {

        colNameMember.setCellValueFactory(new PropertyValueFactory<>("name"));
        colLastNameMember.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colIDMember.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEmailMember.setCellValueFactory(new PropertyValueFactory<>("email"));

    }

    private void loadDataMember ()
    {
        tableViewMember.getItems().clear();
        listMember.removeAll(listMember);

        String lastName = memberLastName.getText();
        DataSource data = new DataSource();

        dataListMember = data.queryMemberSpecify( new Member(1,
                "Mateusz",
                lastName,
                "email",
                "1"));




       // dataListMember = data.queryMember();
        for(Member member : dataListMember)
        {
            listMember.addAll(new MemberListController.Person(Integer.toString(member.getID()), member.getName(), member.getLastName(), member.getEmail(), member.getPhone()));
        }

        tableViewMember.getItems().addAll(listMember);
    }

    private void initiateColsBook()
    {

        colTitleBook.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthorBook.setCellValueFactory(new PropertyValueFactory<>("author"));
        colIDBook.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEditionBook.setCellValueFactory(new PropertyValueFactory<>("edition"));
    }

    private void loadDataBook ()
    {
        tableViewBook.getItems().clear();
        listBook.removeAll(listBook);

        DataSource data = new DataSource();
        dataListBook = data.queryBookSpecify();

        for(Book book : dataListBook)
        {
            listBook.addAll(new BookListController.ViewBook(Integer.toString(book.getID()), book.getTitle(), book.getAuthor(), book.getEdition(), Integer.toString(book.getYear())));
        }

        tableViewBook.getItems().addAll(listBook);
    }

    @FXML
    public void onButtonReserveClicked(ActionEvent event)
    {
        System.out.println("Reserve clicked");

        BookListController.ViewBook viewBook = new BookListController.ViewBook();
        MemberListController.Person person = new MemberListController.Person();

        person = tableViewMember.getSelectionModel().getSelectedItem();
        viewBook = tableViewBook.getSelectionModel().getSelectedItem();

        System.out.println(person.getId());
        System.out.println(person.getName());
        System.out.println(person.getLastName());

        System.out.println(viewBook.getId());
        System.out.println(viewBook.getTitle());
        System.out.println(viewBook.getAuthor());

        DataSource data = new DataSource();

        LocalDate date = LocalDate.now();
        date = date.plusMonths(1);

        boolean reserv = data.makeReservation(person, viewBook, date);






    }






}
