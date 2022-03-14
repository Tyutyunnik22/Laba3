package laba4;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

//Класс загрузки картинки
public class ListenerLoadImage implements ActionListener {
	private JLabel laba_info; //Label для загрузки изображения;
	
	//Установка Label для загрузки изображения
	public void setLabel(JLabel label) {
		laba_info = label;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String folder = "";
		try {
			folder = new File(ListenerLoadFile.class.getProtectionDomain().getCodeSource().getLocation()
				    .toURI()).getParent();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		String fileName = folder + File.separator + "logo.jpg";
		File f = new File(fileName);
    	if(f.exists() && !f.isDirectory()) { 
    		ImageIcon img = new ImageIcon(fileName);
        	laba_info.setIcon(img);
    	} else {
    		laba_info.setFont(new Font("Arial", Font.BOLD, 20));
    		laba_info.setForeground(Color.decode("#FF4500"));
    		laba_info.setHorizontalAlignment(SwingConstants.CENTER);
    		laba_info.setText("Картинка не найдена!");
    	}		
	}
}
