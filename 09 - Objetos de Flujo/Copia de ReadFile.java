/**
 * ReadFile
 */
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;

public class ReadFile extends JFrame {
    private JTextArea editor;
    private FileInputStream entrada;
    private FileOutputStream salida;

    public ReadFile() {
        super("Editor de Textos");
        int car;
        editor = new JTextArea();
        setLayout(new BorderLayout());
        add(editor, "Center"); 
        //  LEctura de Archivo
        try {
            entrada = new FileInputStream("ReadFile.java");

            while(( car = entrada.read()) != -1 ) {
                editor.append(String.valueOf( (char) car));
            }
            entrada.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado.");
        } 

        // Escritura de Archivo
        
        try {
            salida = new FileOutputStream("Copia de ReadFile.java");
            byte[] contenido = editor.getText().getBytes();
            int i = 0;
            while (i < contenido.length) {
                salida.write( contenido[i]);
                i++;
            }
            salida.close();
        } catch (IOException e) {
            System.out.println("Archivo no se puede crear.");
            
        }


        addWindowListener(new CloseWin());
        setSize(400, 500);
        setVisible(true);
    }

    /**
     * InnerReadFile
     */
    public class CloseWin extends WindowAdapter {
        public void windowClosing(WindowEvent ev) {
            setVisible(false);
            dispose();
        }
        
    }
    
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
    }
}