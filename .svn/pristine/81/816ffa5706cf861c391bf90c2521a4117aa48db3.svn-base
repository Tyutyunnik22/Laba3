package laba4;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Font;

//Класс проверки на введенное значение
public class Check {
	//Проверка на число, кот. больше нуля
    public static Double getNumber(String strNum, Double min, Double max,JTextField bigField) {
        if ((strNum == null) || strNum.isEmpty()) {
            showError("Строка не должна быть пустой, введите число");
            return null;
        }
        Double d = null;
        try {
            d = Double.parseDouble(strNum);
            if ((d<min) || (d>max)) {
                showError("Число " + strNum + " должно быть больше или равно " + min
                        + " и меньше или равно " + max);
                bigField.setText("");
                return null;
            }
        } catch (NumberFormatException nfe) {
            showError("Вместо текста '" + strNum +
                    "' введите число\nДесятичные числа пишутся через точку");
            bigField.setText("");
            return null;
        }
        return d;
    }
    public static void showError(String text){
        JFrame frameEx = new JFrame();
        String title = "Error";
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 18));
        UIManager.put("OptionPane.minimumSize",new java.awt.Dimension(600,200));
        JOptionPane.showMessageDialog(frameEx,text,title,JOptionPane.ERROR_MESSAGE);
    }
}
