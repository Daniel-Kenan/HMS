package hms.apd.servlets;

import hms.apd.service.UserService; // Ensure this service exists for user authentication
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Inject
    private UserService userService; // Assuming you have a UserService for user operations

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to the login page for GET requests
        request.getRequestDispatcher("Pages/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Log the login attempt
        System.out.println("Login attempt:");
        System.out.println("Email: " + email);
        // Be cautious about logging puy asswords!

        // Validate the user credentials
        boolean isValidUser = userService.loginUser(email, password);

        if (isValidUser) {
            // Create a session for the user
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", email); // Store user email or user object

            // Redirect to the user's dashboard or home page
            response.sendRedirect("Dashboard.jsp"); // Change to your actual dashboard page
        } else {
            // Set an error message and forward back to the login page
            request.setAttribute("errorMessage", "Invalid email or password.");
            request.getRequestDispatcher("Pages/Login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Login Servlet";
    }
}
