package org.example.controle2java.DaoImpl;

import org.example.controle2java.DAO.DatabaseConnexion;
import org.example.controle2java.DAO.IncidentDao;
import org.example.controle2java.Models.Incident;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class IncidentDaoImpl implements IncidentDao {
    private DatabaseConnexion db;
    public IncidentDaoImpl() {
        this.db = new DatabaseConnexion();
    }
    @Override
    public void inserer(Incident incident) {
        String requete = "INSERT INTO incident(reference,time,status,id_membre) Values (?,?,?,?)";
        try(PreparedStatement statement= db.getCon().prepareStatement(requete)){
            statement.setString(1,incident.getReference());
            statement.setTime(2,incident.getTime() );
            statement.setString(3, incident.getStatus());
            statement.setInt(4,incident.getMembre().getId());
            int result =statement.executeUpdate();
            if(result >0){
                System.out.println("Insertion has been successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inser(Set is) {
        is=new HashSet<Incident>();
        for(Object obj : is){
            Incident incident = (Incident) obj;
            this.inserer(incident);
        }

    }
}
