package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import menu.library.assistant.Member;

import java.lang.String;
import java.net.IDN;


public class AddMemberController {


    @FXML
    private TextField addNameField;

    @FXML
    private TextField addLastNameField;

    @FXML
    private TextField addEmailField;

    @FXML
    private TextField addPhoneField;

    @FXML
    private TextField addIDField;

    @FXML
    private Button buttonAddSave;

    @FXML
    public void onButtonAddSaveClicked(ActionEvent event)
    {
        System.out.println("Add clicked");
        String name = addNameField.getText();
        String lastName = addLastNameField.getText();
        String email = addEmailField.getText();
        String phone = addPhoneField.getText();
        String id = addIDField.getText();

        if(!onlyletters(name) || name.length()==0)
        {
            Popup p = new Popup("Error Dialog", "Invalid Data", "Name field is empty or it contains not only letters");
            p.warning();
        }

        else if(!onlyletters(lastName) || lastName.length()==0)
        {
            Popup p = new Popup("Error Dialog", "Invalid Data", "Last Name field is empty or it contains not only letters");
            p.warning();
        }

        else if(!emailValidation(email))
        {
            Popup p = new Popup("Error Dialog", "Invalid Data", "Inproper E-mail address");
            p.warning();
        }

        else if(id.length()==0)
        {
            Popup p = new Popup("Error Dialog", "Invalid Data", "Inproper ID number");
            p.warning();
        }

        else if(phone.length()!=0 && !phoneValidation(phone))
        {
            Popup p = new Popup("Error Dialog", "Invalid Data", "Inproper phone number");
            p.warning();
        }

        else
        {
            System.out.println("Everything is OK");
            Add add = new Add();
            add.member(new Member(name, lastName, email, id, Integer.parseInt(phone)));
        }

    }

    private static boolean onlyletters(String s)
    {
        char character;

        for(int i=0; i<s.length(); i++)
        {
            character = s.charAt(i);
            if((character <'A' || character >'Z') && (character < 'a' || character > 'z'))
                return false;
        }

        return true;
    }

    private static boolean emailValidation(String email)
    {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private static boolean phoneValidation(String phone)
    {
       try{
           int temp;
           temp = Integer.parseInt(phone);
           return true;

       } catch (NumberFormatException e) {
            return false;
       }
    }



}
