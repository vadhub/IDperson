package com.abg.starter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
        
		JFrame frame = new JFrame("AddPerson");
		JPanel panelMain = new JPanel(new GridLayout(6,10));	
		
		JTextField name = new JTextField();
		JTextField pass = new JTextField();
		
//		JPasswordField pass = new JPasswordField();
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
		
		ID id = new ID();
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn =  new Connection(url, user, password);	
		
//		stm = connect.createStatement();
		
//		while (rs.next()) {
//            String str = rs.getString("id")+"|"+rs.getString("person_name")+"|"+rs.getString("person_password");
//            System.out.println("Contact:" + str);
//        }		
		
		JButton add = new JButton("Add");
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add: ");
				System.out.println(name.getText());
				System.out.println(pass.getText());
				System.out.println(id.idPerson());
				try {
					connect = conn.connection();
					String query = "INSERT INTO id_person (id, person_name, person_password) VALUES ("+id.idPerson()+",'"+name.getText()+"','"+pass.getText()+"')";
					
					PreparedStatement preparedStmt = (PreparedStatement) connect.prepareStatement(query);
					preparedStmt.execute();
					preparedStmt.close();
				    connect.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
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
