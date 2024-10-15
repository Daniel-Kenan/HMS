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

        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<title>Doctor Appointments</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/daisyui@2.45.0/dist/full.css' rel='stylesheet' />"); // Link to Daisy UI
        out.println("</head>");
        out.println("<body class='bg-base-200 p-6'>");
        out.println("<div class='container mx-auto'>");
        out.println("<h1 class='text-2xl font-bold'>All Appointments</h1>");
        out.println("<table class='table w-full bg-white shadow-md rounded-lg mt-4'>");
        out.println("<thead>");
        out.println("<tr class='bg-base-300 text-base-content'>");
        out.println("<th>ID</th><th>User</th><th>Date</th><th>Status</th><th>Actions</th>");
        out.println("</tr></thead>");
        out.println("<tbody>");

        for (Appointment appointment : appointments) {
            out.println("<tr class='hover:bg-base-100'>");
            out.println("<td>" + appointment.getId() + "</td>");
            out.println("<td>" + appointment.getUser().getFirstName() + " " + appointment.getUser().getLastName() + "</td>");
            out.println("<td>" + appointment.getAppointmentDate() + "</td>");
            out.println("<td>" + appointment.getStatus() + "</td>");
            out.println("<td>");
            out.println("<a href='accept?id=" + appointment.getId() + "' class='btn btn-success'>Accept</a> ");
            out.println("<a href='decline?id=" + appointment.getId() + "' class='btn btn-error'>Decline</a>");
            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</tbody></table>");

        out.println("<h1 class='text-2xl font-bold mt-8'>Your Medical History</h1>");
        out.println("<table class='table w-full bg-white shadow-md rounded-lg mt-4'>");
        out.println("<thead>");
        out.println("<tr class='bg-base-300 text-base-content'>");
        out.println("<th>Date</th><th>Condition</th><th>Treatment</th><th>Doctor</th>");
        out.println("</tr></thead>");
        out.println("<tbody>");

        for (MedicalHistory history : medicalHistories) {
            out.println("<tr class='hover:bg-base-100'>");
            out.println("<td>" + history.getDate() + "</td>");
            out.println("<td>" + history.getCondition() + "</td>");
            out.println("<td>" + history.getTreatment() + "</td>");
            out.println("<td>" + history.getDoctor() + "</td>");
            out.println("</tr>");
        }

        out.println("</tbody></table>");
        out.println("</div></body></html>");
    }
}
