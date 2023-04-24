import java.awt.*;
import java.awt.event.*;            //  Modelo de eventos 1.1
import javax.swing.*;

public class Calculadora extends JFrame {
    // Interfaz
    private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private JButton btnMas, btnMenos, btnMult, btnDiv, btnPunto, btnIgual, btnC;
    private JTextField txtDisplay;
    private JPanel pnlTeclado, pnlDisplay;
    // Funcionalidad
    private double numero1, numero2, resultado;
    private char operador;
    private boolean operando, punto;  
    private String displaynum, sign; 

    public Calculadora() {
        super("Calculadora");

        // Creando Objetos gráficos

        btn0 = new JButton("0");         btn1 = new JButton("1"); 
        btn2 = new JButton("2");         btn3 = new JButton("3"); 
        btn4 = new JButton("4");         btn5 = new JButton("5"); 
        btn6 = new JButton("6");         btn7 = new JButton("7"); 
        btn8 = new JButton("8");         btn9 = new JButton("9"); 
        btnMas = new JButton("+");       btnMenos = new JButton("-"); 
        btnMult = new JButton("*");      btnDiv = new JButton("/"); 
        btnPunto = new JButton(".");     btnIgual = new JButton("="); 
        btnC = new JButton("C");         

        txtDisplay = new JTextField("0");
        pnlDisplay = new JPanel();
        pnlTeclado = new JPanel();

        // Configurando el display de la calculadora
        pnlDisplay.setLayout(new BorderLayout());
        pnlDisplay.add(btnC, "East");
        pnlDisplay.add(txtDisplay, "Center");

        // Configurando el JPanel del teclado
        pnlTeclado.setLayout(new GridLayout(4, 4, 5, 5));
        pnlTeclado.add(btn7);
        pnlTeclado.add(btn8);
        pnlTeclado.add(btn9);
        
        pnlTeclado.add(btnDiv);
        pnlTeclado.add(btn4);
        pnlTeclado.add(btn5);
        pnlTeclado.add(btn6);
        pnlTeclado.add(btnMult);
        pnlTeclado.add(btn1);
        pnlTeclado.add(btn2);
        pnlTeclado.add(btn3);
        pnlTeclado.add(btnMenos);
        pnlTeclado.add(btnIgual);
        pnlTeclado.add(btn0);
        pnlTeclado.add(btnPunto);
        pnlTeclado.add(btnMas);


        // Agregando JPaneles a la interfaz
        add(pnlDisplay, "North");
        add(pnlTeclado, "Center");

        operando = punto = true;

        btn0.addActionListener(new BotonNumerico());
        btn1.addActionListener(new BotonNumerico());
        btn2.addActionListener(new BotonNumerico());
        btn3.addActionListener(new BotonNumerico());
        btn4.addActionListener(new BotonNumerico());
        btn5.addActionListener(new BotonNumerico());
        btn6.addActionListener(new BotonNumerico());
        btn7.addActionListener(new BotonNumerico());
        btn8.addActionListener(new BotonNumerico());
        btn9.addActionListener(new BotonNumerico());
        btnMas.addActionListener(new BotonOpera());
        btnMenos.addActionListener(new BotonOpera());
        btnMult.addActionListener(new BotonOpera());
        btnDiv.addActionListener(new BotonOpera());
        btnIgual.addActionListener(new BotonIgual());
        btnPunto.addActionListener(new BotonPunto());
        btnC.addActionListener(new BotonC());

        addWindowListener( new CloseWindow() );
        setSize(350, 350);
        setVisible(true);
    }

    private class CloseWindow extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            setVisible(false);
            dispose();
        }
        public void windowClosed(WindowEvent e ) {}
    }

    private class BotonNumerico implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            displaynum =  new String( txtDisplay.getText() );
            if(displaynum.equals("0")) {
                displaynum = "";
            }
            displaynum += e.getActionCommand();
            txtDisplay.setText(displaynum);
        }
    }
    private class BotonIgual implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                opera();
            } catch (DivideByZeroException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }

        private void opera() throws DivideByZeroException, NumberFormatException {
            numero2 = Double.parseDouble(txtDisplay.getText());
            switch (operador) {
                case '+': resultado = numero1 + numero2; break;
                case '-': resultado = numero1 - numero2; break;
                case '*': resultado = numero1 * numero2; break;
                case '/': if (numero2 == 0) {
                                throw new DivideByZeroException();
                          } 
                          resultado = numero1 / numero2; break;
            }
            txtDisplay.setText(String.valueOf(resultado));
            operando =  punto = true;
        }
    }
    private class BotonPunto implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (punto) {
                displaynum = new String( txtDisplay.getText());
                displaynum = displaynum + ".";
                txtDisplay.setText(displaynum);
                punto = false;
            }  
        }
    }
    private class BotonOpera implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ( operando ) {
                sign = new String( e.getActionCommand() );
                operador = sign.charAt(0);
                numero1 = Double.parseDouble(txtDisplay.getText());
                txtDisplay.setText("0");
                operando = false;
                punto = true;
            }
        }
    }
    private class BotonC implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operando = punto = true;
            numero1 = numero2 = 0.0;
            txtDisplay.setText("0");
        }
    }
    


    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

    }

    
}