package gymnastique.du.cerveau;

import gymnastique.du.cerveau.MasterMindApplet;
import javax.swing.*;
import java.applet.*;


public class MasterMindFenetre1 extends JFrame
{
static
{
try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
catch(Exception e) {}
}
 MasterMindFenetre1()
 {
 super("MRG MASTERMIND");
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setResizable(false);
 setSize(420,550);
 setLocationRelativeTo(null);
 try
 {
 Applet MMA = new MasterMindApplet();
 MMA.init();
 getContentPane().add(MMA);

 }
 catch(Exception p)
 {
 JOptionPane.showMessageDialog(this,p.toString());
 }
 setVisible(true);
 }

 public static void main(String x[])
 {
 new MasterMindFenetre1();
 }

 } 