package tsb_tpup2.tsb_tpup2.Clases.Util;

// clase utilizada para la construccion de las columnas de un TableView en JavaFX
public class ColumnData {
    private String property;
    private String cabecera;
    private Double size;
    public ColumnData() { }

    public ColumnData(String property, String cabecera, Double size) {
        this.property = property;
        this.cabecera = cabecera;
        this.size = size;
    }

    public String getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getCabecera() {
        return this.cabecera;
    }

    public void setCabecera(String cabecera) {
        this.cabecera = cabecera;
    }

    public Double getSize() {
        return this.size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
