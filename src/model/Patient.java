package model;

public class Patient {
    private String name;
    private String id;
    private String symptoms;

    public Patient(String name, String id, String symptoms) {
        this.name = name;
        this.id = id;
        this.symptoms = symptoms;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getSymptoms() {
        return symptoms;
    }
}