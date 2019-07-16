package Library;

abstract public class User {
    private String firstname;
    private String lastname;
    private int userid;
    private String password;
    private String email;
    private String contact;
    private String address;
    public void setFirstname(String fname) {
        this.firstname = fname;
    }
    public void setLastname(String lname) {
        this.lastname = lname;
    }
    public void setUserid(int id) {
        this.userid = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return this.firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    public String getPassword() {
        return this.password;
    }
    public String getEmail() {
        return this.email;
    }
    public String getContact() {
        return this.contact;
    }
    public String getAddress() {
        return this.address;
    }
    public int getUserid() {
        return this.userid;
    }

   //abstract public void saveToDB(User user);  // Lets see, what arguments can be passed.
}
