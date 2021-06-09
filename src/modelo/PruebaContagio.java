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
public class PruebaContagio extends EventoCovid {

    private String tipoPrueba;
    private boolean positivo;
    private String resultado;

    @Override
    public void setPrueba(String prueba) {
        super.setPrueba(prueba); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPrueba() {
        return super.getPrueba(); //To change body of generated methods, choose Tools | Templates.
    }
    

    

    public PruebaContagio() {
    }

    public String getTipoPrueba() {
        return tipoPrueba;
    }

    public void setTipoPrueba(String tipoPrueba) {
        this.tipoPrueba = tipoPrueba;
    }

    public boolean isPositivo() {
        return positivo;
    }
    
    public void setPositivo(boolean gP) {
    if(gP == true){
    resultado = "positivo";
    }else{
    resultado = "negativo";
    }
    
    
    
   
   
    }

    @Override
    public void setDni(String dni) {
        super.setDni(dni); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDni() {
        return super.getDni(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    

    @Override
    public void setFecha(String fecha) {
        super.setFecha(fecha); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFecha() {
        return super.getFecha(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "PruebaContagio{" + "tipoPrueba=" + tipoPrueba + ", positivo=" + positivo + ", resultado=" + resultado + " " +super.getFecha()+" "+super.getDni();
    }

    
    

}
