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
class PintaHTML {

    static String crearTabla(ArrayList<DatoHorario> datos) {
        String aux="<HTML>\n" +
"\n" +
"<head>\n" +
"<title>Contaminación</title>\n" +
"</head>\n" +
"<body>";
        aux+="<table border=1>";
        aux+="<tr><th>Estacion</th><th>Magnitud</th>";
        aux+=crearEncabezadosHorarios(datos.get(0).getVerificados());
        aux+="</tr>";
        
        for(DatoHorario d:datos)
        {
           aux+="<tr>";
           aux+="<td>"+DatosEstaciones.mapa_valores_estaciones.get(d.getEstacion())+"</td>";
           aux+="<td>"+DatosEstaciones.mapa_valores_magnitudes.get(d.getMagnitud())+"</td>";
           aux+=crearColumnas(d.getCantidades(), d.getVerificados());
           aux+="</tr>";
        }
        
        aux+="</body>\n" +
"</html>";
        return aux;
    }
    private static String crearEncabezadosHorarios(ArrayList<Character> verificados)
    {
        String aux="";
        int contador=0;
        for (char letra : verificados) {
            if(letra=='V')
            {
                aux+="<th>"+contador+"-"+(++contador)+"</th>";
                
            
                    }
            else
            {
                return aux;
            }
        }
        return aux;
    }
    private static String crearColumnas(ArrayList<Float> cantidades, ArrayList<Character> verificados)
    {
        String aux="";
        for(int i=0; i<cantidades.size(); i++)
        {
            char a=verificados.get(i);
            if (a=='V')
            {
                //Creo columna con el dato
                aux+="<td>"+cantidades.get(i)+"</td>";
            }
            else
            {
                //Me puedo salir
                return aux;
            }
        }
        return aux;
    }
    
}
