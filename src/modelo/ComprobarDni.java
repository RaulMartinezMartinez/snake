/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ulra7
 */
public class ComprobarDni {
    
    private String dni;
    private boolean resultadoDni;
    private Connection conn;
    private Statement st;
    private ResultSet result;

    public ComprobarDni() {
    }

    public boolean isResultado() {
        return resultadoDni;
    }

    public void setResultado(boolean resultado) {
        this.resultadoDni = resultado;
    }
    
    
    public void validarDni(String dni) throws SQLException{
        boolean resultado;
        
        ArrayList<Usuario> lista = new ArrayList();
        
        Conexion con = new Conexion();
        
        conn = con.Conexionbd();
        
        st = conn.createStatement();
        
        result = st.executeQuery("select * from tarea9");
        
        resultado = true;
        
        while (result.next()){
        
        lista.add(new Usuario(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),(null)));
        }
        for(Usuario u: lista){
        
            if(u.getDni().equals(dni)){
            resultado = true;
            }else{
            resultado = false;
            }
            
            resultadoDni = resultado;
            
        }
        
    }
    
}
