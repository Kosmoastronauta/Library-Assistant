package controllers;

import menu.library.assistant.Book;
import menu.library.assistant.Member;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
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

        public static final String TABLE_RESERVATION = "reservation";
        public static final String RESERVATION_COLUMN_BOOK = "IDbook";
        public static final String RESERVATION_COLUMN_MEMBER = "IDmember";
        public static final String RESERVATION_COLUMN_TIME = "time";



        private Connection conn;


        public boolean add(Member member)
        {
            try {

                conn = DriverManager.getConnection(CONNECTION_STRING + DB_NAME);

                Statement statement = conn.createStatement();
                statement.execute("CREATE TABLE IF NOT EXISTS member " +
                        " (ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, lastname TEXT, email TEXT, phone TEXT)");

                System.out.println("Im saving member to database");

                PreparedStatement ps = conn.prepareStatement("insert INTO " + TABLE_MEMBER + "(" +
                        MEMBER_COLUMN_NAME + ", " +
                        MEMBER_COLUMN_LASTNAME + ", " +
                        MEMBER_COLUMN_EMAIL + ", " +
                        MEMBER_COLUMN_PHONE + ") " +
                        "VALUES(?,?,?,?)");

                ps.setString(1, member.getName());
                ps.setString(2, member.getLastName());
                ps.setString(3, member.getEmail());
                ps.setString(4, member.getPhone());

                int resultRows = ps.executeUpdate();


                /*

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


                 */
                 conn.close();

                System.out.println("Member has been added");
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
                        " (ID INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, author TEXT, edition TEXT, year INTEGER )");

                PreparedStatement ps = conn.prepareStatement("INSERT INTO " + TABLE_BOOK + "(" +
                        BOOK_COLUMN_TITLE + ", " +
                        BOOK_COLUMN_AUTHOR + ", " +
                        BOOK_COLUMN_EDITION + ", " +
                        BOOK_COLUMN_YEAR + ")" +
                        "VALUES(?,?,?,?)");

                ps.setString(1, book.getTitle());
                ps.setString(2, book.getAuthor());
                ps.setString(3, book.getEdition());
                ps.setInt(4, book.getYear());

                int resultRows = ps.executeUpdate();
                System.out.println("Book has been added");
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

                    members.add(new Member(result.getInt(MEMBER_COLUMN_ID),
                            result.getString(MEMBER_COLUMN_NAME),
                            result.getString(MEMBER_COLUMN_LASTNAME),
                            result.getString(MEMBER_COLUMN_EMAIL),
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


    public List<Member> queryMemberSpecify(Member member)
    {
        System.out.println(member.getLastName());
        try
        {
            conn = DriverManager.getConnection(CONNECTION_STRING + DB_NAME);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM " + TABLE_MEMBER + " WHERE " +
                    TABLE_MEMBER + "." + MEMBER_COLUMN_LASTNAME + " = '" + member.getLastName() + "'");

            List<Member> members = new ArrayList<>();

            while (result.next())
            {

                members.add(new Member(result.getInt(MEMBER_COLUMN_ID),
                        result.getString(MEMBER_COLUMN_NAME),
                        result.getString(MEMBER_COLUMN_LASTNAME),
                        result.getString(MEMBER_COLUMN_EMAIL),
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

    public List<Book> queryBookSpecify()
    {
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING + DB_NAME);
            Statement statement = conn.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS reservation" +
                    " (IDbook INTEGER , IDmember INTEGER, Time INTEGER )");

            ResultSet result = statement.executeQuery("SELECT * FROM " +
                    TABLE_BOOK + " WHERE NOT EXISTS (SELECT * FROM " +
                    TABLE_RESERVATION + " WHERE " + TABLE_BOOK +
                    "." + BOOK_COLUMN_ID + "=" +
                    TABLE_RESERVATION + "." + RESERVATION_COLUMN_BOOK + ")");

            List<Book> books = new ArrayList<>();

            while(result.next())
            {
                books.add(new Book(result.getInt(BOOK_COLUMN_ID),
                                        result.getString(BOOK_COLUMN_TITLE),
                                        result.getString(BOOK_COLUMN_AUTHOR),
                                        result.getString(BOOK_COLUMN_EDITION),
                                        result.getInt(BOOK_COLUMN_YEAR)));
            }

            return  books;

        }catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }


    public boolean makeReservation(MemberListController.Person person, BookListController.ViewBook viewBook,  LocalDate date )
    {
        long end = date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING + DB_NAME);
            Statement statement = conn.createStatement();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + TABLE_RESERVATION +
                    " ( " + RESERVATION_COLUMN_BOOK +
                    ", " + RESERVATION_COLUMN_MEMBER +
                    ", " + RESERVATION_COLUMN_TIME + " )" +
                    " VALUES(?,?,?)");
            ps.setInt(1, Integer.valueOf(viewBook.getId()));
            ps.setInt(2, Integer.valueOf(person.getId()));
            ps.setLong(3, end);
            int affectedRows = ps.executeUpdate();

            if(affectedRows != 1)
            {
                throw new SQLException("Couldn't insert reservation: " + affectedRows);
            }
            System.out.println("Reservation made");

            return true;
        }catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }





}


