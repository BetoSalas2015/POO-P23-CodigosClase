
/**
 * Write a description of class TestPunto here.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
public class TestPunto
{
    /**
     * Constructor para objetos de la clase TestPunto
     */
    public TestPunto()
    {
    }
    
    public static void main(String[] args) {
        Punto<Integer> puntoEntero = new Punto<Integer>(new Integer(4), new Integer(5));
        Punto<Double> puntoDouble = new Punto<Double>(new Double(2.5), new Double(2.75));
    
        System.out.println(puntoEntero.toString() );
        System.out.println(puntoDouble.toString() );
        }
    }
    










