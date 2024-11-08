package model;

import java.util.Date;

public class Appointment {
    private Patient patient;
    private String doctor;
    private Date date;

    public Appointment(Patient patient, String doctor, Date date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public Date getDate() {
        return date;
    }
}