/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gymnastique.du.cerveau;

/**
 *
 * @author hp
 */
import javax.swing.SwingUtilities;
 
import game2048.Model.Game2048Model;
import game2048.view.Game2048Frame;
 
public class Game2048 implements Runnable {
 
    @Override
    public void run() {
        new Game2048Frame(new Game2048Model());
    }
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game2048());
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
