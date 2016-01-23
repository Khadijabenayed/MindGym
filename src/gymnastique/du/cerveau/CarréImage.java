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
public class CarréImage {
     private int imageX,imageY,imageX1,imageY1,précemplacement,nouvemplacement;
	public CarréImage(int imageX,int imageY,int imageX1,int imageY1,int précemplacement){
		this.imageX=imageX;
		this.imageY=imageY;
		this.imageX1=imageX1;
		this.imageY1=imageY1;
		this.précemplacement=précemplacement;
		this.nouvemplacement=précemplacement;
	}
	public void setNouvEmplacement(int ordre){
		this.nouvemplacement=ordre;
	}
	public int getXImage(){
		return imageX;
	}
	public int getYImage(){
		return imageY;
	}
	public int getX1Image(){
		return imageX1;
	}
	public int getY1Image(){
		return imageY1;
	}
	public int getNouvEmplacement(){
		return nouvemplacement;
	}
	public boolean isSonEmplacement(){
		if(précemplacement==nouvemplacement)return true;
		else return false;
	}
    
}
