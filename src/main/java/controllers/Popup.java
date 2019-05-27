package controllers;

import javafx.scene.control.Alert;

public class Popup {


    private String title;
    private String header;
    private String content;

    public Popup(String title, String header, String content)
    {
        this.title = title;
        this.header = header;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void warning()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(this.title);
        alert.setHeaderText(this.header);
        alert.setContentText(this.content);

        alert.showAndWait();
    }
}
