package menu.library.assistant;

public class Book {

    private String title;
    private String author;
    private String edition;
    private int ID;
    private int year;

    public Book(int ID, String title, String author, String edition, int year)
    {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.ID = ID;
        this.year = year;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }







}
