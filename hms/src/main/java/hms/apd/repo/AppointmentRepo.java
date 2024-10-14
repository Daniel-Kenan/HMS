/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hms.apd.repo;
import hms.apd.models.Appointment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

public class AppointmentRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Appointment appointment) {
        entityManager.persist(appointment);
    }

    @Transactional
    public void update(Appointment appointment) {
        entityManager.merge(appointment);
    }

    public Appointment findById(Long id) {
        return entityManager.find(Appointment.class, id);
    }

    public List<Appointment> findAll() {
        return entityManager.createQuery("SELECT a FROM Appointment a", Appointment.class).getResultList();
    }

    public List<Appointment> findByStatus(String status) {
        return entityManager.createQuery("SELECT a FROM Appointment a WHERE a.status = :status", Appointment.class)
                .setParameter("status", status)
                .getResultList();
    }

    public List<Appointment> findByUserId(Long userId) {
        return entityManager.createQuery("SELECT a FROM Appointment a WHERE a.user.id = :userId", Appointment.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
