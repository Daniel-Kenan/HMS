package hms.apd.servlets;

import hms.apd.models.Appointment;
import hms.apd.models.MedicalHistory; // Import the new MedicalHistory model
import hms.apd.service.AppointmentService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import hms.apd.models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/medical-history")
public class MedicalHistoryServlet extends HttpServlet {

    @Inject
    private AppointmentService appointmentService;

    // Static list to hold medical history for demonstration
    private static final List<MedicalHistory> medicalHistories = new ArrayList<>();

    static {
        // Sample data for demonstration
        medicalHistories.add(new MedicalHistory(LocalDateTime.now().minusDays(1).toLocalDate(), "Flu", "Antiviral Medication", "Dr. Smith"));
        medicalHistories.add(new MedicalHistory(LocalDateTime.now().minusDays(30).toLocalDate(), "Back Pain", "Physical Therapy", "Dr. Adams"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("  <meta charset=\"UTF-8\">");
        out.println("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("  <title>Medical History & Appointment Booking</title>");
        out.println("  <script src=\"https://cdn.tailwindcss.com\"></script>");
        out.println("  <link href=\"https://cdn.jsdelivr.net/npm/daisyui@3.0.1/dist/full.css\" rel=\"stylesheet\" type=\"text/css\" />");
        out.println("</head>");
        out.println("<body class=\"bg-gradient-to-b from-blue-50 to-blue-100 min-h-screen\">");

        out.println("<div class=\"flex flex-col items-center justify-center space-y-10 py-12\">");
        out.println("  <div class=\"card w-full max-w-3xl shadow-xl bg-white p-10 rounded-lg\">");
        out.println("    <h2 class=\"text-3xl font-bold text-center mb-6 text-blue-600\">Your Medical History</h2>");
        out.println("    <div class=\"overflow-x-auto\">");
        out.println("      <table class=\"table w-full\">");
        out.println("        <thead>");
        out.println("          <tr class=\"bg-blue-100 text-blue-900\">");
        out.println("            <th>Date</th>");
        out.println("            <th>Condition</th>");
        out.println("            <th>Treatment</th>");
        out.println("            <th>Doctor</th>");
        out.println("          </tr>");
        out.println("        </thead>");
        out.println("        <tbody>");

        // Populate medical history dynamically from the static list
        for (MedicalHistory history : medicalHistories) {
            out.println("          <tr>");
            out.println("            <td>" + history.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "</td>");
            out.println("            <td>" + history.getCondition() + "</td>");
            out.println("            <td>" + history.getTreatment() + "</td>");
            out.println("            <td>" + history.getDoctor() + "</td>");
            out.println("          </tr>");
        }

        out.println("        </tbody>");
        out.println("      </table>");
        out.println("    </div>");
        out.println("  </div>");

        // Button to Trigger Appointment Booking Modal
        out.println("  <button class=\"btn btn-primary\" id=\"bookAppointmentBtn\">Book an Appointment</button>");

        // Appointment Booking Modal
        out.println("  <dialog id=\"appointmentModal\" class=\"modal\">");
        out.println("    <form method=\"dialog\" class=\"modal-box max-w-lg p-10 rounded-lg bg-white shadow-xl\">");
        out.println("      <h2 class=\"text-3xl font-bold text-center text-blue-600 mb-6\">Book an Appointment</h2>");
        out.println("      <div class=\"form-control mb-4\">");
        out.println("        <label class=\"label\" for=\"name\">");
        out.println("          <span class=\"label-text font-semibold\">Patient Name</span>");
        out.println("        </label>");
        out.println("        <input type=\"text\" id=\"name\" name=\"name\" placeholder=\"Enter your name\" class=\"input input-bordered w-full\" required>");
        out.println("      </div>");
        out.println("      <div class=\"form-control mb-4\">");
        out.println("        <label class=\"label\" for=\"email\">");
        out.println("          <span class=\"label-text font-semibold\">Email Address</span>");
        out.println("        </label>");
        out.println("        <input type=\"email\" id=\"email\" name=\"email\" placeholder=\"Enter your email\" class=\"input input-bordered w-full\" required>");
        out.println("      </div>");
        out.println("      <div class=\"form-control mb-4\">");
        out.println("        <label class=\"label\" for=\"date\">");
        out.println("          <span class=\"label-text font-semibold\">Appointment Date</span>");
        out.println("        </label>");
        out.println("        <input type=\"date\" id=\"date\" name=\"date\" class=\"input input-bordered w-full\" required>");
        out.println("      </div>");
        out.println("      <div class=\"form-control mb-4\">");
        out.println("        <label class=\"label\" for=\"time\">");
        out.println("          <span class=\"label-text font-semibold\">Appointment Time</span>");
        out.println("        </label>");
        out.println("        <input type=\"time\" id=\"time\" name=\"time\" class=\"input input-bordered w-full\" required>");
        out.println("      </div>");
        out.println("      <div class=\"form-control mt-6\">");
        out.println("        <button type=\"submit\" class=\"btn btn-success w-full\">Confirm Appointment</button>");
        out.println("      </div>");
        out.println("      <div class=\"modal-action mt-4\">");
        out.println("        <button class=\"btn btn-error\" onclick=\"document.getElementById('appointmentModal').close()\">Close</button>");
        out.println("      </div>");
        out.println("    </form>");
        out.println("  </dialog>");
        out.println("</div>");

        out.println("<script>");
        out.println("  document.getElementById('bookAppointmentBtn').addEventListener('click', function() {");
        out.println("    document.getElementById('appointmentModal').showModal();");
        out.println("  });");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    }
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Handle the appointment booking logic here

    // Extract form data
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String date = request.getParameter("date");
    String time = request.getParameter("time");

    // Convert date and time to LocalDateTime
    LocalDateTime appointmentDate = LocalDateTime.parse(date + "T" + time);

    // Create and save the appointment
    Appointment appointment = new Appointment(); // Create a new appointment object
    appointment.setAppointmentDate(appointmentDate); // Set the appointment date
    appointment.setStatus("pending"); // Set initial status
    appointment.setPatientName(name); // Set patient's name
    appointment.setEmail(email); // Set patient's email

    // Retrieve the User object from the session (or however your app manages user sessions)
    User user = (User) request.getSession().getAttribute("loggedInUser"); // Adjust this as necessary
    if (user != null) {
        appointment.setUser(user); // Set user if available
    } else {
        // Handle the case where the user is not logged in, maybe redirect to login
        response.sendRedirect(request.getContextPath() + "/login"); // Example redirect
        return;
    }

    // Save the appointment
    appointmentService.saveAppointment(appointment); // Save the appointment

    // Redirect or show success message
    response.sendRedirect(request.getContextPath() + "/medical-history"); // Redirect back to the medical history page
}


    
}