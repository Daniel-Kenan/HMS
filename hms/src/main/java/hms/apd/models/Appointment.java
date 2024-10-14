package hms.apd.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentDate;

    @Column(nullable = false)
    private String status; // "pending", "accepted", "declined"

    @Column(nullable = false) // Add this for patient name
    private String patientName;

    @Column(nullable = false) // Add this for email
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // The patient who booked the appointment
    private User user;

    // Constructors
    public Appointment() {}

    public Appointment(LocalDateTime appointmentDate, String status, String patientName, String email, User user) {
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.patientName = patientName;
        this.email = email;
        this.user = user;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
