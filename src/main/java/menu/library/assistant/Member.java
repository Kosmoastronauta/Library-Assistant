package menu.library.assistant;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Member {

    private String name;
    private String lastName;
    private String email;
    private int id;
    private String phone;

    public Member() {}

    public Member(int id, String name, String last_name, String email, String phone)
    {
       this.name=name;
       this.lastName=last_name;
       this.email=email;
       this.id=id;
       this.phone=phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getID() {
        return id;
    }

    public String getPhone() {
        return phone;
    }


    static boolean onlyletters(String s)
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

    static boolean emailValidation(String email)
    {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }



}

