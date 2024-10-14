package hms.apd.servlets;

import hms.apd.service.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to the registration page for GET requests
        request.getRequestDispatcher("Pages/Register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cellphoneNumber = request.getParameter("cellphoneNumber");

        // Log the registration data
        System.out.println("Registering user:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password); // Be cautious about logging passwords!
        System.out.println("Cellphone Number: " + cellphoneNumber);

        String message = userService.registerUser(firstName, lastName, email, password, cellphoneNumber);

        if (message.contains("successfully")) {
            response.sendRedirect("Pages/Login.jsp");
        } else {
            request.setAttribute("errorMessage", message);
            request.getRequestDispatcher("Pages/Register.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
