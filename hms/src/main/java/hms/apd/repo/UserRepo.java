package hms.apd.repo;

import hms.apd.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class UserRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    public User findByEmail(String email) {
        try {
            return entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // No user found with the specified email
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return null; // Handle other exceptions as needed
        }
    }

    public User findByCellphoneNumber(String cellphoneNumber) {
        try {
            return entityManager.createQuery("SELECT u FROM User u WHERE u.cellphoneNumber = :cellphoneNumber", User.class)
                    .setParameter("cellphoneNumber", cellphoneNumber)
                    .getSingleResult();
        } catch (Exception e) {
            return null; // No user found
        }
    }
}
