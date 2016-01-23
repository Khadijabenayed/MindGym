/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymnastique.du.cerveau;

/**
 *
 * @author asus 2014
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;


public class DessinerJeu extends JPanel {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
      private Image img;
      private int nbrcarré,taillecarré;
      private CarréImage carreauximage[][];
	public DessinerJeu(Image img,int nbrcarré,int taillecarré,CarréImage carreauximage[][]){
    	   this.img=img;
    	   this.nbrcarré=nbrcarré;
    	   this.taillecarré=taillecarré;
    	   this.carreauximage=carreauximage;
       }
	public void paintComponent(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		if(img!=null){
		CarréImage C = null;int i1=0,j1 = 0;
		for(int i=1;i<=nbrcarré;i++)
			for(int j=1;j<=nbrcarré;j++){
				C=carreauximage[i-1][j-1];
				j1=C.getNouvEmplacement()/nbrcarré+1;
				i1=C.getNouvEmplacement()%nbrcarré+1;
				g.drawImage(img,taillecarré*i1,taillecarré*j1,taillecarré*i1+taillecarré,taillecarré*j1+taillecarré,C.getXImage(),C.getYImage(),C.getX1Image(),C.getY1Image(),null);
				g.setColor(Color.black);
				g.drawRect(taillecarré*i1, taillecarré*j1, taillecarré, taillecarré);
				g.setColor(Color.white);
				g.drawLine(taillecarré*i1+1, taillecarré*j1+1, taillecarré+(i1*taillecarré), taillecarré*j1+1);
	            g.drawLine(taillecarré*i1+1, taillecarré*j1+1, taillecarré*i1+1, taillecarré+(j1*taillecarré));
          }
		//le carré blanc
		g.setColor(Color.white);
		g.fillRect(taillecarré*i1+2,taillecarré*j1+2,taillecarré-1,taillecarré-1);
		g.setColor(Color.black);
		g.drawRect(taillecarré*i1+1, taillecarré*j1+1, taillecarré-1, taillecarré-1);
		g.setColor(Color.gray);
		g.drawRect(taillecarré*i1+2, taillecarré*j1+2, taillecarré-2, taillecarré-2);
		//dissiner le border de l'image	
        g.setColor(Color.white);
		g.drawLine(taillecarré, taillecarré, (nbrcarré+1)*taillecarré, taillecarré);
	    g.drawLine(taillecarré, taillecarré, taillecarré, (nbrcarré+1)*taillecarré);
	}
	
	}
	
}

