import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Clogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CloginData c1=new CloginData();
		c1.Data();
	}

}
class CloginData extends JFrame{
	public void Data() {
		JFrame frame = new JFrame("Customer Login");
		frame.setBounds(00,00,1540,820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(null);
		
		JLabel un = new JLabel("User Name :");
		un.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(un);
		
		JLabel h = new JLabel("Login");
		h.setFont(new Font("Times New Roman", Font.BOLD, 25));
		frame.add(h);
		
		JLabel pw = new JLabel("Password :");
		pw.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(pw);
		
		JTextField username = new JTextField();
		frame.add(username);
		
		
		JButton login = new JButton("Login");
		login.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(login);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(btnClear);
		
		JButton cancel = new JButton("Cancel");
		cancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(cancel);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(btnSignup);
		
		JPasswordField pwd = new JPasswordField();
		frame.add(pwd);
		
		un.setBounds(522, 332, 132, 19);
		h.setBounds(522, 253, 148, 40);
		pw.setBounds(522, 386, 109, 26);
		username.setBounds(696, 333, 121, 21);
		login.setBounds(505, 451, 149, 31);
		btnClear.setBounds(696, 451, 120, 31);
		cancel.setBounds(857, 451, 121, 31);
		btnSignup.setBounds(696, 511, 120, 31);
		pwd.setBounds(696, 392, 121, 19);


		
		
		login.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        String userrnamee=username.getText().toString();
    	    	String passwordd=pwd.getText().toString();
    	        try {
    	        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");

    	            
    	            String sqlQuery = "SELECT * FROM customer WHERE nic = ? AND password = ?";
    	            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
    	            preparedStatement.setString(1, userrnamee); 
    	            preparedStatement.setString(2, passwordd); 

    	            ResultSet resultSet = preparedStatement.executeQuery();

    	            if (resultSet.next())  {
    	            	
    	            	 String insertQuery = "INSERT INTO id (nic) VALUES (?)";

    	    	            PreparedStatement preparedStatementt = connection.prepareStatement(insertQuery);

    	    	            preparedStatementt.setString(1, userrnamee);

    	    	            // Execute the INSERT query
    	    	            int rowsAffected = preparedStatementt.executeUpdate();

    	            	frame.setVisible(false);
    	            	BookRoomData R1=new BookRoomData();
    	        		R1.Data();
    	            } else {
    	                
    	                JOptionPane.showMessageDialog(frame, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
    	            }

    	            preparedStatement.close();
    	            connection.close();
    	        } catch (SQLException ex) {
    	            ex.printStackTrace();
    	        }
    	        
    	    }
    	});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				pwd.setText("");

			}
		});
		
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				CsignupData C1=new CsignupData();
				C1.Data();
			}
		});
		
	}
}