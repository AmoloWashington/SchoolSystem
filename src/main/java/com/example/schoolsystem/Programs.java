package com.example.schoolsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Programs {

    @FXML
    private Button clearprogs;

    @FXML
    private TextField program;

    @FXML
    private TextField programid;

    @FXML
    private Button saveprogs;

    public void Saveprogs(ActionEvent e){


        DatabaseConnection connectNow = new DatabaseConnection();

        String user = "INSERT INTO programs values(?,?)";


        try {
            Connection con = connectNow.getConnection();
            PreparedStatement statement = con.prepareStatement(user);
            statement.setString(1, programid.getText().toString());
            statement.setString(2, program.getText().toString());

            int x = statement.executeUpdate();
            if (x == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText(" Program registered successfully...");
                alert.setHeaderText(null);
                alert.setHeight(30);
                alert.setWidth(50);
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogRegister.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
