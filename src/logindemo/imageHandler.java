/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindemo;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Raymond
 */
public class imageHandler {
    public ImageIcon resizePic(String picPath, byte[] blobPic, int width, int height){
        
        ImageIcon myImg;
        if(picPath != null){
            myImg = new ImageIcon(picPath);
        }else{
            myImg = new ImageIcon(blobPic);
        }
                
        Image img  = myImg.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(img);
        return myPicture;
    }
    
    public String browseImage(JLabel lbl){
        String path = "";
        JFileChooser filec = new JFileChooser();
        filec.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("*.Images", "jpg", "png", "gif");
        filec.addChoosableFileFilter(fileFilter);
        
        int fileState = filec.showSaveDialog(null);
        
        if(fileState == JFileChooser.APPROVE_OPTION){
            File selectedFile = filec.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            
            lbl.setIcon(resizePic(path, null, lbl.getWidth(), lbl.getHeight()));
        }
        //if the user cancels 
        else if(fileState == JFileChooser.CANCEL_OPTION){
            System.out.println("No Image Selected.");
        }
        return path;
    }
}
