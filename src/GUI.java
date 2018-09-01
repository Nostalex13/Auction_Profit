import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				IsValidData(InputHandler.Instance);
			}
		});
	}
	
	private static void IsValidData(InputHandler inputHandler) {
		try {
			if(inputHandler.GetPath() != null) {
				if (inputHandler.GetName() != null) 
					ShowSecondGUI();
				else {
					GUI frame = new GUI(); // <-- Setting name
					frame.setVisible(true);
				}
			} else {
				GUI frame = new GUI();
				CreateBrowseDialog(frame); // <-- Setting path
				frame.dispose();
				
				IsValidData(inputHandler);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void ShowSecondGUI() {
		System.out.println("Name: " + InputHandler.Instance.GetName());
		System.out.println("Path: " + InputHandler.Instance.GetPath());
		
		MainClass mainClass = new MainClass();
		GUI2 gui2 = new GUI2(mainClass.profit);
		gui2.setVisible(true);
	}
	
	private static void CreateBrowseDialog(JFrame frame) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.showOpenDialog(frame);
		
		// Open an input stream
		
		File file = fileChooser.getSelectedFile();
		InputHandler.Instance.SetPath(file.getPath()); // Setting path
	}
	
	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JEditorPane charName = new JEditorPane();
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPane.setBackground(new Color(240, 240, 240));
		textPane.setEditable(false);
		textPane.setText("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0438\u043C\u044F \u043B\u044E\u0431\u043E\u0433\u043E \u043F\u0435\u0440\u0441\u043E\u043D\u0430\u0436\u0430 \u043D\u0430 \u0432\u0430\u0448\u0435\u043C \u0430\u043A\u043A\u0430\u0443\u043D\u0442\u0435");
		
		JButton btnComplite = new JButton("Complite");
		btnComplite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InputHandler.Instance.SetName(charName.getText()); // Setting name
				setVisible(false);
				dispose();
				
				ShowSecondGUI();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(charName)
								.addComponent(textPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(14, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnComplite)
							.addGap(220))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(charName, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnComplite)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
