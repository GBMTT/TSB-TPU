package tsb_tpup2.tsb_tpup2.Clases.Util;

// clase proveedora de servicios
public class Truncador {
    // metodo encargado de truncar un numero indicando el numero de decimales requerido
    public static double truncar(double aTruncar, int decimales) {
        aTruncar = aTruncar * Math.pow(10, decimales);
        aTruncar = Math.floor(aTruncar);
        aTruncar = aTruncar / Math.pow(10, decimales);

        return aTruncar;
    }
}
