/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game2048.view;

/**
 *
 * @author hp
 */
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
 
import javax.swing.JButton;
import javax.swing.JPanel;
 
import game2048.Controller.StartGameActionListener;
import game2048.Model.Game2048Model;
 
public class ControlPanel {
     
    private static final Insets regularInsets   = 
            new Insets(10, 10, 0, 10);
     
    private Game2048Frame frame;
     
    private Game2048Model model;
     
    private JPanel panel;
 
    public ControlPanel(Game2048Frame frame, Game2048Model model) {
        this.frame = frame;
        this.model = model;
        createPartControl();
    }
     
    private void createPartControl() {
        StartGameActionListener listener = 
                new StartGameActionListener(frame, model);
         
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
 
        int gridy = 0;
         
        JButton startGameButton = new JButton("Start Game");
        startGameButton.addActionListener(listener);
        addComponent(panel, startGameButton, 0, gridy++, 1, 1, 
                regularInsets, GridBagConstraints.LINE_START, 
                GridBagConstraints.HORIZONTAL);
    }
 
    private void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight, 
            Insets insets, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0D, 1.0D, anchor, fill, 
                insets, 0, 0);
        container.add(component, gbc);
    }
     
    public JPanel getPanel() {
        return panel;
    }
}
