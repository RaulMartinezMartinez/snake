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
public class PruebaContagioDAO {
    
   
    private Connection conn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet result;
    private ArrayList listaE = new ArrayList();

    public PruebaContagioDAO() {
    }
    
    public void insertarEvento (PruebaContagio pc) throws SQLException{
    
    Conexion con = new Conexion();
    
    int numero;
    
    conn = con.Conexionbd();
    
    ps = conn.prepareStatement("Insert into eventos (Dni,Tipo_evento,Resultado,Tipo,Fecha) values(?,?,?,?,?);");
    
    ps.setString(1, pc.getDni());
    ps.setString(2, pc.getPrueba());
    ps.setString(3, pc.getResultado());
    ps.setString(4, pc.getTipoPrueba());
    ps.setString(5, pc.getFecha());
    
    ps.executeUpdate();
        System.out.println("Fila insertada");
    ps.close();
    con.desconectar(conn);
    }
    
    public void borrarEvento (EventoDAO ed) throws SQLException{
    
        Conexion con = new Conexion();
        
        conn = con.Conexionbd();
        
        ps = conn.prepareStatement("Delete from eventos where Dni = ?;");
        ps.setString(1, ed.getDni());
        
        ps.executeUpdate();
        System.out.println("Fila borrada");
        
        ps.close();
        con.desconectar(conn);
        
        
    }
    
    public ArrayList<EventoDAO> listaE (Usuario u) throws SQLException{
        
        Conexion con = new Conexion();
        
        conn = con.Conexionbd();
        
        st = conn.createStatement();
        
        result = st.executeQuery("Select * from eventos where Dni ='"+u.getDni()+"';");
        
        while (result.next()){
        
            listaE.add(new EventoDAO(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5)));
        }
        result.close();
            st.close();
            con.desconectar(conn);
        return listaE;
        }
    
    


}
