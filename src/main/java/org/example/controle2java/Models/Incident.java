package org.example.controle2java.Models;

import java.sql.Time;

public class Incident {
    private String reference;
    private Time time;
    private String status;
    private Membre membre;
    public Incident(String reference, Time time, String status, Membre membre) {
        this.reference = reference;
        this.time = time;
        this.status = status;
        this.membre = membre;
    }

    public String getReference() {
        return reference;
    }

    public Time getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public Membre getMembre() {
        return membre;
    }
}