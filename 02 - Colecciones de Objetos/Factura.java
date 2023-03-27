
/**
 * Write a description of class Factura here.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
import java.util.Vector;

public class Factura
{
    // Variables de Instancia 
    private String empresa;
    private String cliente;
    private static int num = 100;
    private Vector<Articulo> articulos;

    /**
     * Constructor para objetos de la clase Factura
     */
    public Factura(String nomC)
    {
        empresa = new String("Papeleria Mony");
        cliente = new String(nomC);
        num++;
        articulos = new Vector<Articulo>();

    }
    
    public int getNumArticulos() {
        return articulos.size();
    }
    
    public void agregaArticulo(Articulo art) {
        articulos.add(art);
    }
    
    public void setArticulo(int index, Articulo art) {
        articulos.set(index, art);
    }
    
    public Articulo getArticulo(int index) {
        return articulos.get(index);
    }
    
    public double calculaTotalArticulos() {
        ;
        double suma = 0.0;
        /*for(int i = 0; i < articulos.size(); i++) {
            recorre = getArticulo(i);
            suma += recorre.importe();
        }*/
        for(Articulo recorre : articulos) {
            suma += recorre.importe();
        }
        return suma;
    }
    
}






