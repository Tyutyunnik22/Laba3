package laba4;

import java.awt.event.*;

import javax.swing.JComboBox;
import javax.swing.JLabel;

//Класс изменения расположения картинки
public class ListenerCombo implements ActionListener {
	JComboBox<String> comboBox; 
	JLabel laba_info;
		
	public void setControls(JComboBox<String> combo, JLabel label) {
		comboBox = combo;
		laba_info = label;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String s = (String) comboBox.getSelectedItem();

        switch (s) {
            case "Переместить логотип УГАТУ в верхний правый угол":
            	laba_info.setBounds(183,-25,400,250);
                //System.out.println("правый верхний угол");
                break;
            case "Переместить логотип УГАТУ в середину":
            	laba_info.setBounds(95,-25,400,250);
                //System.out.println("в середину");
                break;
            case "Переместить логотип УГАТУ в левый верхний угол":
            	laba_info.setBounds(0,-25,400,250);
                //System.out.println("левый верхний угол");
                break;
            case "Отсортировать данные в проекте22":
            	ArraySort sort = new ArraySort();
            	sort.sortView();
            	break;   
            default:
                break;
        }
	}
}
