
package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Fecha {
    //declaración de variables
    public static Calendar calendar = Calendar.getInstance();
    private static String fecha;
    //Constructor
    public Fecha() {
    }
    
    //Metodo 1
    public static String  Fecha(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        fecha = sdf.format(calendar.getTime());
        return fecha;
    }
    
    //Metodo 2
    public static String  FechaBD(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fecha = sdf.format(calendar.getTime());
        return fecha;
    }
    
    
}
