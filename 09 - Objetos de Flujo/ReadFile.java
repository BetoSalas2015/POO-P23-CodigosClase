/**
 * ReadFile
 */
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;

public class ReadFile extends JFrame {
    private JTextArea editor;
    private DataOutputStream escribe;
    private DataInputStream lee;

    private String[] nombres = { "Juan", "Andrés", "Raul"};
    private String[] apellidos = { "Pérez", "Sánchez", "López"};
    private int[] edades = {20, 30, 40};


    public ReadFile() {
        super("Editor de Textos");
        String car;
        editor = new JTextArea();
        setLayout(new BorderLayout());
        add(editor, "Center"); 
        //  LEctura de Archivo
        try {
            lee = new DataInputStream(
                      new BufferedInputStream(
                      new FileInputStream("directorio.dat")));
            
            for (int i = 0; i < 3; i++) {
                String nombre = lee.readUTF();
                String apellido = lee.readUTF();
                int edad = lee.readInt();
                car = nombre + " " + apellido + ", Edad: " + edad + "\n";
                editor.append(car);
            }

            lee.close();
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