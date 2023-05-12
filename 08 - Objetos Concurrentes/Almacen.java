public class Almacen {
    private int valor;
    private boolean libre = true;

    public Almacen() {}

    public synchronized void setValor(int valor) {
        while (!libre) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }     
        }
        this.valor = valor;
        libre = false;
        notify();
    }

    public synchronized int getValor() {
        int val;
        while(libre) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }      
        } 
        val = this.valor;
        libre = true;
        notify();
        return val;
    } 
}
