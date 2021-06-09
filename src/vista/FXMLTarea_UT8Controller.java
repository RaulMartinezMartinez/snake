/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import modelo.ComprobarDni;
import modelo.Conexion;
import modelo.EventoDAO;
import modelo.PruebaContagio;
import modelo.PruebaContagioDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import modelo.Vacunacion;
import modelo.VacunacionDAO;

/**
 * FXML Controller class
 *
 * @author ulra7
 */
public class FXMLTarea_UT8Controller implements Initializable {

    @FXML
    private Pane paneUsuario;
    @FXML
    private RadioButton sexoH;
    @FXML
    private ToggleGroup sex;
    @FXML
    private RadioButton sexoM;
    @FXML
    private Button limpiar;
    @FXML
    private TextField stNombre;
    @FXML
    private TextField stApellidos;
    @FXML
    private TextField stDni;
    @FXML
    private DatePicker fechaNacimiento;
    @FXML
    private ComboBox<String> grupo;
    @FXML
    private Button insertarUsuario;
    @FXML
    private TableView<Usuario> lista;
    @FXML
    private TableColumn<Usuario, String> listaNombre;
    @FXML
    private TableColumn<Usuario, String> listaApellidos;
    @FXML
    private TableColumn<Usuario, String> listaDni;
    @FXML
    private TableColumn<Usuario, String> listaFecha;
    @FXML
    private TableColumn<Usuario, String> listaGrupo;
    @FXML
    private TableColumn<Usuario, String> listaSexo;
    @FXML
    private RadioButton pruebaContagio;
    @FXML
    private RadioButton pruebaVacunacion;
    @FXML
    private DatePicker fechaEvento;
    @FXML
    private RadioButton resultadoPositivo;
    @FXML
    private ToggleGroup resultado;
    @FXML
    private RadioButton resultadoNegativo;
    @FXML
    private ComboBox<String> comboPrueba;
    @FXML
    private TextField numeroDosis;
    @FXML
    private ComboBox<String> nombreVacuna;
    @FXML
    private Button insertarEvento;
    @FXML
    private Pane paneVacunacion;
    @FXML
    private Pane panePrueba;
    @FXML
    protected ListView<EventoDAO> listaEventos;
    ObservableList<EventoDAO> olEventos;

    
//Creo una lista para el TableView.
    private ObservableList<Usuario> olUsuario;
    @FXML
    private Pane paneSeleccion;
    @FXML
    private ToggleGroup tipoEvento;

    private String getSexo;

    private boolean r;

    private String lD;

    private String gGrupo = "";

    private LinkedHashMap<Integer, Usuario> lU = new LinkedHashMap();
    @FXML
    private Button añadirPrueba;
    @FXML
    private Button añadirVacuna;
    @FXML
    private Button borrarUsuario;

    private boolean opcion = false;

    private int suma = 0;
    
    private boolean dniE = true;
    
    private ArrayList<EventoDAO> eventos = new ArrayList();
    @FXML
    private Button borrarEventos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
//Creo los campos del ComboBox y establezco un prompt
        grupo.getItems().addAll("Educación", "Sanidad", "Servicios");
        grupo.setPromptText("Elige una opción");

        
//Selección por defecto de RadioButton para evitar errores.
        sex.selectToggle(sexoH);
        getSexo = "Hombre";

        
//Se muestra la fecha actual por defecto.
        fechaNacimiento.setValue(LocalDate.EPOCH);
        lD = fechaNacimiento.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        
//Uno el TableView con ObservableList.
        olUsuario = FXCollections.observableArrayList();

        
//Deshabilito los pane hasta que se elija una opción.
        paneSeleccion.setDisable(true);

        paneVacunacion.setDisable(true);

        panePrueba.setDisable(true);

        //Establezco la fecha actual en el DatePicker.
        fechaEvento.setValue(LocalDate.now());

        comboPrueba.getItems().addAll("PCR", "Antigenos", "Serologia");
        comboPrueba.setPromptText("Elige una prueba.");

        nombreVacuna.getItems().addAll("Astrazeneca", "Janssen", "Pfizer", "Moderna");
        nombreVacuna.setPromptText("Elige una opción");

        olEventos = FXCollections.observableArrayList();
        listaEventos.setItems(olEventos);

        insertarEvento.setDisable(true);

        resultado.selectToggle(resultadoNegativo);

        olEventos.clear();
        
        
        
        

