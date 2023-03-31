import java.awt.*;
import java.awt.event.*;            //  Modelo de eventos 1.1

public class Calculadora extends Frame {
    // Interfaz
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnMas, btnMenos, btnMult, btnDiv, btnPunto, btnIgual, btnC;
    private TextField txtDisplay;
    private Panel pnlTeclado, pnlDisplay;
    // Funcionalidad
    private double numero1, numero2, resultado;
    private char operador;
    private boolean operando, punto;  
    private String displaynum, sign; 

    public Calculadora() {
        super("Calculadora");

        // Creando Objetos gráficos

        btn0 = new Button("0");         btn1 = new Button("1"); 
        btn2 = new Button("2");         btn3 = new Button("3"); 
        btn4 = new Button("4");         btn5 = new Button("5"); 
        btn6 = new Button("6");         btn7 = new Button("7"); 
        btn8 = new Button("8");         btn9 = new Button("9"); 
        btnMas = new Button("+");       btnMenos = new Button("-"); 
        btnMult = new Button("*");      btnDiv = new Button("/"); 
        btnPunto = new Button(".");     btnIgual = new Button("="); 
        btnC = new Button("C");         

        txtDisplay = new TextField("0");
        pnlDisplay = new Panel();
        pnlTeclado = new Panel();

        // Configurando el display de la calculadora
        pnlDisplay.setLayout(new BorderLayout());
        pnlDisplay.add(btnC, "East");
        pnlDisplay.add(txtDisplay, "Center");

        // Configurando el panel del teclado
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


        // Agregando Paneles a la interfaz
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
            numero2 = Double.parseDouble(txtDisplay.getText());
            switch (operador) {
                case '+': resultado = numero1 + numero2; break;
                case '-': resultado = numero1 - numero2; break;
                case '*': resultado = numero1 * numero2; break;
                case '/': resultado = numero1 / numero2; break;
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