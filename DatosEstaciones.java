/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaminacionxml;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class DatosEstaciones {
    public static HashMap<Integer, String> mapa_valores_estaciones=new MiPropioMapa();
    public static HashMap<Integer, String> mapa_valores_magnitudes=new MiPropioMapa();
    
    public static void inicializarValores()
    {
       mapa_valores_estaciones.put(4, "Plaza de España");
       mapa_valores_estaciones.put(8, "Escuelas Aguirre");
       mapa_valores_estaciones.put(11, "Av. Ramón y Cajal");
       mapa_valores_estaciones.put(16, "Arturo Soria");
       mapa_valores_magnitudes.put(6, "Monóxido de Carbono");
       mapa_valores_magnitudes.put(7, "Monóxido de Nitrógeno");
       mapa_valores_magnitudes.put(8, "Dióxido de Nitrógeno");
    }
}