        try {
            UsuarioDAO uD = new UsuarioDAO();
            ArrayList<Usuario> listUsu;

            listUsu = uD.listaBD();

            for (Usuario u : listUsu) {

                olUsuario.add(u);
                lista.setItems(olUsuario);

                listaNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombre"));
                listaApellidos.setCellValueFactory(new PropertyValueFactory<Usuario, String>("apellidos"));
                listaDni.setCellValueFactory(new PropertyValueFactory<Usuario, String>("dni"));
                listaFecha.setCellValueFactory(new PropertyValueFactory<Usuario, String>("fechaNac"));
                listaGrupo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("grupo"));
                listaSexo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("sexo"));
            }

        } catch (SQLException se) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);

            alerta.setContentText("Error al cargar BD");
            alerta.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(FXMLTarea_UT8Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//Evento para elegir sexo
    @FXML
    private void getHombre(ActionEvent event) {
        getSexo = "Hombre";
    }
//Evento para elegir sexo
    @FXML
    private void getMujer(ActionEvent event) {
        getSexo = "Mujer";
    }
//Evento para elegir fecha y pasarla a String

    @FXML
    private void getFecha(ActionEvent event) {

        lD = fechaNacimiento.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }
//Evento para pasar a String la seleccion del combo
    @FXML
    private void getGrupo(ActionEvent event) {

        gGrupo = grupo.getSelectionModel().getSelectedItem();
    }
//Boton para limpiar los datos.
    @FXML
    private void Clear(ActionEvent event) {

        //Parametros para borrar datos.
        stNombre.clear();
        stApellidos.clear();
        stDni.clear();
        grupo.getItems().clear();
        grupo.getItems().addAll("Educación", "Sanidad", "Servicios");
        fechaNacimiento.setValue(LocalDate.EPOCH);
    }
//Boton para añadir el usuario a la TableView y a la base de datos.
    @FXML
    private void getUsuario(ActionEvent event) throws SQLException {
        
        

        Usuario u = new Usuario();
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        boolean dniValido = false;

        
//Si nombre esta vacio mensaje.
        if (stNombre.getText().isEmpty()) {
            alerta.setContentText("Debe introducir un NOMBRE");
            alerta.showAndWait();
            stNombre.clear();
            return;
        } 
//Si apellidos esta vacio mensaje.
        else if (stApellidos.getText().isEmpty()) {
            alerta.setContentText("Debe introducir los APELLIDOS");
            alerta.showAndWait();
            stApellidos.clear();
            return;
        } 
//Si dni esta vacio mensaje.
        else if (gGrupo.isEmpty()) {
            alerta.setContentText("Debe introducir un grupo.");
            alerta.showAndWait();
            return;

        } else if (stDni.getText().isEmpty()) {
            alerta.setContentText("Debe introducir un DNI");
            alerta.showAndWait();
            stDni.clear();
            return;
        
        }
        
//Si dni no es correcto mensaje.
        else if (stDni.getText().matches("^[0-9]{8}[A-Z,a-z]$")) {
            dniValido = true;
        } else {
            alerta.setContentText("Debe introducir un DNI valido");
            alerta.showAndWait();
            dniValido = false;
            return;
        }
        

//Paso todos los datos a la instancia de Usuario.
        ComprobarDni cd = new ComprobarDni();
        cd.setResultado(false);
        cd.validarDni(stDni.getText());
        if(cd.isResultado()== true){
        alerta.setContentText("El Dni ya está registrado");
        alerta.showAndWait();
        stDni.clear();
        return;
        }else{

        u.setNombre(stNombre.getText());
        u.setApellidos(stApellidos.getText());
        if (dniValido == true) {
            u.setDni(stDni.getText());
        }
        u.setFechaNac(lD);
        u.setSexo(getSexo);
        u.setGrupo(gGrupo);
        }

//Añado los datos pasados a la ObservableList comprobando que el DNI no este ya registrado.

        
        olUsuario.add(u);

//Condición para que se valide el guardado.
        if (dniValido) {
            if (u.getNombre().isEmpty() || u.getApellidos().isEmpty() || u.getDni().isEmpty() || u.getGrupo().isEmpty() || u.getFechaNac().isEmpty()) {

            } else {

                alerta.setTitle("INFORMACIÓN USUARIO");
                alerta.setHeaderText("Pasaporte creado con éxito");
                alerta.setContentText(u.toString());
                alerta.showAndWait();

            }
        }

//Asocio los datos guardados en u a los campos de la TableView.
        listaNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombre"));
        listaApellidos.setCellValueFactory(new PropertyValueFactory<Usuario, String>("apellidos"));
        listaDni.setCellValueFactory(new PropertyValueFactory<Usuario, String>("dni"));
        listaFecha.setCellValueFactory(new PropertyValueFactory<Usuario, String>("fechaNac"));
        listaGrupo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("grupo"));
        listaSexo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("sexo"));

//Paso los datos a la TableView.
        lista.setItems(olUsuario);

//Inserto los datos en la base de datos.
        UsuarioDAO uD = new UsuarioDAO();
        
        uD.insertar(u);
        

//Una vez introducido el usuario borro los campos.
        stNombre.clear();
        stApellidos.clear();
        stDni.clear();
        grupo.getItems().clear();
        grupo.getItems().addAll("Educación", "Sanidad", "Servicios");
        fechaNacimiento.setValue(LocalDate.EPOCH);

        paneSeleccion.setDisable(false);
        lU = uD.pasarDatos();
        lista.getSelectionModel().selectLast();

    }

