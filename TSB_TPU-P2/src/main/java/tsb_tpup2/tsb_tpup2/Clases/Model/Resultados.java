package tsb_tpup2.tsb_tpup2.Clases.Model;

import tsb_tpup2.tsb_tpup2.Clases.TSBHashtableDA;
import tsb_tpup2.tsb_tpup2.Clases.Util.Truncador;
import java.util.ArrayList;
import java.util.HashMap;

public class Resultados {
    private int cantSeriesPorGenero;
    private ArrayList<Serie> seriesDeGenero;
    private Integer[] cantSeriesPorPuntuacion;

    public Resultados() {
        cantSeriesPorGenero = 0;
        cantSeriesPorPuntuacion = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        seriesDeGenero = new ArrayList<>();
    }

    public void obtenerResultados(HashMap<String,Resultados> ht, Serie serie, String genero) {
        ht.get(genero).cantSeriesPorGenero++;
        Serie serieParaDetalles = new Serie(serie.getTitulo(), serie.getRating());
        ht.get(genero).seriesDeGenero.add(serieParaDetalles);
        ht.get(genero).cantSeriesPorPuntuacion[(int) (Truncador.truncar(serie.getRating(), 0)-1)]++;
    }

    public int getCantSeriesPorGenero() {
        return cantSeriesPorGenero;
    }

    public void setCantSeriesPorGenero(int cantSeriesPorGenero) {
        this.cantSeriesPorGenero = cantSeriesPorGenero;
    }

    public ArrayList<Serie> getSeriesDeGenero() {
        return seriesDeGenero;
    }

    public void setSeriesDeGenero(ArrayList<Serie> seriesDeGenero) {
        this.seriesDeGenero = seriesDeGenero;
    }

    public Integer[] getCantSeriesPorPuntuacion() {
        return cantSeriesPorPuntuacion;
    }

    public void setCantSeriesPorPuntuacion(Integer[] cantSeriesPorPuntuacion) {
        this.cantSeriesPorPuntuacion = cantSeriesPorPuntuacion;
    }

}