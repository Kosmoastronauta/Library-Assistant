package controllers;

import menu.library.assistant.Book;
import menu.library.assistant.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import menu.library.assistant.Book;
import menu.library.assistant.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource
{


        private final String CONNECTION_STRING = "jdbc:sqlite:/home/mateusz/IdeaProjects/Library-Assistant/database/";
        private final static String DB_NAME = "reservation.db";



        private static final String TABLE_MEMBER = "member";
        private static final String MEMBER_COLUMN_NAME = "name";
        private static final String MEMBER_COLUMN_LASTNAME = "lastname";
        private static final String MEMBER_COLUMN_EMAIL = "email";
        private static final String MEMBER_COLUMN_PHONE = "phone";
        private static final String MEMBER_COLUMN_ID = "ID";


        private static final String TABLE_BOOK = "book";
        private static final String BOOK_COLUMN_TITLE = "title";
        private static final String BOOK_COLUMN_AUTHOR = "author";
        private static final String BOOK_COLUMN_EDITION = "edition";
        private static final String BOOK_COLUMN_YEAR = "year";
        private static final String BOOK_COLUMN_ID = "ID";

        private Connection conn;


        public boolean add(Member member)
        {
            try {

                conn = DriverManager.getConnection(CONNECTION_STRING + DB_NAME);

                Statement statement = conn.createStatement();
                statement.execute("CREATE TABLE IF NOT EXISTS member " +
                        " (ID INTEGER, name TEXT, lastname TEXT, email TEXT, phone TEXT)");

                System.out.println("Im saving member to database");

                statement.execute("INSERT INTO " + TABLE_MEMBER + " ( " +
                        MEMBER_COLUMN_ID + ", " +
                        MEMBER_COLUMN_NAME + ", " +
                        MEMBER_COLUMN_LASTNAME + ", " +
                        MEMBER_COLUMN_EMAIL + ", " +
                        MEMBER_COLUMN_PHONE + " )" +
                        " VALUES( " + member.getID() + ", '" +
                        member.getName() + "', '" +
                        member.getLastName() + "', '" +
                        member.getEmail() + "', '" +
                        member.getPhone() + "' )");

                 conn.close();

                System.out.println("Done");
                return true;
            }
            catch (SQLException e) {
                System.out.println("Something wrong with database during adding member " + e.getMessage());
                return false;
            }

        }

        public boolean add(Book book)
        {

            try {

                Connection conn = DriverManager.getConnection(CONNECTION_STRING + DB_NAME);

                Statement statement = conn.createStatement();
                statement.execute("CREATE TABLE IF NOT EXISTS book" +
                        " (ID INTEGER, title TEXT, author TEXT, edition TEXT, year INTEGER )");


                statement.execute("INSERT INTO " + TABLE_BOOK + "( " + BOOK_COLUMN_ID + ", " +
                        BOOK_COLUMN_TITLE + ", " +
                        BOOK_COLUMN_AUTHOR + ", " +
                        BOOK_COLUMN_EDITION + ", " +
                        BOOK_COLUMN_YEAR + ")" +
                        " VALUES( " + book.getID() + ", '" +
                        book.getTitle() + "', '" +
                        book.getAuthor() + "', '" +
                        book.getEdition() + "', " +
                        book.getYear() + ")");

                //  conn.close();
                return true;
            }
            catch (SQLException e) {
                System.out.println("Something wrong with database + " + e.getMessage());
                return false;
            }

        }

        public void close()
        {
            try
            {
                if(conn!=null)
                {
                    conn.close();
                }
            }catch (SQLException e) {
                System.out.println("Something wrong with database + " + e.getMessage());
            }
        }

        public List<Member> queryMember()
        {
            try
            {
                conn = DriverManager.getConnection(CONNECTION_STRING + DB_NAME);
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM " + TABLE_MEMBER);

                List<Member> members = new ArrayList<>();

                while (result.next())
                {

                    members.add(new Member(result.getString(MEMBER_COLUMN_NAME),
                            result.getString(MEMBER_COLUMN_LASTNAME),
                            result.getString(MEMBER_COLUMN_EMAIL),
                            result.getInt(MEMBER_COLUMN_ID),
                            result.getString(MEMBER_COLUMN_PHONE)));


                    System.out.println(result.getInt(MEMBER_COLUMN_ID));
                    System.out.println(result.getString(MEMBER_COLUMN_NAME));
                    System.out.println(result.getString(MEMBER_COLUMN_LASTNAME));
                    System.out.println(result.getString(MEMBER_COLUMN_EMAIL));
                    System.out.println(result.getString(MEMBER_COLUMN_PHONE));
                }

                result.close();
                conn.close();
                return members;

            }catch(SQLException e)
            {
                e.printStackTrace();
                System.out.println("Query Failed: " + e.getMessage());
                return null;
            }

        }

    public List<Book> queryBook()
    {
        try
        {
            conn = DriverManager.getConnection(CONNECTION_STRING + DB_NAME);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM " + TABLE_BOOK);

            List<Book> books = new ArrayList<>();

            while (result.next())
            {

                books.add(new Book( result.getInt(BOOK_COLUMN_ID),
                        result.getString(BOOK_COLUMN_TITLE),
                        result.getString(BOOK_COLUMN_AUTHOR),
                        result.getString(BOOK_COLUMN_EDITION),
                        result.getInt(BOOK_COLUMN_YEAR)));

                System.out.println(result.getInt(BOOK_COLUMN_ID));
                System.out.println(result.getString(BOOK_COLUMN_TITLE));
                System.out.println(result.getString(BOOK_COLUMN_AUTHOR));
                System.out.println(result.getString(BOOK_COLUMN_EDITION));
                System.out.println(result.getInt(BOOK_COLUMN_YEAR));
            }

            result.close();
            conn.close();
            return books;

        }catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Query Failed: " + e.getMessage());
            return null;
        }

    }

}


