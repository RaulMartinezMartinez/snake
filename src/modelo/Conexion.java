/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;


import java.io.IOException;

/**
 *
 * @author ulra7
 */
public class Conexion {

    public Conexion() {
    }
    
   

    public Connection Conexionbd() throws SQLException {
        
    String url = "jdbc:mysql://upjnbjqyv3obwrck:78Mq2lHo9maK3iPPLDbW@b9q3e7gvuymjegscjvuj-mysql.services.clever-cloud.com:3306/b9q3e7gvuymjegscjvuj";
    String user = "upjnbjqyv3obwrck";
    String password = "78Mq2lHo9maK3iPPLDbW";
    
    Connection con = DriverManager.getConnection(url,user,password);
    
    return con;
        
    }
    
    public void desconectar(Connection con) throws SQLException{
    con.close();
    }

    
    
}
