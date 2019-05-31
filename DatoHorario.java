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
public class DatoHorario {
    private int estacion, magnitud;
    private String fecha;
    private ArrayList<Float> cantidades;
    private ArrayList<Character> verificados;

    public DatoHorario(int estacion, int magnitud, String fecha, ArrayList<Float> cantidades, ArrayList<Character> verificados) {
        this.estacion = estacion;
        this.magnitud = magnitud;
        this.fecha = fecha;
        this.cantidades = cantidades;
        this.verificados = verificados;
    }

    public int getEstacion() {
        return estacion;
    }

    public int getMagnitud() {
        return magnitud;
    }

    public String getFecha() {
        return fecha;
    }

    public ArrayList<Float> getCantidades() {
        return cantidades;
    }

    public ArrayList<Character> getVerificados() {
        return verificados;
    }

    @Override
    public String toString() {
        String aux="ESTACION: "+estacion+"\n";
        aux+=" MAGNITUD: "+magnitud+"\n";
        for(int i=0; i<cantidades.size(); i++)
        {
            if(verificados.get(i).equals('V'))
            {
                aux+=cantidades.get(i)+", ";
            }
        }
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
    
}
