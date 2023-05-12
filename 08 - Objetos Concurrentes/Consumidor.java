public class Consumidor extends Thread {
    private Almacen dato;

    public Consumidor(Almacen d) {
        this.dato = d;
    }

    public void run() {
        int num;
        for (int i = 1; i <= 10; i++) {
            try {
                sleep( (int) Math.random() * 500 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num = dato.getValor();
            System.out.println("Se extrajo el valor: " + num);
        }
    }

    
}