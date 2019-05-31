package controllers;

import menu.library.assistant.Book;
import menu.library.assistant.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Add {

    private final String CONNECTION_STRING = "jdbc:sqlite:/home/mateusz/IdeaProjects/Library-Assistant/database/";
    private final String DB_MEMBER = "member.db";
    private final String DB_BOOK = "book.db";


    private final String MEMBER_COLUMN_NAME = "name";
    private final String MEMBER_COLUMN_LASTNAME = "lastname";
    private final String MEMBER_COLUMN_EMAIL = "email";
    private final String MEMBER_COLUMN_PHONE = "phone";
    private final String MEMBER_COLUMN_ID = "id";


    private final String BOOK_COLUMN_TITLE = "title";
    private final String BOOK_COLUMN_AUTHOR = "author";
    private final String BOOK_COLUMN_EDITION = "edition";
    private final String BOOK_COLUMN_YEAR = "year";
    private final String BOOK_COLUMN_ID = "id";




    public void member(Member member)
    {
        try {
            System.out.println("Im saving member to database");
            Connection conn = DriverManager.getConnection(CONNECTION_STRING + DB_MEMBER);

            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS member " +
                                    " (ID INTEGER, name TEXT, lastname TEXT, email TEXT, phone TEXT)");
            conn.close();

            System.out.println("Done");
        }
        catch (SQLException e) {
            System.out.println("Something wrong with database + " + e.getMessage());
        }

    }

    public void book(Book book)
    {

        try {

            Connection conn = DriverManager.getConnection(CONNECTION_STRING + DB_BOOK);

            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS book" +
                    " (ID INTEGER, title TEXT, author TEXT, edition TEXT, year INTEGER )");

            conn.close();
        }
        catch (SQLException e) {

        }

    }
}
