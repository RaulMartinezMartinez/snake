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
public class Vacunacion extends EventoCovid {
    
    private String numDosis;
    private String nombreVacuna;
    
    public Vacunacion (){}

    public String getNumDosis() {
        return numDosis;
    }

    public void setNumDosis(String numDosis) {
        this.numDosis = numDosis;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
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
    public void setPrueba(String prueba) {
        super.setPrueba(prueba); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPrueba() {
        return super.getPrueba(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDni(String dni) {
        super.setDni(dni); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDni() {
        return super.getDni(); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public String toString() {
        return "Dosis puestas" + numDosis + ", Vacuna de: " + nombreVacuna + super.getFecha();
    }

   
    
    
    
    
            
}
