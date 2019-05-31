/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaminacionxml;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Admin
 */
class ParsearXML {

    static ArrayList<DatoHorario> parsear() {
       ArrayList<DatoHorario> lista_datos=new ArrayList<>();
        try {
            
            //Simple API for XML
            SAXBuilder builder=new SAXBuilder();
            URL url=new URL("http://www.mambiente.madrid.es/opendata/horario.xml");
            Document documento_xml=builder.build(url);
            Element elemento_raiz=documento_xml.getRootElement();
            List<Element> lista_dato_horario=elemento_raiz.getChildren();
            for(Element elemento: lista_dato_horario)//Recorro los DatosHorario
            {
               List<Element> hijos_dato_horario=elemento.getChildren();
                String estacion=hijos_dato_horario.get(2).getValue();
                String magnitud=hijos_dato_horario.get(3).getValue();
                String ano=hijos_dato_horario.get(5).getValue();
                String mes=hijos_dato_horario.get(6).getValue();
                String dia=hijos_dato_horario.get(7).getValue();
                String fecha=dia+"/"+mes+"/"+ano;
                ArrayList<Float> lista_cantidades=sacarCantidades(elemento);
                ArrayList<Character> lista_verifcaciones=verificarCantidades(elemento);
               //public DatoHorario(int estacion, int magnitud, String fecha, ArrayList<Float> cantidades, ArrayList<Character> verificados) { 
            DatoHorario d=new DatoHorario(Integer.parseInt(estacion), 
                    Integer.parseInt(magnitud), fecha, lista_cantidades, lista_verifcaciones);
            lista_datos.add(d);
            }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(ParsearXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDOMException ex) {
            Logger.getLogger(ParsearXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParsearXML.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       return lista_datos;
    }

    private static ArrayList<Float> sacarCantidades(Element elemento) {
        ArrayList<Float> lista_cantidades=new ArrayList<>();
        List<Element> hijos_dato_horario=elemento.getChildren();
        for (int i=8; i<hijos_dato_horario.size(); i=i+2)
        {
            String valor=hijos_dato_horario.get(i).getValue();
            Float valor_float=Float.parseFloat(valor);
            lista_cantidades.add(valor_float);
        }
        return lista_cantidades;
    }

    private static ArrayList<Character> verificarCantidades(Element elemento) {
        ArrayList<Character> lista_verificaciones=new ArrayList<>();
        List<Element> hijos_dato_horario=elemento.getChildren();
        for (int i=9; i<hijos_dato_horario.size(); i=i+2)
        {
            String valor=hijos_dato_horario.get(i).getValue();
            Character caracter=valor.charAt(0);
            lista_verificaciones.add(caracter);
        }
        return lista_verificaciones;
    }
    
}
