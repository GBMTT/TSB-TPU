package tsb_tpup2.tsb_tpup2.Clases.Util;

public class Truncador {
    public static double truncar(double aTruncar, int decimales) {
        aTruncar = aTruncar * Math.pow(10, decimales);
        aTruncar = Math.floor(aTruncar);
        aTruncar = aTruncar / Math.pow(10, decimales);

        return aTruncar;
    }
}
