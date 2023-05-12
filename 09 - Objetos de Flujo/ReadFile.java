/**
 * ReadFile
 */
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;

public class ReadFile extends JFrame {
    private JTextArea editor;
    private BufferedReader entrada;

    public ReadFile() {
        super("Editor de Textos");
        String car;
        editor = new JTextArea();
        setLayout(new BorderLayout());
        add(editor, "Center"); 
        //  LEctura de Archivo
        try {
            entrada = new BufferedReader(new FileReader("ReadFile.java"));


            while(( car = entrada.readLine()) != null ) {
                editor.append(car + '\n');
            }
            entrada.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado.");
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