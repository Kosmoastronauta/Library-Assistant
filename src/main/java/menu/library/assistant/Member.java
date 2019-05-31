package menu.library.assistant;

public class Member {

    private String name;
    private String last_name;
    private String email;
    private String id;
    private int Phone;

    public Member(String name, String last_name, String email, String id, int phone)
    {
        if(onlyletters(name))
        {
            this.name = name;
        }

        if(onlyletters(last_name))
        {
            this.last_name = last_name;
        }

        if(emailValidation(email))
        {
            this.email = email;
        }

        this.id=id;



    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public int getPhone() {
        return Phone;
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
