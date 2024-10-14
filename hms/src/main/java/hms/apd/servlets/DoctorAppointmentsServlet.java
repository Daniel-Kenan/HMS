package hms.apd.servlets;

import hms.apd.models.Appointment;
import hms.apd.models.MedicalHistory;
import hms.apd.service.AppointmentService;
import hms.apd.service.MedicalHistoryService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/doctor/appointments")
public class DoctorAppointmentsServlet extends HttpServlet {

    @Inject
    private AppointmentService appointmentService;

    @Inject
    private MedicalHistoryService medicalHistoryService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Assuming you have the user's email from the session or request
        String userEmail = "patient@example.com"; // Replace with actual user email
        List<MedicalHistory> medicalHistories = medicalHistoryService.getMedicalHistoryForUser(userEmail);
        List<Appointment> appointments = appointmentService.getAllAppointments();

        out.println("<html>");
        out.println("<head><title>Doctor Appointments</title></head>");
        out.println("<body>");
        out.println("<h1>All Appointments</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>User</th><th>Date</th><th>Status</th><th>Actions</th></tr>");

        for (Appointment appointment : appointments) {
            out.println("<tr>");
            out.println("<td>" + appointment.getId() + "</td>");
            out.println("<td>" + appointment.getUser().getFirstName() + " " + appointment.getUser().getLastName() + "</td>");
            out.println("<td>" + appointment.getAppointmentDate() + "</td>");
            out.println("<td>" + appointment.getStatus() + "</td>");
            out.println("<td>");
            out.println("<a href='accept?id=" + appointment.getId() + "'>Accept</a> | ");
            out.println("<a href='decline?id=" + appointment.getId() + "'>Decline</a>");
            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("<h1>Your Medical History</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Date</th><th>Condition</th><th>Treatment</th><th>Doctor</th></tr>");

        for (MedicalHistory history : medicalHistories) {
            out.println("<tr>");
            out.println("<td>" + history.getDate() + "</td>");
            out.println("<td>" + history.getCondition() + "</td>");
            out.println("<td>" + history.getTreatment() + "</td>");
            out.println("<td>" + history.getDoctor() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
