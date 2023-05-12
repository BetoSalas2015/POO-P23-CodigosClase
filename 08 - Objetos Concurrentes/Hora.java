
/**
 * Write a description of class Hora here.
 * 
 * @author Roberto Salazar M rquez 
 * @version 2.0
 */
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Hora extends Frame implements Runnable {

  private int Segundos;
  private TextField texto;
  private Thread hilo;

  public Hora(String nombre)
  {
        super(nombre);
        setHoras(0);
        setMinutos(0);
        setSegundos(0);

        addWindowListener(new CW());
        setSize(160, 90);
        setVisible(true);

        texto = new TextField(8);
        setLayout(new FlowLayout());
        add(texto);
        hilo = new Thread(this);
        hilo.start();
  }
    
  public Hora(int h, String nombre)
  {
        super(nombre);
      setHoras(h);
      setMinutos(0);
      setSegundos(0);
      addWindowListener(new CW());
      setSize(160, 90);
      setVisible(true);
      setLayout(new FlowLayout());
      add(texto);
        hilo = new Thread(this);
        hilo.start();
  }
  
  public Hora(int h, int m, String nombre)
  {
    super(nombre);
      setHoras(h);
      setMinutos(m);
      setSegundos(0);
      addWindowListener(new CW());
      setSize(160, 90);
      setVisible(true);
      texto = new TextField(8);
      setLayout(new FlowLayout());
      add(texto);
        hilo = new Thread(this);
        hilo.start();
  }
  
  public Hora(int h, int m, int s, String nombre)
  {
    super(nombre);
      setHoras(h);
      setMinutos(m);
      setSegundos(s);
      addWindowListener(new CW());
      setSize(160, 90);
      setVisible(true);
      texto = new TextField(8);
      setLayout(new FlowLayout());
      add(texto);
        hilo = new Thread(this);
        hilo.start();
  }

  private class CW extends WindowAdapter {
     public void windowClosing(WindowEvent w) {
        setVisible(false);
        dispose();
     }
  }
    
  public void setHoras(int h)
  {
      int seg;
      if(h >= 0 && h < 24) {
          seg = Segundos / 3600;
          Segundos -= seg * 3600;
          Segundos += h * 3600;
        }
      
  }

  public void run() {
    while (true) {
        tick();
        try {
            hilo.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        texto.setText(toString());
    }
  }
  
  public int getHoras() 
  {
      return Segundos / 3600;
  }

  public void setMinutos(int m) 
  {
      int min;
      if(m >= 0 && m < 60) {
          min = ((Segundos % 3600) / 60);
          Segundos -= min * 60;
          Segundos += m * 60;
    }
    else {
          min = ((Segundos % 3600) / 60);
          Segundos -= min * 60;
    }
  }

  public int getMinutos() 
  {
      return ((Segundos % 3600) / 60);
  }

  public void setSegundos(int s) 
  {
      int seg;
      if(s >= 0 && s < 60) {
          seg = ((Segundos % 3600) % 60);
          Segundos -= seg;
          Segundos += s;
    }
    else {
          seg = ((Segundos % 3600) % 60);
          Segundos -= seg;
    }
  }

  public int getSegundos() 
  {
      int i =((Segundos % 3600) % 60);
      return i;
  }

  public String toString() 
  {
      return ((getHoras() == 0 || getHoras()  == 12) ? 12 : getHoras()%12) + ":" 
              + (getMinutos() < 10 ? "0" : "") + getMinutos() + ":" 
              + (getSegundos() < 10 ? "0" : "") + getSegundos() 
              + (getHoras() < 12 ? " AM" : " PM");
  }
  
  public String toMilitaryString() 
  {
      int h = getHoras();
      int m = getMinutos();
      String y;
      if(m < 10) {
         y = new String("0" + getMinutos());
      }
      else {
          y = new String("" + getMinutos());
        }
      String  x = new String( (h < 12 ? "0" : "") + getHoras() + y);
      return x;
  }

  public void tick() 
  {
      Segundos++;
      if(Segundos >= 86400) Segundos = 0; 
  }

  public static void main(String[] args) {
        Hora t = new Hora(13, 33, 00, "México");
        Hora t2 = new Hora(19, 33, 00, "Londres");
        Hora tokio = new Hora("Tokio");
  }
}