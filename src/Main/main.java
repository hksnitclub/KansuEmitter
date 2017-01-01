package Main;

import java.awt.Insets;

import javax.swing.*;
 
 public class main{
   public static void main(String args[]){
     JFrame frame=new JFrame("KansuEmitter");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(400,400);
     frame.setVisible(true);
    }
  public void JTextField() {
     JPanel panelBase = new JPanel();
     JTextField text = new JTextField("パスを入力して下さい");
     text.setMargin(new Insets(5, 10, 5, 10));
     text.setSize(50,10);
     text.setVisible(true);
     String str = text.getText();
   }
}