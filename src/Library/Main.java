package Library;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
    Admin admin;
    //Librarian librarian;
    DatabaseConnection databaseConnection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Scanner scan = new Scanner(System.in);

    public boolean validateUser(int userId,String password,String type) {
        String query;
        if(type.equals("admin"))
            query = "select * from admin where userid="+userId+";";
        else
            query = "select * from librarian where userid="+userId+";";
        resultSet = databaseConnection.getData(query);

        if(resultSet == null) {
            System.out.println("No such user exists");
        }
        else {
            System.out.println("checking details ... ");
            try {
                while(resultSet.next()) {
                    String Password = resultSet.getString("password");
                    if (Password.equals(password)) {
                        System.out.println("Login Successful");
                        return true;
                    }
                }
            }
            catch (Exception e) {
                System.out.println(e);
            }

        }
        return false;
    }

    public void login() {
        System.out.println("1: Admin Login, 2: Librarian Login");
        int type = scan.nextInt();
        System.out.print("UserID: ");
        int userid = Integer.parseInt(scan.next());
        System.out.print("Password: ");
        String password = scan.next();
        if(type == 1) {
            if(validateUser(userid, password, "admin")) {
                admin = new Admin();
                displayAdminOptions();
            }
            else {
                System.out.println("Invalid Credentials !!");
            }
        }
        else
            if(validateUser(userid,password,"librarian")) {

            }
    }


    public void viewLibrarian() {

    }

    public void logout() {

    }
    public void displayAdminOptions() {
        System.out.println("Admin Options:");
        System.out.println("1. ADD Librarian/n2. View Librarian/n3. Remove Librarian/n4. Logout");
        int opt = scan.nextInt();
        switch (opt) {
            case 1: {
                admin.addLibrarian();
                break;
            }
            case 2: {
                viewLibrarian();
                break;
            }
            case 3: {
                admin.removeLibrarian();
                break;
            }
            case 4: {
                logout();
                break;
            }
        }
    }
    Main() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
        System.out.println("Welcome to Library Management System");
        login();
    }
    public void displayUserRecords(ResultSet rs) {
        try {
            if(rs==null) {
                System.out.println("Empty Set");
            }
            else {
                while (rs.next()) {
                    System.out.print("Name: " + rs.getString(1));
                    System.out.print("UserID: " + rs.getString(2));
                    System.out.print("Contact: " + rs.getString(4));
                    System.out.print("Address: " + rs.getString(5));
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Main mainClass = new Main();
        /*
        String query = "select * from admin;";
        resultSet = databaseConnection.getData(query);
        mainClass.displayUserRecords(resultSet);
        */

    }
}
