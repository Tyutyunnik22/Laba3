package laba3;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ArraySort {
private int[] masNoSort = MakeArray.getArray();
	
	public int[] getSort() {
		 int[] masSorted = new int[15];
		 System.arraycopy(masNoSort, 0, masSorted, 0, 15);
   	     int t;
		 for (int i = 0; i < masSorted.length-1; i++){  
	         for (int j = i+1; j < masSorted.length; j++){       
	             if(masSorted[i] > masSorted[j]) {
	            	 t = masSorted[i];   
	            	 masSorted[i] = masSorted[j];       
	            	 masSorted[j] = t;  
	             }        	       
	         }
		 }
		 return masSorted;
	}
	public void sortView() {;
		 	int[] mas = getSort(); String text = ""; int i = 1;
		 	text = String.format("%-30s %-15s%n", "Исходный", "Отсортированный");
			for(int m = 0;m<mas.length;m++){
				String str1 = String.format("[%02d] = %04d",i,masNoSort[m]);
				String str2 = String.format("[%02d] = %04d",i,mas[m]);
				String str = String.format("%-33s %-12s%n", str1,str2);
				text =  text + str;
				i++;
			}
		 
   		JFrame sortFrame = new JFrame();
        String title = "Исходный и отсортированный массивы";
        UIManager.put("OptionPane.background",Color.white);
        UIManager.put("Panel.background",Color.white);
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 18));
        UIManager.put("OptionPane.minimumSize",new java.awt.Dimension(500,460));
        JOptionPane.showMessageDialog(sortFrame,text,title,JOptionPane.INFORMATION_MESSAGE);
	}
}

