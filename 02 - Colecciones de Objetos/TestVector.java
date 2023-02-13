
/**
 * Write a description of class TestVector here.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */

import java.util.Vector;

public class TestVector
{
    // Variables de Instancia 
    private Vector vector;

    /**
     * Constructor para objetos de la clase TestVector
     */
    public TestVector()
    {
        vector = new Vector();
        vector.add( new Integer(5) );
        System.out.println(vector.get(0));
        
    }
    
}







