package hms.apd.service;

import hms.apd.repo.UserRepo;
import hms.apd.models.User;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class UserService {

    @Inject
    private UserRepo userRepo;

    public String registerUser(String firstName, String lastName, String email, String password, String cellphoneNumber) {
        // Check if a user with the same email or cellphone number already exists
        if (userRepo.findByEmail(email) != null) {
            return "User with this email already exists.";
        }

        if (userRepo.findByCellphoneNumber(cellphoneNumber) != null) {
            return "User with this cellphone number already exists.";
        }

        // Create and save the new user
        User user = new User(firstName, lastName, email, password, cellphoneNumber, false);
        userRepo.save(user);
        
        return "User registered successfully.";
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    
    public boolean loginUser(String email, String password) {
     User user = userRepo.findByEmail(email);

        if (user == null) {
            return false; // User not found
        }

        if (!user.getPassword().equals(password)) {
            return false; // Invalid password
        }

        return true; // Login successful
    }
}
