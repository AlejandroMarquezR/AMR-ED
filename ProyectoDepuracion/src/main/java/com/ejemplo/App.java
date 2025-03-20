package com.ejemplo;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class App 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Ventana");
        JLabel label = new JLabel("Hola Mundo", JLabel.CENTER);
        
        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
