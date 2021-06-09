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
public class EventoDAO {
    private String dni;
    private String tipoEvento;
    private String resultado;
    private String tipo;
    private String fecha;

    public EventoDAO(String dni, String tipoEvento, String resultado, String tipo, String fecha) {
        this.dni = dni;
        this.tipoEvento = tipoEvento;
        this.resultado = resultado;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public EventoDAO(PruebaContagio pc) {
        
        this.dni = pc.getDni();
        this.tipoEvento = pc.getTipoPrueba();
        this.resultado = pc.getResultado();
        this.tipo = pc.getPrueba();
        this.fecha = pc.getFecha();
    }

    public String getDni() {
        return dni;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    

    @Override
    public String toString() {
        return tipoEvento + "      Resultado: " + resultado + ". Tipo prueba: " + tipo + ". Fecha: " + fecha;
    }
    
    
}
