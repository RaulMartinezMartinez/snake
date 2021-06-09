/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import com.sun.jdi.connect.spi.Connection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.sql.DriverManager;


/**
 *
 * @author ulra7
 */
public class Main_UT8 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLTarea_UT8.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
 String driver = "com.mysql.cj.jdbc.Driver"; 
 String url ="jdbc:mysql://upjnbjqyv3obwrck:78Mq2lHo9maK3iPPLDbW@b9q3e7gvuymjegscjvuj-mysql.services.clever-cloud.com:3306/b9q3e7gvuymjegscjvuj";
 String user = "upjnbjqyv3obwrck";
 String password = "78Mq2lHo9maK3iPPLDbW";
 
 

}