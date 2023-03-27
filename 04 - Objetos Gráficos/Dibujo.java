
/**
 * Write a description of class Dibujo here.
 * 
 * @author Roberto Salazar Marquez
 * @version 1.0
 */
import java.awt.*;
import java.awt.geom.*;

public class Dibujo extends Frame
{
    // Variables de Instancia 


    /**
     * Constructor para objetos de la clase Dibujo
     */
    public Dibujo()
    {
        super("Gráficos en Java");
        setResizable(false);    
    }
    
    public boolean handleEvent(Event e) {
        if(e.id == Event.WINDOW_DESTROY) {
            hide(); 
            dispose();
            return true;
        }
        return super.handleEvent(e);
    }
    
    public void paint(Graphics gc) {
        //gc.translate(100, 100);
        Graphics2D g2d = (Graphics2D) gc;
        gc.setColor(Color.magenta);
        g2d.setStroke(new BasicStroke(10.0f));

        g2d.draw( new Line2D.Float(50,90,115,200));
        g2d.setColor(Color.GRAY);
        
        g2d.fill( new Rectangle2D.Float(150,125,100,100) );
        g2d.setColor(Color.RED);
        g2d.fill( new Rectangle2D.Float(155,130,100,100) );
        
        g2d.setColor(Color.PINK);
        g2d.fill( new Ellipse2D.Float(200,200,100,100));
        
        /*Color color = new Color(0xbd,0x61,0x3c);
        gc.setColor(Color.magenta);
        Font font = new Font("Arial", Font.BOLD, 18);
        gc.setFont(font);
        gc.drawString("Saludos Programas!!!!!!",50, 50);
        gc.setColor(Color.yellow);
        gc.drawLine(50, 90, 115, 200);
        gc.fillRoundRect(150,125, 100,100, 90,90);
        gc.setColor(color);
        gc.fillOval(200,200,100,100);
        gc.setColor(Color.pink);
        gc.fillArc(200,200, 100,50, 0, 230);
        
        int xpoints[] = { 255,39,50,310,147};
        int ypoints[] = { 135,259,347,195,258 };
        gc.setColor(Color.gray);
        Polygon poly = new Polygon(xpoints, ypoints, 4);
        gc.fillPolygon(poly); */
        
        
    }
    
    public static void main(String args[]) {
        Dibujo dibujo = new Dibujo();
        dibujo.resize(350, 350);                // vieja manera
        dibujo.show();
    }
    
}
