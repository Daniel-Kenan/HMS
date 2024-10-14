package hms.apd.service;

import hms.apd.models.MedicalHistory;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MedicalHistoryService {

    // This method simulates retrieval of medical history data
    public List<MedicalHistory> getMedicalHistoryForUser(String email) {
        List<MedicalHistory> history = new ArrayList<>();
        // Simulate some data (replace with actual data retrieval logic)
        history.add(new MedicalHistory(LocalDate.of(2024, 10, 10), "Flu", "Antiviral Medication", "Dr. Smith"));
        history.add(new MedicalHistory(LocalDate.of(2024, 9, 20), "Back Pain", "Physical Therapy", "Dr. Adams"));
        return history;
    }
}
