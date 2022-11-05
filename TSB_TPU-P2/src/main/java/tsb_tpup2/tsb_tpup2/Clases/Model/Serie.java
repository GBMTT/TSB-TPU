package tsb_tpup2.tsb_tpup2.Clases.Model;

// clase que gestiona y almacena las series
public class Serie
{
    private String titulo;
    private String runTimeSerie;
    private String calificacion;
    private String runTimeEpisodio;
    private String[] generos;
    private double rating;
    private String argumento;
    private String star1;
    private String star2;
    private String star3;
    private String star4;
    private int nroVotos;
    private int cantidad;
    public Serie() {
    }

    public Serie(String titulo, double rating) {
        this.titulo = titulo;
        this.rating = rating;
    }

    public Serie(double rating, int cantidad) {
        this.rating = rating;
        this.cantidad = cantidad;
    }

    public Serie(String titulo, String runTimeSerie, String calificacion, String runTimeEpisodio, String[] generos, double rating, String argumento, String star1, String star2, String star3, String star4, int nroVotos) {
        this.titulo = titulo;
        this.runTimeSerie = runTimeSerie;
        this.calificacion = calificacion;
        this.runTimeEpisodio = runTimeEpisodio;
        this.generos = generos;
        this.rating = rating;
        this.argumento = argumento;
        this.star1 = star1;
        this.star2 = star2;
        this.star3 = star3;
        this.star4 = star4;
        this.nroVotos = nroVotos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRunTimeSerie() {
        return runTimeSerie;
    }

    public void setRunTimeSerie(String runTimeSerie) {
        this.runTimeSerie = runTimeSerie;
    }

    public String getRunTimeEpisodio() {
        return runTimeEpisodio;
    }

    public void setRunTimeEpisodio(String runTimeEpisodio) {
        this.runTimeEpisodio = runTimeEpisodio;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public String getStar1() {
        return star1;
    }

    public void setStar1(String star1) {
        this.star1 = star1;
    }

    public String getStar2() {
        return star2;
    }

    public void setStar2(String star2) {
        this.star2 = star2;
    }

    public String getStar3() {
        return star3;
    }

    public void setStar3(String star3) {
        this.star3 = star3;
    }

    public String getStar4() {
        return star4;
    }

    public void setStar4(String star4) {
        this.star4 = star4;
    }

    public int getNroVotos() {
        return nroVotos;
    }

    public void setNroVotos(int nroVotos) {
        this.nroVotos = nroVotos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}