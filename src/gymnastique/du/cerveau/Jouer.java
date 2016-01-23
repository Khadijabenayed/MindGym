/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymnastique.du.cerveau;
 import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.filechooser.FileFilter;
/**
 *
 * @author asus 2014
 */
public class Jouer extends JFrame{
   


      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
      private CarréImage carreauximage[][];
      private Image img=null;
      private boolean démarrer=false;
      private int nbrcarreaux=4,taillecarré=50;
      private DessinerJeu dpanneau;
      private JMenuBar menuprincipal=new JMenuBar();
      private JMenu fichier=new JMenu("Fichier"),
      aide=new JMenu("Aide"),
      tcarré=new JMenu("Taille des careaux")
      ,ncarreaux=new JMenu("Nombre des careaux");
      private JMenuItem importer=new JMenuItem("Importer une image"),
      lancer=new JMenuItem("Lancer le jeu"),
      quitter=new JMenuItem("Quitter"),
      apropos=new JMenuItem("À propos?");
      private JOptionPane information=new JOptionPane();
      private JRadioButtonMenuItem n4=new JRadioButtonMenuItem("4*4"),
      n6=new JRadioButtonMenuItem("6*6"),
      N8=new JRadioButtonMenuItem("8*8"),
      t50=new JRadioButtonMenuItem("Taille 50"),
      t75=new JRadioButtonMenuItem("Taille 75"),
      t100=new JRadioButtonMenuItem("Taille 100");
       public Jouer(){
    	  this.setTitle("Taquin");
    	  this.setLocation(100,100);
    	  this.setSize((nbrcarreaux+2)*taillecarré+4,(nbrcarreaux+2)*taillecarré+50);
    	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  this.setVisible(true);
    	  this.setResizable(false);
    	  Menu();
    	  dpanneau=new DessinerJeu(null,nbrcarreaux,taillecarré,carreauximage);
    	  this.setContentPane(dpanneau);
    	  Ordonerjeu();
			this.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent arg0) {
					// TODO Auto-generated method stub
					if(démarrer){
					int XSouri=arg0.getX()
					,YSouri=arg0.getY(),XCarré,YCarré,Temp,XCarréBlanc,YCarréBlanc;
					if(XSouri>=taillecarré+4 && XSouri<=(taillecarré*nbrcarreaux+taillecarré+4)){
						if(YSouri>=taillecarré+51 && YSouri<=(taillecarré*nbrcarreaux+taillecarré+51))
					    {XCarré=(XSouri-taillecarré-4)/taillecarré;
					    YCarré=(YSouri-taillecarré-50)/taillecarré;
					    Temp=carreauximage[nbrcarreaux-1][nbrcarreaux-1].getNouvEmplacement();
					    XCarréBlanc=Temp%nbrcarreaux;
					    YCarréBlanc=Temp/nbrcarreaux;
					    if(XCarréBlanc==XCarré||YCarréBlanc==YCarré)
					    	{if(!(XCarréBlanc==XCarré&&YCarréBlanc==YCarré))
					    	ChangerCursor('H');else ChangerCursor('D');}
					    else ChangerCursor('D');
					    }
						else ChangerCursor('D');}
					else ChangerCursor('D');
					
				}}
				@Override
				public void mouseDragged(MouseEvent arg0) {
					// TODO Auto-generated method stub
		
				}
			});
     }
      public  void initFenPanel(){
    	  ChangerCursor('D');
    	  this.setContentPane(dpanneau);
		 this.setSize((nbrcarreaux+2)*taillecarré+4,(nbrcarreaux+2)*taillecarré+50);
		
      }
		 public void DiviserImage(){
    	   DiviserImage DImage=new DiviserImage(img,nbrcarreaux);
    	   carreauximage=DImage.Diviser();
    	   dpanneau=new DessinerJeu(img,nbrcarreaux,taillecarré,carreauximage);
    	   
			}
	public void LancerJeu(){
		if(img!=null){démarrer=true;
		ArrayList <CarréImage> ListCarreaux=new ArrayList<CarréImage>();
		for(CarréImage[] C1:carreauximage)
			for(CarréImage C:C1){
				ListCarreaux.add(C);
			}
		Random Rand=new Random();;int Choix;
		
		for(int i=nbrcarreaux*nbrcarreaux;i>0;i--){
			Choix=Rand.nextInt(i);
			ListCarreaux.get(Choix).setNouvEmplacement(i-1);
			ListCarreaux.remove(Choix);
		}
	    ListCarreaux.clear();
	    dpanneau.repaint();}
		else JOptionPane.showMessageDialog(null,"Importez une image","Erreur",JOptionPane.ERROR_MESSAGE);
		}
	public void ChangerCursor(char Style){
		switch(Style){
		case 'H':this.setCursor(new Cursor(Cursor.HAND_CURSOR));break;
		case 'D':this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));break;
		}
		
	}
	public void Ordonerjeu(){
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@SuppressWarnings("static-access")
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(démarrer){
				int XSouri=arg0.getX()
				,YSouri=arg0.getY(),XCarré,YCarré,Temp,XCarréBlanc,YCarréBlanc;
				if(XSouri>=taillecarré+4 && XSouri<=(taillecarré*nbrcarreaux+taillecarré+4))
					if(YSouri>=taillecarré+50 && YSouri<=(taillecarré*nbrcarreaux+taillecarré+50))
				    {XCarré=(XSouri-taillecarré-4)/taillecarré;
				    YCarré=(YSouri-taillecarré-50)/taillecarré;
				    Temp=carreauximage[nbrcarreaux-1][nbrcarreaux-1].getNouvEmplacement();
				    XCarréBlanc=Temp%nbrcarreaux;
				    YCarréBlanc=Temp/nbrcarreaux;
				    if(XCarréBlanc==XCarré||YCarréBlanc==YCarré)
				    {int i,j,i1=0,j1=0;
				    	if(XCarréBlanc<XCarré){
				    		while(!(XCarré==XCarréBlanc)){
				    	for(i=0;i<nbrcarreaux;i++)
							for(j=0;j<nbrcarreaux;j++)
								if(carreauximage[i][j].getNouvEmplacement()==YCarréBlanc*nbrcarreaux+XCarréBlanc+1){i1=i;j1=j;}
				    	carreauximage[nbrcarreaux-1][nbrcarreaux-1].setNouvEmplacement(carreauximage[i1][j1].getNouvEmplacement());
				    	carreauximage[i1][j1].setNouvEmplacement(Temp);
					    XCarréBlanc++;Temp++;
				    }
				    }
				    	if(XCarréBlanc>XCarré){
				    		while(!(XCarré==XCarréBlanc)){
				    	for(i=0;i<nbrcarreaux;i++)
							for(j=0;j<nbrcarreaux;j++)
								if(carreauximage[i][j].getNouvEmplacement()==YCarréBlanc*nbrcarreaux+XCarréBlanc-1){i1=i;j1=j;}
				    	carreauximage[nbrcarreaux-1][nbrcarreaux-1].setNouvEmplacement(carreauximage[i1][j1].getNouvEmplacement());
					   carreauximage[i1][j1].setNouvEmplacement(Temp);
					    XCarréBlanc--;Temp--;
				    }
				    }
				    	if(YCarréBlanc<YCarré){
				    		while(!(YCarré==YCarréBlanc)){
				    	for(i=0;i<nbrcarreaux;i++)
							for(j=0;j<nbrcarreaux;j++)
								if(carreauximage[i][j].getNouvEmplacement()==YCarréBlanc*nbrcarreaux+XCarréBlanc+nbrcarreaux){i1=i;j1=j;}
				    	carreauximage[nbrcarreaux-1][nbrcarreaux-1].setNouvEmplacement(carreauximage[i1][j1].getNouvEmplacement());
				    	carreauximage[i1][j1].setNouvEmplacement(Temp);
					    YCarréBlanc++;Temp+=nbrcarreaux;
				    }
				    }
				    	if(YCarréBlanc>YCarré){
				    		while(!(YCarré==YCarréBlanc)){
				    	for(i=0;i<nbrcarreaux;i++)
							for(j=0;j<nbrcarreaux;j++)
								if(carreauximage[i][j].getNouvEmplacement()==YCarréBlanc*nbrcarreaux+XCarréBlanc-nbrcarreaux){i1=i;j1=j;}
				    	carreauximage[nbrcarreaux-1][nbrcarreaux-1].setNouvEmplacement(carreauximage[i1][j1].getNouvEmplacement());
					   carreauximage[i1][j1].setNouvEmplacement(Temp);
					    YCarréBlanc--;Temp-=nbrcarreaux;
				    }
				    }
				    	boolean gagner=true;
				    	for(i=0;i<nbrcarreaux;i++)
							for(j=0;j<nbrcarreaux;j++)
								if(!carreauximage[i][j].isSonEmplacement())gagner=false;
				    	if(gagner)information.showMessageDialog(null,"                Félicitation vous avaz gagné","Félicitation",JOptionPane.DEFAULT_OPTION);
				    	
				    }
				
				    dpanneau.repaint();
				    }
			}
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	public void Menu(){
		this.setJMenuBar(menuprincipal);
		menuprincipal.add(fichier);
		menuprincipal.add(aide);
		fichier.add(importer);
		fichier.add( lancer);
		fichier.add(ncarreaux);
		fichier.add(tcarré);
		fichier.addSeparator();
		fichier.add(quitter);
		aide.add(apropos);
		ncarreaux.add(n4);
		ncarreaux.add(n6);
		ncarreaux.add(N8);
		tcarré.add(t50);
		tcarré.add(t75);
		tcarré.add(t100);
		ButtonGroup BG=new ButtonGroup();
		ButtonGroup BG1=new ButtonGroup();
        BG.add(n4);
        BG.add(n6);
        BG.add(N8);
        BG1.add(t50);
        BG1.add(t75);
        BG1.add(t100);
        n4.setSelected(true);t50.setSelected(true);
        n4.addActionListener(new NembreCarreaux());
        n6.addActionListener(new NembreCarreaux());
        N8.addActionListener(new NembreCarreaux());
        t50.addActionListener(new TailleCareaux());
        t75.addActionListener(new TailleCareaux());
        t100.addActionListener(new TailleCareaux());
        quitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			System.exit(0);	
			}
		});
        importer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			JFileChooser ImporterImg=new JFileChooser();
			ImporterImg.setDialogTitle("Choisi une image");
			FileFilter bmp = new Filtre("Images BMP",".bmp");
            FileFilter gif =  new Filtre("Image GIF",".gif");
            FileFilter png =  new Filtre("Image PNG",".png");
            FileFilter jpeg =  new Filtre("Images JPEG",".jpg");
            ImporterImg.addChoosableFileFilter( bmp);
			ImporterImg.addChoosableFileFilter(gif);
			ImporterImg.addChoosableFileFilter(png);
            ImporterImg.addChoosableFileFilter(jpeg);
            ImporterImg.setMultiSelectionEnabled(false);
            ImporterImg.showOpenDialog(null);
            try {
            	if(ImporterImg.getSelectedFile()!=null)
				{img= ImageIO.read(ImporterImg.getSelectedFile());
            	DiviserImage();initFenPanel();démarrer=false;}
            } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            dpanneau.repaint();	
			}  
		});
        lancer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				LancerJeu();
			}
		}); 
        apropos.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				information.showMessageDialog(null,"Réaliser par:\n              ANJDEV","À propos?",JOptionPane.INFORMATION_MESSAGE);
			}
		});      
	}
	
	class NembreCarreaux implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource()==n4){nbrcarreaux=4;DiviserImage();initFenPanel();démarrer=false;}
			if(arg0.getSource()==n6){nbrcarreaux=6;DiviserImage();initFenPanel();démarrer=false;}
			if(arg0.getSource()==N8){nbrcarreaux=8;DiviserImage();initFenPanel();démarrer=false;}
		}
		
	}
	class TailleCareaux implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource()==t50){taillecarré=50;dpanneau=new DessinerJeu(img,nbrcarreaux,taillecarré,carreauximage);initFenPanel();}
			if(arg0.getSource()==t75){taillecarré=75;dpanneau=new DessinerJeu(img,nbrcarreaux,taillecarré,carreauximage);initFenPanel();}
			if(arg0.getSource()==t100){taillecarré=100;dpanneau=new DessinerJeu(img,nbrcarreaux,taillecarré,carreauximage);initFenPanel();}
		}
		
	}
	public static void main(String[] args) {
		new Jouer();
	}
}


    

