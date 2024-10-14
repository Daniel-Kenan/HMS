package hms.apd.models;

import java.time.LocalDate;

public class MedicalHistory {
    private LocalDate date;
    private String condition;
    private String treatment;
    private String doctor;

    public MedicalHistory(LocalDate date, String condition, String treatment, String doctor) {
        this.date = date;
        this.condition = condition;
        this.treatment = treatment;
        this.doctor = doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCondition() {
        return condition;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getDoctor() {
        return doctor;
    }
}
