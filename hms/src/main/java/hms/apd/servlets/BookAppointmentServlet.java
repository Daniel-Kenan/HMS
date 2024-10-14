package hms.apd.servlets;

import hms.apd.models.Appointment;
import hms.apd.service.AppointmentService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/doctor/book-appointment")
public class BookAppointmentServlet extends HttpServlet {

    @Inject
    private AppointmentService appointmentService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String date = request.getParameter("date");
        String time = request.getParameter("time");

        LocalDateTime appointmentDate = LocalDateTime.parse(date + "T" + time);

        Appointment appointment = new Appointment(appointmentDate, "pending", new User(name, email)); // Adjust user creation as per your User model
        appointmentService.createAppointment(appointment);

        response.sendRedirect("/doctor/appointments"); // Redirect back to the appointments page
    }
}
