package hms.apd.service;

import hms.apd.models.Appointment;
import hms.apd.models.User;
import hms.apd.repo.AppointmentRepo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.util.List;

@RequestScoped
public class AppointmentService {

    @Inject
    private AppointmentRepo appointmentRepository;

    @Inject // Inject UserService here
    private UserService userService;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> getPendingAppointments() {
        return appointmentRepository.findByStatus("pending");
    }

    public void createAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public void acceptAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId);
        if (appointment != null) {
            appointment.setStatus("accepted");
            appointmentRepository.update(appointment);
        }
    }

    public void declineAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId);
        if (appointment != null) {
            appointment.setStatus("declined");
            appointmentRepository.update(appointment);
        }
    }

    public User findUserByEmail(String email) {
        return userService.findUserByEmail(email); // Delegate to UserService
    }
    
    public void saveAppointment(Appointment appointment) {
    appointmentRepository.save(appointment); // Save the appointment to the repository
}

}
