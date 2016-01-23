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
import java.awt.Image;


public class DiviserImage {
	private Image img;
	private int hcarréImg,wcarréImg,nbrcarreaux;
	public DiviserImage(Image img,int nbrcarreaux){
		this.img=img;
	     this.nbrcarreaux=nbrcarreaux;
	}
    public CarréImage[][] Diviser(){
    	CarréImage[][] CarréImg=new CarréImage[nbrcarreaux][nbrcarreaux];
    	if(img!=null){wcarréImg=img.getWidth(null)/nbrcarreaux;
        hcarréImg=img.getHeight(null)/nbrcarreaux;
    	for(int i=0;i<nbrcarreaux;i++)
    		for(int j=0;j<nbrcarreaux;j++){
    			if(i==nbrcarreaux-1)CarréImg[i][j]=new CarréImage(wcarréImg*i,hcarréImg*j,img.getWidth(null),hcarréImg*(j+1),j*nbrcarreaux+i);
    			else {
    				if(j==nbrcarreaux-1)CarréImg[i][j]=new CarréImage(wcarréImg*i,hcarréImg*j,wcarréImg*(i+1),img.getHeight(null),j*nbrcarreaux+i);
    			     else{  if(i==nbrcarreaux-1&&j==nbrcarreaux-1)CarréImg[i][j]=new CarréImage(wcarréImg*i,hcarréImg*j,img.getWidth(null),img.getHeight(null),j*nbrcarreaux+i);
    			     else CarréImg[i][j]=new CarréImage(wcarréImg*i,hcarréImg*j,wcarréImg*(i+1),hcarréImg*(j+1),j*nbrcarreaux+i);
    			}
    			}
    		}
    	}
    	return CarréImg;
    }

}