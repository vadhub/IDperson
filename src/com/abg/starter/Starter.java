package com.abg.starter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.abg.connect.Connection;
import com.abg.person.ID;


public class Starter {
	
	private static final String url = "jdbc:mysql://localhost:3306/id_person";
    private static final String user = "root";
    private static final String password = "1234";
    
    private static Connection connect;
    private static Statement stm;
    private static ResultSet rs;
	
	public static void main(String[] args) {
		
		Connection conn = new Connection(url, user, password);
		
		connect = conn.connection();
		
		stm = ((Object) connect).createStatement();
		
		
		JFrame frame = new JFrame("AddPerson");
		JPanel panelMain = new JPanel(new GridLayout(6,10));
		ID id = new ID();		
		
		JTextField name = new JTextField();
//		JTextField pass = new JTextField();
		
		JPasswordField pass = new JPasswordField();
		name.setText("Name");
		pass.setText("Pass");
		
		name.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				name.setText("");				
			}
		});
		
		pass.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				pass.setText("");
			}
		});
		
		JButton add = new JButton("Add");
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add: ");
				System.out.println(name.getText());
				System.out.println(pass.getPassword());
				System.out.println(id.idPerson());				
			}
		});
		
		panelMain.add(name);
		panelMain.add(pass);
		panelMain.add(add);
		
		frame.setSize(300, 200);
		frame.add(panelMain);
		frame.setLocation(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
