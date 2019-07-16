package Library;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User{
    DatabaseConnection databaseConnection;
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet resultSet;
    Scanner scan = new Scanner(System.in);
    Admin() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }

    public boolean checkEmail(String email) {
        String query = "select email from librarian;";
        resultSet = databaseConnection.getData(query);
        try {
            while (resultSet.next()) {
                if(resultSet.getString("email").equals(email)) {
                    return false;
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public void saveToDB(Librarian librarian, ArrayList<String> args) {
        String query = "insert into librarian values(?,?,?,?,?,?,?)";
        databaseConnection.saveToDB(query,args);
    }

    public boolean checkIDExists(int id) {
        String query = "select * from librarian where userid = ?";//
        resultSet = databaseConnection.getData(query,id);
        try {
            if(resultSet.next()) {
                return true;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public void addLibrarian() {
        Librarian librarian = new Librarian();
        ArrayList<String> args = new ArrayList<String>();
        System.out.print("First Name: ");
        String fname = scan.next();
        System.out.print("Last Name: ");
        String lname = scan.next();
        System.out.print("Password: ");
        String password = scan.next();
        System.out.print("Email: ");
        String email = scan.next();
        System.out.print("Ph_Number: ");
        String ph_num = scan.next();
        System.out.print("Address: ");
        String address =  scan.next();
        args.add(fname); args.add(lname); args.add(null);
        args.add(password);args.add(email); args.add(ph_num);
        args.add(address);
        if(checkEmail(email)) {
            librarian.setFirstname(fname);
            librarian.setLastname(lname);
            librarian.setEmail(email);
            librarian.setPassword(password);
            librarian.setAddress(address);
            librarian.setContact(ph_num);
            saveToDB(librarian,args);
        }
        else {
            System.out.println("Email already taken");
        }
    }

    public void removeLibrarian() {
        System.out.print("Enter ID: ");
        int id = scan.nextInt();
        if(checkIDExists(id)) {
            String query = "delete from librarian where userid=?";
            if(databaseConnection.remove(query,id)) {
                System.out.println("Successfully removed !");
            }
            else {
                System.out.print("Couldn't remove please try again !");
            }
        }
        else {
            System.out.println("User ID doesn't exist !!");
        }
    }
}