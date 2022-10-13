package test.clases;

import clases.TSBHashtableDA;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * Una clase con un main() simple para probar la clase TSBHashtableDA.
 * @author Ing. Valerio Frittelli.
 * @version Octubre de 2017.
 */
public class Test 
{
    public static void main(String[] args)
    {
        // una tabla "corta" con factor de carga pequeño...
        TSBHashtableDA<Integer, String> ht1 = new TSBHashtableDA<>(3, 0.2f);
        System.out.println("Contenido inicial: " + ht1);
        
        // algunas inserciones...
        //ht1.put(1, "Argentina");
        ht1.put(2, "Brasil");
        ht1.put(3, "Chile");
        ht1.put(4, "Mexico");
        ht1.put(5, "Uruguay");
        //ht1.put(6, "Perú");
        ht1.put(7, "Colombia");
        ht1.put(8, "Ecuador");
        ht1.put(9, "Paraguay");
        ht1.put(10, "Bolivia");
        //ht1.put(11, "Venezuela");
        ht1.put(12, "Estados Unidos");

        System.out.println("Luego de algunas inserciones: " + ht1);

        System.out.println();

        Object borrado = ht1.remove(8);
        System.out.println((borrado != null) ? "Elemento borrado: " + borrado : "Ningun entry cuenta con esa key, por lo que no se borro ningun objeto");

        Object borrado1 = ht1.remove(11);
        System.out.println((borrado1 != null) ? "Elemento borrado: " + borrado1 : "Ningun entry cuenta con esa key, por lo que no se borro ningun objeto");

        System.out.println();

        TSBHashtableDA<Integer, String> ht2 = new TSBHashtableDA<>(ht1);
        System.out.println("Segunda tabla: " + ht2);

        System.out.println();

        System.out.println("Tabla 1 recorrida a partir de una vista: ");
        Set<Map.Entry<Integer, String>> se = ht1.entrySet();

        for (Map.Entry<Integer, String> entry : se) {
            System.out.println("Par: " + entry);
        }

    }
}
