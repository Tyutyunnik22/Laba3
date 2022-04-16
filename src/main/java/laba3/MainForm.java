package laba3; //пакет Java классов

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //библиотека для события слушателя
import java.util.ArrayList;

import javax.swing.*; // Библиотека для GUI (построена на основе awt)

public class MainForm {
	private JTextField bigField;
	
	public MainForm() {
		JFrame main_GUI = new JFrame("Главная форма");	//Создание графического окна
		
		//Добавили размещение главной формы по центру
		java.awt.Dimension f = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x1 = (f.width-600)/2;
	    int y1 = (f.height-500)/2;
		main_GUI.setBounds(x1,y1,600,500);
		
		main_GUI.getContentPane().setBackground( new Color(230, 230, 250));
		main_GUI.setResizable(false); //Фиксированный размер окна
		main_GUI.setLayout(null);
		
		JButton button1 = new JButton("Информация");
		button1.setBounds(125,350,175,40);
		button1.addActionListener(new ButtonEventInfo());
		ArrayList<String> listNames = new ArrayList<String>();
		listNames.add("Салимгареев И. 23.03.2022");
		listNames.add("Скитяева Н. 23.03.2022");
		listNames.add("Тютюнник В. 23.03.2022");
		listNames.add("Мамлеева Д. 23.03.2022");
		InfoForm.authors = listNames;
		
		JButton button_exit = new JButton("Выход"); //Добавляем кнопку
		button_exit.setBounds(300,350,175,40);
		button_exit.addActionListener(new ButtonEventExit());
		String[] items = {
	            "Переместить логотип УГАТУ в верхний правый угол",
	            "Переместить логотип УГАТУ в середину",
	            "Переместить логотип УГАТУ в левый верхний угол",
	            "Отсортировать данные в проекте22"
	        };
		
		JLabel laba_info = new JLabel(""); //Отображение текста или изображения;
		
		//Добавление списка для изменения местоположения картинки
		JComboBox<String> comboBox = new JComboBox<String>(items);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(125,390,350,40);
		comboBox.setEditable(false);
		
		//Добавление слушателя для изменения местоположения картинки
		ListenerCombo actionCombo = new ListenerCombo(); 
		actionCombo.setControls(comboBox,laba_info);
		comboBox.addActionListener(actionCombo);
			
		JMenuBar menuBar = new JMenuBar();
		
	    //Добавление в главное меню выпадающих пунктов меню  
	    menuBar.add(createFileMenu(laba_info));
	    main_GUI.setJMenuBar(menuBar);
		laba_info.setBounds(183,-25,400,250);
		
		button1.setFont(new Font("Arial", Font.BOLD, 20));
		button_exit.setFont(new Font("Arial", Font.BOLD, 30));
		
		//Метод создания поля для ввода числовых данных на главную форму
		labelAndButton(main_GUI);
		
		main_GUI.add(button1);
		main_GUI.add(button_exit);
		main_GUI.add(comboBox);
		main_GUI.add(laba_info);
		main_GUI.setVisible(true);
		
		//Закрытие окна JFrame и процесса Java
		main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	//Метод создания меню
	private JMenu createFileMenu(JLabel laba_info)
    {
        //Создание выпадающего меню
        JMenu file = new JMenu("Файл");
        //Пункт меню "Отобразить логотип УГАТУ" с изображением
        JMenuItem open = new JMenuItem("Отобразить логотип УГАТУ"); 
        open.addActionListener(null);
        //Пункт меню "Загрузить и отобразить данные файла"
        JMenuItem put = new JMenuItem("Загрузить данные файла");
        //Пункт меню с выходом из программы
        JMenuItem exit = new JMenuItem("выход");
        //Добавим в меню пункта open
        file.add(open);
        //Добавление разделителя
        file.addSeparator();
        file.add(put);
        file.addSeparator();
        file.add(exit);
        
        //Добавление слушателя для кнопки меню загрузки файла
        ListenerLoadImage actionLoadImage = new ListenerLoadImage(); 
        actionLoadImage.setLabel(laba_info);
        open.addActionListener(actionLoadImage); 
        
        ListenerLoadFile actionLoadFile = new ListenerLoadFile(); 
        put.addActionListener(actionLoadFile); 
    	
    	exit.addActionListener(new ButtonEventExit());
        
        return file;
    }
	
	private void labelAndButton(JFrame main_GUI) {
		JLabel labelSphere = new JLabel("Расчет объема шара, ввод в см");
		JLabel labelCalc = new JLabel("Введите радиус:");
		labelCalc.setBounds(125,250,350,40);
		labelCalc.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		labelCalc.setFont(new Font("Arial", Font.BOLD, 20));
		labelSphere.setBounds(125,210,350,40);
		labelSphere.setFont(new Font("Arial", Font.BOLD, 20));
		
		bigField = new JTextField("", 25);
		bigField.setFont(new Font("Dialog", Font.PLAIN, 25));
		bigField.setBounds(300,255,170,30);
		
		JButton button3 = new JButton("Вычислить");
		button3.setBounds(212,300,175,40);
		button3.setFont(new Font("Arial", Font.BOLD, 25));
		button3.addActionListener(new ButtonEventCalc());
	
		main_GUI.add(labelCalc);
		main_GUI.add(labelSphere);
		main_GUI.add(bigField);
		main_GUI.add(button3);
		
		bigField.setDocument(new LimitJTextField(10));
	}

	class ButtonEventInfo implements ActionListener {
	    public void actionPerformed (ActionEvent e) {
    		InfoForm info = new InfoForm();
    		info.showFormForFile();
	    }
	}
	
	class ButtonEventExit implements ActionListener {
	    public void actionPerformed (ActionEvent e) {
	    	System.exit(1);
	    }
	}
	
	class ButtonEventCalc implements ActionListener {
	    public void actionPerformed (ActionEvent e) {
	        try {
	            Double radius = Check.getNumber(bigField.getText(), 0.1, 100000.0,bigField);
	            if (radius == null) {
	                return;
	            }
	            
	            calculation(radius);
	            
	        } catch (NumberFormatException ex) {
	            System.out.println("Ошибка: " + ex.getMessage());
	        }
	    }
	}
	
	private void calculation(Double radius) {
		Double result = (4.0 / 3) * Math.PI * Math.pow(radius, 3);
		String output = result.toString() + " (см в кубе)";
		
		JFrame frameResult = new JFrame();
        String title = "Result";
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 18));
        UIManager.put("OptionPane.minimumSize",new java.awt.Dimension(580,200));
        JOptionPane.showMessageDialog(frameResult,output,title,JOptionPane.INFORMATION_MESSAGE);
	}
}
