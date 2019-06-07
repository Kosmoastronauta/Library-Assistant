package controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import menu.library.assistant.Member;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MemberListController implements Initializable {

    ObservableList<Person> list = FXCollections.observableArrayList();
    List<Member> dataList = new ArrayList<>();


    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> colName;
    @FXML
    private TableColumn<Person, String> colLastName;
    @FXML
    private TableColumn<Person, Integer> colID;
    @FXML
    private TableColumn<Person, Integer> colEmail;
    @FXML
    private TableColumn<Person, Integer> colPhone;




    public void initialize(URL location, ResourceBundle resources)
    {
        initiateCols();
        loadData();
    }

    private void initiateCols()
    {

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

    }

    private void loadData ()
    {
        list.removeAll(list);

        DataSource data = new DataSource();
        dataList = data.queryMember();

        for(Member member : dataList)
        {
            list.addAll(new Person(Integer.toString(member.getID()), member.getName(), member.getLastName(), member.getEmail(), member.getPhone()));
        }

        tableView.getItems().addAll(list);
    }


    public static class Person
    {
        final private SimpleStringProperty id;
        final private SimpleStringProperty name;
        final private SimpleStringProperty lastName;
        final private SimpleStringProperty email;
        final private SimpleStringProperty phone;

        public Person(String id, String name, String lastName, String email, String phone)
        {
            this.id = new SimpleStringProperty(id);
            this.name = new SimpleStringProperty(name);
            this.lastName = new SimpleStringProperty(lastName);
            this.email = new SimpleStringProperty(email);
            this.phone = new SimpleStringProperty(phone);
        }

        public String getId() {
            return id.get();
        }

        public  void setId(String id){
            this.id.set(id);
        }

        public String getName(){
            return name.get();
        }

        public void setName(String name){
            this.name.set(name);
        }


        public String getLastName(){
            return lastName.get();
        }

        public void setLastName(String lastName)
        {
            this.lastName.set(lastName);
        }

        public void setEmail(String email)
        {
            this.email.set(email);
        }

        public String getEmail()
        {
            return email.get();
        }

        public void setPhone(String phone)
        {
            this.phone.set(phone);
        }

        public String getPhone()
        {
            return this.phone.get();
        }
    }






}


