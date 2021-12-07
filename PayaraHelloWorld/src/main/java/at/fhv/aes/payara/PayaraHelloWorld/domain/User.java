package at.fhv.aes.payara.PayaraHelloWorld.domain;

public class User {

    private String firstName;
    private String lastName;
    private String userID;
    private String password;

    public User(String firstName, String lastName, String userID, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }
}
