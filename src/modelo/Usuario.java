/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author ulra7
 */
public class Usuario {

    private LinkedList<EventoCovid> ListaEventos = new LinkedList();

    private String nombre;
    private String apellidos;
    private String dni;
    private String fechaNac;
    private String grupo;
    private String sexo;
    private LocalDate fechaLocal;
    
    
    

    public Usuario() {
    }

    ;

    public Usuario(String nombre, String apellidos, String dni, String fechaNac, String grupo, String sexo, LocalDate fechaLocal) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.grupo = grupo;
        this.sexo = sexo;
        this.fechaLocal = fechaLocal;
    }

    public Usuario(Usuario u) {
        this.nombre = u.getNombre();
        this.apellidos = u.getApellidos();
        this.dni = u.getDni();
        this.fechaNac = u.getFechaNac();
        this.grupo = u.getGrupo();
        this.sexo = u.getSexo();
        this.ListaEventos = u.getListaEventos();
        
        
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaLocal() {
        return fechaLocal;
    }

    public void setFechaLocal(LocalDate fechaLocal) {
        this.fechaLocal = fechaLocal;
    }

    public LinkedList<EventoCovid> getListaEventos() {
        return ListaEventos;
    }

    public void setListaEventos(LinkedList<EventoCovid> ListaEventos) {
        this.ListaEventos = ListaEventos;
    }
    
    

    public void añadirEventoCovid(EventoCovid ec) {
        ListaEventos.add(ec);
        System.out.println(ListaEventos.clone());
    }

    public void eliminarEventoCovid(EventoCovid ec) {
        ListaEventos.remove(ec);
    }

    @Override
    public String toString() {
               
        return  nombre + " " + apellidos + " DNI: "+ dni + " Nacimiento: " + fechaNac + " Grupo: " + grupo + ", Sexo: " + sexo;
        
      
        
        
        
        
        
    }

   

    

   

   

   
}
