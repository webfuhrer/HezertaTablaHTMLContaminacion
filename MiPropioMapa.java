/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contaminacionxml;

import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class MiPropioMapa extends HashMap<Integer, String>{

    @Override
    public String get(Object key) {
        String devuelve_padre=super.get(key);
        if(devuelve_padre==null)
        {
            return "No existe("+key.toString()+")";
        }
        return devuelve_padre; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
