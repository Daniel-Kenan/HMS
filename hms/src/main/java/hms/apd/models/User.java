package hms.apd.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // Name of the table in the database
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    @Column(nullable = false) // Not null constraint
    private String firstName;

    @Column(nullable = false) // Not null constraint
    private String lastName;

    @Column(nullable = false, unique = true) // Not null and unique constraint
    private String email;

    @Column(nullable = false) // Not null constraint
    private String password;

    @Column(nullable = false, unique = true) // Not null and unique constraint
    private String cellphoneNumber;

    @Column(nullable = false) // Not null constraint
    private boolean isAdmin; // 'true' for admin, 'false' for regular user

    // Constructors
    public User() {}

    public User(String firstName, String lastName, String email, String password, String cellphoneNumber, boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cellphoneNumber = cellphoneNumber;
        this.isAdmin = isAdmin;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
