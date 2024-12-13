package org.example.controle2java.DaoImpl;


import org.example.controle2java.DAO.DatabaseConnexion;
import org.example.controle2java.DAO.MembreDao;
import org.example.controle2java.Models.Membre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MembreDaoImpl implements MembreDao {
    DatabaseConnexion db;
    List<Membre> membres;
    public MembreDaoImpl() {
        db = new DatabaseConnexion();
        membres = new ArrayList<Membre>();
    }
    @Override
    public void inserer(Membre m) {
        String requete = "INSERT INTO membre(id,nom,prenom,email,phone) Values (?,?,?,?,?)";
        try(PreparedStatement statement= db.getCon().prepareStatement(requete)){
            statement.setInt(1,m.getId());
            statement.setString(2,m.getNom() );
            statement.setString(3, m.getPrenom());
            statement.setString(4,m.getEmail());
            statement.setString(5,m.getPhone());
            int result =statement.executeUpdate();
            if(result >0){
                System.out.println("Insertion has been successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void chargerListIncidents() {
        String query = "SELECT * FROM membre";
        ResultSet resultSet = null;
        try {
            resultSet = db.getCon().createStatement().executeQuery(query);
            while (resultSet.next()) {
                Membre m = new Membre();
                m.setId(resultSet.getInt("id"));
                m.setNom(resultSet.getString("nom"));
                m.setPrenom(resultSet.getString("prenom"));
                m.setEmail(resultSet.getString("email"));
                m.setPhone(resultSet.getString("phone"));
                membres.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
