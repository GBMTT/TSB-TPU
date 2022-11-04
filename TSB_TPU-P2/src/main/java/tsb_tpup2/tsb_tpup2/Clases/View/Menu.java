package tsb_tpup2.tsb_tpup2.Clases.View;

import javafx.beans.binding.ListExpression;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import tsb_tpup2.tsb_tpup2.Clases.Controller.Controlador;
import tsb_tpup2.tsb_tpup2.Clases.Model.Serie;
import tsb_tpup2.tsb_tpup2.Clases.Util.ColumnData;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Menu implements Initializable {
    @FXML
    private Button btnBuscar;
    @FXML
    private ComboBox<String> cbxGeneros;
    @FXML
    private ComboBox<String> cbxResultado;
    @FXML
    private Label lblElegirGenero;
    @FXML
    private Label lblResultado;
    @FXML
    private TableView dgvDetalle;
    @FXML
    private TableView dgvRating;
    @FXML
    private TableColumn cTitulo;
    @FXML
    private TableColumn cRating;
    @FXML
    private TableColumn cRating2;
    @FXML
    private TableColumn cCantidad;
    private Controlador controlador;
    private HashSet<String> generos;
    private Set<String> resultados = Set.of("Cantidad por Puntuacion", "Detalles de Series", "Cantidad de Series");
    private List<ColumnData> cabeceras;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.controlador = new Controlador();
        this.controlador.recorrerArchivo();
        this.generos = Controlador.getListaGeneros();
        cargarComboBox(this.cbxGeneros, generos);
        cargarComboBox(this.cbxResultado, resultados);
        this.dgvDetalle.setVisible(false);
    }

    public void cargarComboBox(ComboBox combo, Set<String> generos){
        combo.getItems().addAll(generos);
    }

    @FXML
    private void buscar(ActionEvent event) {
        this.dgvDetalle.setVisible(true);
        this.dgvDetalle.getItems().clear();
        this.dgvDetalle.getColumns().clear();

        this.crearColumnas();
        this.cargarColumnas();

        Object resultado = this.controlador.mostrarResultado(cbxGeneros.getValue(), cbxResultado.getValue());
        cargarResultados(resultado);
    }

    private void cargarResultados(Object resultadoBusqueda) {
        switch (cbxResultado.getValue()) {
            case "Cantidad de Series":
                this.dgvDetalle.setVisible(false);
                String resultado = "El genero " + cbxGeneros.getValue() + " cuenta con " + resultadoBusqueda.toString() + " series";
                Alert dialogo = new Alert(Alert.AlertType.CONFIRMATION);
                dialogo.setTitle("Cantidad de Series");
                dialogo.setHeaderText(resultado);
                dialogo.showAndWait();
                break;
            case "Detalles de Series":
                for(Serie detalle:(ArrayList<Serie>)resultadoBusqueda) {
                    this.dgvDetalle.getItems().add(detalle);
                }
                break;
            case "Cantidad por Puntuacion":
                for (int i = 0; i < ((Integer[])resultadoBusqueda).length; i++) {
                    this.dgvDetalle.getItems().add(new Serie(i+1,((Integer[])resultadoBusqueda)[i]));
                }
                break;
        }
    }

    private void crearColumnas() {
        this.cabeceras = new ArrayList<>();
        switch (cbxResultado.getValue()) {
            case "Cantidad de Series":
                this.dgvDetalle.getColumns().clear();
            case "Detalles de Series":
                ColumnData columna1 = new ColumnData("titulo", "Titulo", 200.0);
                ColumnData columna2 = new ColumnData("rating", "Rating", 100.0);
                this.cabeceras.add(columna1);
                this.cabeceras.add(columna2);
                break;
            case "Cantidad por Puntuacion":
                ColumnData columna3 = new ColumnData("rating", "Rating", 100.0);
                ColumnData columna4 = new ColumnData("cantidad", "Cantidad de Series", 150.0);
                this.cabeceras.add(columna3);
                this.cabeceras.add(columna4);
                break;
        }
    }

    private void cargarColumnas() {
        List<TableColumn<String, ?>> columnas = this.cabeceras.stream()
                .map((x) -> this.CrearColumna(x))
                .collect(Collectors.toList());
        this.dgvDetalle.getColumns().addAll((columnas));
        this.dgvDetalle.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
    }

    private TableColumn<String, ?> CrearColumna(ColumnData columnData) {
        TableColumn<String, ?> column = new TableColumn<>(columnData.getCabecera());
        column.setCellValueFactory(new PropertyValueFactory<>(columnData.getProperty()));
        column.setPrefWidth(columnData.getSize());
        return column;
    }
}