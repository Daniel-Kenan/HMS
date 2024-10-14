package hms.apd.service;

import hms.apd.models.Appointment;
import hms.apd.repo.AppointmentRepo;
import jakarta.inject.Inject;
import jakarta.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class AppointmentService {

    @Inject
    private AppointmentRepo appointmentRepository;

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
    
     public void saveAppointment(Appointment appointment) {
        // Logic to save the appointment, e.g., to a database
        appointmentRepository.save(appointment); // Example call to save method in repository
    }
}
