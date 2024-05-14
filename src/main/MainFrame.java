package main;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Dimension;

public class MainFrame {

	private JFrame frame;
	
	public static List<String> readys;
	private static List<MyThread> threads;
	private JTextField textField;
	private JTextField textField_1;
	
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	
	private JLabel label_3;
	private JLabel label_4;
	private static JLabel label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
		threads = new ArrayList<>();
		readys = new ArrayList<>();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setMinimumSize(new Dimension(50, 50));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{252, 208, 0};
		gridBagLayout.rowHeights = new int[]{17, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Введіть кількість потоків");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel label = new JLabel("Введіть номер числа фібоначчі");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		frame.getContentPane().add(label, gbc_label);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		frame.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		label_3 = new JLabel("Введіть число");
		label_3.setVisible(false);
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 2;
		frame.getContentPane().add(label_3, gbc_label_3);
		
		label_4 = new JLabel("Введіть число");
		label_4.setVisible(false);
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 2;
		frame.getContentPane().add(label_4, gbc_label_4);
		
		JButton button = new JButton("Створити потоки");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buttonCreateThreads(textField.getText(), textField_1.getText());
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 3;
		frame.getContentPane().add(button, gbc_button);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBoxThreadsChanged(comboBox.getSelectedIndex());
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 4;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		
		comboBox_1 = new JComboBox(new String[] {"Мінімальний", "Нормальний", "Високий"});
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBoxPriorsChanged(comboBox_1.getSelectedIndex());
			}
		});
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 4;
		frame.getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		JButton button_1 = new JButton("Запустити перегони");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buttonRun();
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 5;
		frame.getContentPane().add(button_1, gbc_button_1);
		
		JLabel label_1 = new JLabel("Переможці:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 6;
		frame.getContentPane().add(label_1, gbc_label_1);
		
		label_2 = new JLabel("");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 7;
		frame.getContentPane().add(label_2, gbc_label_2);
	}
	
	//User functions
	private void createNewThreads(int numOfThreads, long numOfFib) {
		threads.clear();
		comboBox.removeAllItems();
		
		for(int i = 0; i < numOfThreads; i++) {
			threads.add(new MyThread(numOfFib));
			comboBox.addItem("Поток " + (i + 1));
			threads.get(i).setName("Поток " + (i + 1));
			threads.get(i).setPriority(Thread.NORM_PRIORITY);
		}
	}
	
	private void buttonCreateThreads(String numOfThreads, String numOfFib) {
		int threads;
		long fib;
		label_3.setVisible(false);
		label_4.setVisible(false);
		
		try {
			threads = Integer.parseInt(numOfThreads);
		}
		catch(Exception e) {
			label_3.setVisible(true);
			return;
		}
		try {
			fib = Long.parseLong(numOfFib);
		}
		catch(Exception e) {
			label_4.setVisible(true);
			return;
		}
		
		createNewThreads(threads, fib);
	}
	
	public static void endOfThreadExec(String name) {
		if(readys.size() > 3) {
			for(int i = 0; i < threads.size(); i++) {
				threads.get(i).interrupt();
			}
			
			label_2.setText(readys.get(0) + ", " + readys.get(1) + ", " + readys.get(2));
		}
		else {
			readys.add(name);
		}
		
	}
	
	//Events
	private void buttonRun() {
		readys.clear();
		
		for(int i = 0; i < threads.size(); i++) {
			threads.get(i).start();
		}
		
	}
	
	private void comboBoxThreadsChanged(int item) {
		comboBox_1.setSelectedIndex(threads.get(item).getPriority() / 5);
	}
	
	private void comboBoxPriorsChanged(int item) {
		threads.get(comboBox.getSelectedIndex()).setPriority(item == 0 ? 1 : item * 5);;
	}
}
