
/**
 * Write a description of class Hora here.
 * 
 * @author Roberto Salazar M rquez 
 * @version 1.0
 */
public class Hora {

  private int Segundos;

  public Hora()
  {
      setHoras(0);
      setMinutos(0);
      setSegundos(0);
  }
    
  public Hora(int h)
  {
      setHoras(h);
      setMinutos(0);
      setSegundos(0);
  }
  
  public Hora(int h, int m)
  {
      setHoras(h);
      setMinutos(m);
      setSegundos(0);
  }
  
  public Hora(int h, int m, int s)
  {
      setHoras(h);
      setMinutos(m);
      setSegundos(s);
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

}