//Evento para opción de prueba.
    @FXML
    private void Contagio(ActionEvent event) {

        panePrueba.setDisable(false);
        paneVacunacion.setDisable(true);
        insertarEvento.setDisable(true);

    }
//Evento para opción de vacunación

    @FXML
    private void Vacunacion(ActionEvent event) throws InterruptedException {

        paneVacunacion.setDisable(false);
        panePrueba.setDisable(true);
        insertarEvento.setDisable(true);
        PruebaContagio pc = new PruebaContagio();
        pc.setPrueba("Vacunación");

    }

// Evento para añadir el evento a Usuario.
    @FXML
    private void getVacuna(ActionEvent event) throws SQLException {

        UsuarioDAO uD = new UsuarioDAO();
        Usuario u2 = new Usuario(lista.getSelectionModel().getSelectedItem());
        Vacunacion v2 = new Vacunacion();
        VacunacionDAO vD = new VacunacionDAO();

        LocalDate fechae = LocalDate.now();

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        if (nombreVacuna.getSelectionModel().getSelectedItem() == null) {
            alerta.setContentText("Debe introducir un tipo de prueba");
            alerta.showAndWait();
            return;

        } else {

            if ("1".equals(numeroDosis.getText())) {

                insertarEvento.setDisable(false);
            } else if ("2".equals(numeroDosis.getText())) {

                insertarEvento.setDisable(false);
            } else {
                alerta.setContentText("El número de dosis introducido no es correcto.");
                alerta.showAndWait();
                numeroDosis.setText(null);
                v2.setNumDosis(null);
                return;
            }

            v2.setFecha(fechae.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            v2.setNombreVacuna(nombreVacuna.getSelectionModel().getSelectedItem());
            v2.setNumDosis(numeroDosis.getText());
            v2.setDni(u2.getDni());
            v2.setPrueba("Vacunación");

            vD.insertarVacuna(v2);
            eventos.clear();
            eventos = vD.listaV(u2);

        }
    }

//Evento para añadir el evento de tipo prueba al usuario seleccionado
    @FXML
    private void getContagio(ActionEvent event) throws SQLException {

        Usuario u3 = new Usuario(lista.getSelectionModel().getSelectedItem());
        PruebaContagioDAO pcDAO = new PruebaContagioDAO();
        PruebaContagio pc3 = new PruebaContagio();

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        LocalDate fechae = LocalDate.now();

        if (comboPrueba.getSelectionModel().getSelectedItem() == null) {
            alerta.setContentText("Debe introducir un tipo de prueba");
            alerta.showAndWait();
            return;

        } else {

            pc3.setPositivo(r);
            pc3.setFecha(fechae.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            pc3.setTipoPrueba(comboPrueba.getSelectionModel().getSelectedItem());
            pc3.setDni(u3.getDni());
            pc3.setPrueba("Prueba de contagio");

            pcDAO.insertarEvento(pc3);
            eventos.clear();
            eventos = pcDAO.listaE(u3);

            insertarEvento.setDisable(false);
        }
    }
//Pasar los eventos almacenados en la base de datos a ListtView

    @FXML
    private void getEvento(ActionEvent event) throws SQLException {
        olEventos.clear();
        
        
        for (EventoDAO e : eventos) {
            olEventos.add(e);
            suma++;
        }
        insertarEvento.setDisable(true);

    }
//Evento para booleano positivo.

    @FXML
    private void rPositivo(ActionEvent event) {
        r = true;
        PruebaContagio pc = new PruebaContagio();
        pc.setPositivo(r);
    }
//Evento para booleano negativo.

    @FXML
    private void rNegativo(ActionEvent event) {
        r = false;
        PruebaContagio pc = new PruebaContagio();
        pc.setPositivo(r);
    }
//Boton para borrar los eventos de un usuario
    @FXML
    private void deleteUsuario(ActionEvent event) throws SQLException {
        Usuario uB = new Usuario(lista.getSelectionModel().getSelectedItem());

        olUsuario.remove(lista.getSelectionModel().getSelectedIndex());

        UsuarioDAO uDB = new UsuarioDAO();

        uDB.borrar(uB);

    }

    
    

    @FXML
    private void pulsarUsuario(MouseEvent event) throws SQLException {
        paneSeleccion.setDisable(false);
        olEventos.clear();

        ArrayList<EventoDAO> eventos = new ArrayList();
        PruebaContagioDAO pcD = new PruebaContagioDAO();
        Usuario u = new Usuario(lista.getSelectionModel().getSelectedItem());
        eventos = pcD.listaE(u);

        for (EventoDAO e : eventos) {
            olEventos.add(e);
            suma++;
        }

    }

    @FXML
    private void deleteEventos(ActionEvent event) throws SQLException {
        PruebaContagioDAO pcD = new PruebaContagioDAO();
        listaEventos.getSelectionModel().selectLast();
        
        pcD.borrarEvento(listaEventos.getSelectionModel().getSelectedItem());
        olEventos.clear();
       
    }

}
