package laba3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.Component; 

import javax.swing.*;

public class InfoForm {
	private JFrame windowInfo;
	private JButton closeWindow = new JButton("Закрыть");
	public static ArrayList<String> authors = new ArrayList<String>();
	public static ArrayList<String> list = new ArrayList<String>();
	
	public InfoForm() {
		windowInfo = new JFrame("Information");
		windowInfo.getContentPane().setBackground( new Color(255, 255, 255));
		
		//Размещение информационной формы по центру
		java.awt.Dimension f = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x1 = (f.width-600)/2;
        int y1 = (f.height-350)/2;
		windowInfo.setBounds(x1,y1,600,350);
		
		windowInfo.setResizable(false); //Фиксированный размер окна
	}
	public void showFormForFile() {
		windowInfo.setLayout(null);
		Container container = windowInfo.getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS)); 
		ArrayList<String> allList = new ArrayList<String>();
		allList.addAll(authors);
		allList.addAll(list);
		JList<String> jList = new JList<String>(allList.toArray(new String[allList.size()]));
		jList.setFont(new Font("Arial", Font.BOLD, 20));
		jList.setBounds(5,5,250,500);
		buttonExit();
		closeWindow.setFont(new Font("Arial", Font.BOLD, 28));
		closeWindow.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(new JScrollPane(jList));
		container.add(closeWindow);
		windowInfo.setVisible(true);
	}
	private void buttonExit() {
		closeWindow.setBounds(215,250,175,40);
		closeWindow.setFont(new Font("Arial", Font.BOLD, 20));
		
		closeWindow.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	windowInfo.setVisible(false); //Сделать форму невидимой
            	windowInfo.dispose();	//Очистить объект JFrame
            }
        });
	}
}