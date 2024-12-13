package org.example.controle2java.Controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.controle2java.DaoImpl.MembreDaoImpl;
import org.example.controle2java.Models.Membre;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Math.random;

public class AddMembreController implements Initializable {
    public TextField nom_fld;
    public TextField prenom_fld;
    public TextField email_fld;
    public TextField phone_fld;
    public Button inserer_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inserer_btn.setOnAction(e -> InsertIntoMembre());
    }

    private void InsertIntoMembre() {
        int ref= (int) random();
        MembreDaoImpl impl= new MembreDaoImpl();
        String nom= nom_fld.getText();
        String prenom= prenom_fld.getText();
        String email= email_fld.getText();
        String phone= phone_fld.getText();
        Membre m = new Membre(ref,nom,prenom,email,phone);
        impl.inserer(m);
    }
}