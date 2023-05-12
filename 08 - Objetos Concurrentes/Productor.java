public class Productor extends Thread {
    private Almacen dato;

    public Productor(Almacen d) {
        this.dato =  d;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            dato.setValor(i);
            System.out.println("Se guardó en el almacen el valor " + i);
            try {
                sleep( (int) Math.random() * 500 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
