package com.example.schoolsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogRegister {



    @FXML
    private TextField userName;

    @FXML
    private PasswordField pass;

    @FXML
    private  PasswordField ConfirmPass;

    @FXML
    private Button regHere;

    @FXML
    private Button logdat;


    public void LogDatBtnAction(ActionEvent e) throws IOException {

        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("school-view.fxml"));
        Scene rootScene = new Scene(root);

        stage =(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(rootScene);
        stage.show();
    }




    public void regUser(ActionEvent e)throws IOException, SQLException {

        DatabaseConnection connectNow = new DatabaseConnection();

        String user = "INSERT INTO Users values(?,?,?)";


        try {
            Connection con = connectNow.getConnection();
            PreparedStatement statement = con.prepareStatement(user);
            statement.setString(1, userName.getText().toString());
            statement.setString(2, pass.getText().toString());
            statement.setString(3, ConfirmPass.getText().toString());
            int x = statement.executeUpdate();
            if (x == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText(" Registered successfully...");
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