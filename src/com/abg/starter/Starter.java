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
import com.mysql.jdbc.PreparedStatement;


public class Starter {
	
	private static final String url = "jdbc:mysql://localhost:3306/idperson";
    private static final String user = "root";
    private static final String password = "";
    
    private static java.sql.Connection connect;
    private static Statement stm;
    private static ResultSet rs;
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException {
		
		ID id = new ID();
		
		System.out.println(id.idPerson());
		String query = "INSERT INTO id_person (id, person_name, person_password) VALUES ("+id.idPerson()+", 'Vasya', 1234)";

		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn =  new Connection(url, user, password);
		
		connect = conn.connection();
		
//		stm = connect.createStatement();
		
		PreparedStatement preparedStmt = (PreparedStatement) connect.prepareStatement(query);
		
		preparedStmt.execute();
		
//		while (rs.next()) {
//            String str = rs.getString("id")+"|"+rs.getString("person_name")+"|"+rs.getString("person_password");
//            System.out.println("Contact:" + str);
//        }		
		
		
        preparedStmt.close();
        connect.close();
        
		JFrame frame = new JFrame("AddPerson");
		JPanel panelMain = new JPanel(new GridLayout(6,10));	
		
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
