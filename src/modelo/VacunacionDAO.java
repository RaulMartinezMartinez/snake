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
public class VacunacionDAO {
    
    private Connection conn;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet result;
    private ArrayList listaV = new ArrayList();

    public VacunacionDAO() {
    }
    
    public void insertarVacuna(Vacunacion v) throws SQLException{
    
        
        Conexion con = new Conexion();
        conn = con.Conexionbd();
        
        ps = conn.prepareStatement("Insert into eventos (Dni,Tipo_evento,Resultado,Tipo,Fecha) values(?,?,?,?,?);");
        
        ps.setString(1, v.getDni());
        ps.setString(2, v.getPrueba());
        ps.setString(3, "Vacuna "+ v.getNumDosis() );
        ps.setString(4, v.getNombreVacuna());
        ps.setString(5, v.getFecha());
        
        ps.executeUpdate();
        System.out.println("Fila insertada");
        
        ps.close();
        con.desconectar(conn);
    }
    
    public void borrarVacuna (EventoDAO ed) throws SQLException{
    
        Conexion con = new Conexion();
        conn = con.Conexionbd();
        
        ps = conn.prepareStatement("delete from eventos where Dni = ?;");
        
        ps.setString(1, ed.getDni());
        
        ps.executeUpdate();
        System.out.println("Fila borrada");
        
        ps.close();
        con.desconectar(conn);
    }
    
    public ArrayList<EventoDAO> listaV (Usuario u) throws SQLException{
        
        Conexion con = new Conexion();
        
        conn = con.Conexionbd();
        
        st = conn.createStatement();
        
        result = st.executeQuery("select * from eventos where Dni ='"+u.getDni()+"';");
        
        while (result.next()){
        
            listaV.add(new EventoDAO(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5)));
        
        }
        result.close();
        st.close();
        con.desconectar(conn);
        return listaV;
    }
}
