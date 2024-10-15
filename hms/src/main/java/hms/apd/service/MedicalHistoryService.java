package hms.apd.service;

import hms.apd.models.MedicalHistory;
import hms.apd.repo.MedicalHistoryRepo; // Assuming you have a repository for data access
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class MedicalHistoryService {

    @Inject
    private MedicalHistoryRepo medicalHistoryRepo; // Inject the repository to access database

    // This method retrieves medical history data for a user by their email
    public List<MedicalHistory> getMedicalHistoryForUser(String email) {
        // Retrieve the medical history data from the repository
        return medicalHistoryRepo.findByUserEmail(email); // Fetch data from the database
    }
}
