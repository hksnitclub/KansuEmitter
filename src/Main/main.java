package Main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.*;

import java.awt.Container;
 
 public class main{
   public static void main(String args[]){
     JFrame frame=new JFrame("KansuEmitter");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(400,400);
     JPanel p = new JPanel();
     JTextField text = new JTextField();
     text.setPreferredSize(new Dimension(200, 25));
     text.setVisible(true);	
     p.add(text);
    
     java.awt.Container contentpane = frame.getContentPane();
     contentpane.add(p, BorderLayout.CENTER);
     
     frame.setVisible(true);
    }
/*  public void JTextField() {
     JPanel panelBase = new JPanel();
     JTextField text = new JTextField("パスを入力して下さい");
     text.setMargin(new Insets(5, 10, 5, 10));
     text.setSize(50,10);
     text.setVisible(true);
     String str = text.getText();
   } */
}
