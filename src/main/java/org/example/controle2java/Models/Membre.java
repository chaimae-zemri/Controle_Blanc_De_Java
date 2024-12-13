package org.example.controle2java.Models;

import java.util.List;
import java.util.Objects;

public class Membre {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    List<Incident> incidentList;
    public Membre() {}


    public int getId() {return id;}
    public String getNom() {return nom;}
    public String getPrenom() {return prenom;}
    public String getEmail() {return email;}
    public String getPhone() {return phone;}

    public Membre(int id, String nom, String prenom, String email, String phone, List<Incident> incidentList) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.incidentList = incidentList;
    }
    public Membre(int id, String nom, String prenom, String email, String phone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIncidentList(List<Incident> incidentList) {
        this.incidentList = incidentList;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if( obj == null || !(obj instanceof Membre)) return false;
        Membre membre = (Membre)obj;
        return this.id == membre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, email, phone);
    }
}