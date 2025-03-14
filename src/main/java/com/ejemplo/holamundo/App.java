package com.ejemplo.holamundo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana Hola Mundo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JOptionPane.showMessageDialog(frame, "Hola Mundo", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        
        frame.pack();
        frame.setVisible(true);
    }
}
