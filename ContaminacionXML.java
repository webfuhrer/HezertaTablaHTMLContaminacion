/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaminacionxml;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ContaminacionXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatosEstaciones.inicializarValores();
        ArrayList<DatoHorario> datos=ParsearXML.parsear();
       String html_tabla=PintaHTML.crearTabla(datos);
        AccesoFichero.grabarHTML(html_tabla);
        
    }
    
}
