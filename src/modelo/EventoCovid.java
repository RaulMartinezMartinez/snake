/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ulra7
 */
public abstract class EventoCovid {
    
    protected String fecha;
    private String dni;
    private String prueba;
    
    public EventoCovid(){}

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }
    
    

    @Override
    public String toString() {
        return "EventoCovid{" + "fecha=" + fecha + '}';
    }
    
    
}
