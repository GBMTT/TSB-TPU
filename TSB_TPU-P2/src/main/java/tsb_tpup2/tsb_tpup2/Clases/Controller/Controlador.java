package tsb_tpup2.tsb_tpup2.Clases.Controller;

import tsb_tpup2.tsb_tpup2.Clases.Model.Resultados;
import tsb_tpup2.tsb_tpup2.Clases.Model.Serie;
import tsb_tpup2.tsb_tpup2.Clases.TSBHashtableDA;

import java.io.File;
import java.util.*;

// clase encargada de la logica de ejecucion de los distintos conteos y resultados que deben obtenerse
public class Controlador {

    private static TSBHashtableDA<String, Resultados> ht = new TSBHashtableDA<>();
    private static HashSet<String> listaGeneros = new HashSet<>();

    public Controlador() {}

    // resuelve la lectura del archivo y la obtencion de los resultados para cada genero de serie disponible
    public static void recorrerArchivo(){
        try {
            Scanner file = new Scanner(new File("D:\\Users\\Asus\\Documents\\GitHub\\TSB_TPU-P2\\src\\main\\resources\\tsb_tpup2\\tsb_tpup2\\series_data_clean.csv"));
            int cont = 0;

            while(file.hasNextLine()) {
                if(cont<=0) {
                    file.nextLine();
                    cont++;
                }

                Object []valores = file.nextLine().split(",");
                Serie serie = new Serie();

                serie.setTitulo((String)valores[0]);
                serie.setRunTimeSerie((String)valores[1]);
                serie.setCalificacion((String)valores[2]);
                serie.setRunTimeEpisodio((String)valores[3]);
                String generos = (String) valores[4];
                serie.setGeneros(generos.split("\\|"));
                serie.setRating(Double.parseDouble((String)valores[5]));
                serie.setArgumento((String)valores[6]);
                serie.setStar1((String)valores[7]);
                serie.setStar2((String)valores[8]);
                serie.setStar3((String)valores[9]);
                serie.setStar4((String)valores[10]);
                serie.setNroVotos(Integer.parseInt((String)valores[11]));

                // se recorren todos los generos de cada serie y se obtienen los resultados
                for (String genero: serie.getGeneros()) {
                    if (!ht.containsKey(genero)) {
                        Resultados res = new Resultados();
                        ht.put(genero, res);
                    }
                    ht.get(genero).obtenerResultados(ht,serie,genero);
                    listaGeneros.add(genero);
                }
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // resuelve la entrega de los resultados de acuerdo con el genero y conteo solicitados
    public Object mostrarResultado(String genero, String resSolicitado) {
        switch (resSolicitado) {
            case "Cantidad de Series":
                return recuperarCantidadDeSeries(genero);
            case "Detalles de Series":
                return recuperarDetalleDeSeries(genero);
            case "Cantidad por Puntuacion":
                return recuperarCantidadPorPuntuacion(genero);
            default: return null;
        }
    }

    private int recuperarCantidadDeSeries(String genero) {
        return ht.get(genero).getCantSeriesPorGenero();
    }

    private ArrayList<Serie> recuperarDetalleDeSeries(String genero) {
        return ht.get(genero).getSeriesDeGenero();
    }

    private Integer[] recuperarCantidadPorPuntuacion(String genero) {
        return ht.get(genero).getCantSeriesPorPuntuacion();
    }


    public static TSBHashtableDA<String, Resultados> getHt() {
        return ht;
    }

    public static void setHt(TSBHashtableDA<String, Resultados> ht) {
        Controlador.ht = ht;
    }

    public static HashSet<String> getListaGeneros() {
        return listaGeneros;
    }

    public static void setListaGeneros(HashSet<String> listaGeneros) {
        Controlador.listaGeneros = listaGeneros;
    }
}
