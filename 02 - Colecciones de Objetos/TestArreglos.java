
/**
 * Write a description of class TestArreglos here.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
public class TestArreglos
{
    // Variables de Instancia 
    private int arreglo[], arreglo4;
    private int []arreglo2, arreglo5;
    private int[] arreglo3 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    
    private int[][] matriz, matriz2 = { {1, 2, 3}, {4}, {5, 6, 7, 8}, { 9, 0} } ;

    /**
     * Constructor para objetos de la clase TestArreglos
     */
    public TestArreglos()
    {
        arreglo = new int[5];
        for(int i = 0; i < arreglo.length; i++)
            arreglo[i] = i;
        matriz = new int[3][3];
        
        for(int i = 0; i < matriz2.length; i++) {
            for(int j = 0; j < matriz2[i].length; j++)
                System.out.print(matriz2[i][j] + ", ");
            System.out.println("");
        }
    }
    
    public static int square(int x) {
        return x * x;
    }
    
    public static void inicializaArreglo(int[] arreglo, int val) {
        for(int i = 0; i < arreglo.length; i++)
            arreglo[i] = val;
    }
    
    public static void main(String args[]) {
        square(5);          //  PAso de argumentos por valor 
        int arr[] = new int[10];
        inicializaArreglo(arr, 100); // paso de Parametros por referencia
    }
    
}
