/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.*;
import java.util.LinkedHashMap;
import javafx.scene.control.Alert;

/**
 *
 * @author ulra7
 */
public class UsuarioDAO {
    
    private String nombre;
    private String apellidos;
    private String dni;
    private String fechaNac;
    private String grupo;
    private String sexo;
    private LocalDate fechaLocal;
    private Connection conn;
    private Statement sta;
    private ResultSet result;
    private PreparedStatement ps;
    private int suma = 0;
    
    
    public UsuarioDAO(){};

    public UsuarioDAO(String nombre, String apellidos, String dni, String fechaNac, String grupo, String sexo, LocalDate fechaLocal) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.grupo = grupo;
        this.sexo = sexo;
        this.fechaLocal = fechaLocal;
    }

    public UsuarioDAO(Usuario selectedItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList listaBD() throws SQLException, IOException {
        ArrayList<Usuario> lista1 = new ArrayList();
        
        Conexion con = new Conexion();
        
        conn = con.Conexionbd();
        
        sta = conn.createStatement();
        
        result = sta.executeQuery("Select * from tarea9");
        
        while(result.next()){
        lista1.add(new Usuario(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),(null)));
        }
        
        result.close();
        sta.close();
        conn.close();
        con.desconectar(conn);
        
        return lista1;
        }
    
    public void insertar (Usuario u)throws SQLException{
    
    Conexion con = new Conexion();
    
    conn = con.Conexionbd();
    
    ps = conn.prepareStatement("Insert into tarea9 (Nombre,Apellidos,Dni,Fecha_nacimiento,Grupo,Sexo) values (?,?,?,?,?,?);");
    ps.setString(1, u.getNombre());
    ps.setString(2, u.getApellidos());
    ps.setString(3, u.getDni());
    ps.setString(4, u.getFechaNac());
    ps.setString(5, u.getGrupo());
    ps.setString(6, u.getSexo());
    
    ps.executeUpdate();
    
    ps.close();
    con.desconectar(conn);
    
    
    }
    
public void borrar (Usuario u)throws SQLException {
    
   
    Conexion con = new Conexion();
    
    conn = con.Conexionbd();
    
    ps = conn.prepareStatement("Delete from tarea9 where dni =?;");
    ps.setString(1, u.getDni());
    
    ps.executeUpdate();
    
    ps.close();
    con.desconectar(conn);
    
}

public LinkedHashMap pasarDatos ()throws SQLException{
LinkedHashMap<Integer, Usuario> lista = new LinkedHashMap();

Conexion con = new Conexion();
        
        conn = con.Conexionbd();
        
        sta = conn.createStatement();
        
        result = sta.executeQuery("Select * from tarea9");
        
        while(result.next()){
            
        lista.put(suma ,new Usuario(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),(null)));
        suma ++;
        }
        
        result.close();
        sta.close();
        conn.close();
        con.desconectar(conn);
        
        return lista;
        }



}



