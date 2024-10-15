package hms.apd.repo;

import hms.apd.models.MedicalHistory;
import jakarta.enterprise.context.ApplicationScoped;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class MedicalHistoryRepo {

    @PersistenceContext
    private EntityManager entityManager;

    // Method to retrieve medical history by user email
    public List<MedicalHistory> findByUserEmail(String email) {
        String jpql = "SELECT mh FROM MedicalHistory mh WHERE mh.user.email = :email"; // Adjust the query based on your entity relationships
        TypedQuery<MedicalHistory> query = entityManager.createQuery(jpql, MedicalHistory.class);
        query.setParameter("email", email);
        return query.getResultList();
    }
}
