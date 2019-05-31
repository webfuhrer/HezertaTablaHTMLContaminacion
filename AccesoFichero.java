
package contaminacionxml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
class AccesoFichero {

    static void grabarHTML(String html_tabla) {
        try {
            FileWriter fw=new FileWriter("D:\\tabla_contaminacion.html");
            fw.write(html_tabla);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
