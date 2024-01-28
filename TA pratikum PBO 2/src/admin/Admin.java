package admin;

// Kelas Admin sebagai representasi admin hotel
public class Admin {
    public String username;
    public String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter dan setter untuk setiap atribut
    // ...

    // Metode untuk login admin
    public boolean login(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }
}
