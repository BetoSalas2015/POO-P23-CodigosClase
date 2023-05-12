public class ProdCons {
    private Almacen alm;
    private Productor p;
    private Consumidor c;

    public ProdCons() {
        alm = new Almacen();
        p = new Productor(alm);
        c = new Consumidor(alm);

        p.start();
        c.start();
    }

    public static void main(String[] args) {
        ProdCons prodCons = new ProdCons();
    }
}
