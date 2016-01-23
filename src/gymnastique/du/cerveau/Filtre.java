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
import java.io.File;

import javax.swing.filechooser.FileFilter;

public class Filtre extends FileFilter{
    private String description;
   private String extension;
     public Filtre(String description, String extension){
      if(description == null || extension ==null){
         throw new NullPointerException("La description (ou extension) ne peut etre null.");
      }
      this.description = description;
      this.extension = extension;
   }
   
    public boolean accept(File file){
	   
      if(file.isDirectory()) { 
         return true; 
      } 
      String nomFichier = file.getName().toLowerCase(); 

      return nomFichier.endsWith(extension);
   }
      public String getDescription(){
      return description;
   }
} 

