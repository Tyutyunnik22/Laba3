package laba3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

//Класс загрузки файла
public class ListenerLoadFile implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String folder = "";
		try {
			folder = new File(ListenerLoadFile.class.getProtectionDomain().getCodeSource().getLocation()
				    .toURI()).getParent();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		String fileName = folder + File.separator + "file.txt";
		ArrayList<String> list = new ArrayList<String>();
		UIManager.put("OptionPane.minimumSize",new java.awt.Dimension(400,50));
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 18));
		UIManager.put("OptionPane.background",Color.white);
        UIManager.put("Panel.background",Color.white);
        
		try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
			String textLine = null;
		    while ((textLine = br.readLine()) != null) {
		    	if(!textLine.isEmpty()){
		    		list.add(textLine);
		    	}
		    }
		    InfoForm.list = list;
		    String msg = 
		    String.format("<html><font color='green'>Файл %s загружен успешно</font></html>", 
		    		fileName);
		    JOptionPane.showMessageDialog(null,msg,"Загрузка файла",
		    		JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException ex) {
			String msg = String.format("Файл %s не найден", fileName);
		    JOptionPane.showMessageDialog(null,msg,"Загрузка файла",
		    		JOptionPane.ERROR_MESSAGE);
		}	
			
	}
}