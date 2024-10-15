package hms.apd.servlets;

import hms.apd.models.Appointment;
import hms.apd.service.AppointmentService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import hms.apd.models.User;
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

    // Fetch the user from the database (assuming you have a method to do this)
    User user = appointmentService.findUserByEmail(email);  // Update this to match your service method for fetching users

    if (user == null) {
        // If the user doesn't exist, handle the error (redirect or send an error message)
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "User not found.");
        return;
    }

    // Create a new appointment with the existing user
    Appointment appointment = new Appointment(
        appointmentDate, 
        "pending",     // appointment status
        name,          // patient name
        email,         // email
        user           // the existing user
    );  

    // Call the service to create the appointment
    appointmentService.createAppointment(appointment);

    // Redirect back to the appointments page
    response.sendRedirect("/doctor/appointments");
}

    
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Forward the request to Patient.html (inside the JSP folder)
    request.getRequestDispatcher("/Pages/Patient.html").forward(request, response);
}
}
