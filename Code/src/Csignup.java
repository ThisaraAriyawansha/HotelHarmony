import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Csignup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CsignupData C1=new CsignupData();
		C1.Data();
	}

}

class CsignupData extends JFrame{
	public void Data() {
		JFrame frame = new JFrame("Customer Signup");
		frame.setBounds(00, 00,1540,820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(null);
		
		JLabel n = new JLabel("Name :");
		n.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(n);
		
		JLabel h1 = new JLabel("Welcome to Urban Serenity Hotel...!");
		h1.setFont(new Font("Javanese Text", Font.BOLD, 30));
		frame.add(h1);
		
		JLabel c = new JLabel("Country :");
		c.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(c);
		
		JTextField name = new JTextField();
		frame.add(name);
		
		
		JButton create = new JButton("Create");
		create.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(create);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(btnClear);
		
		JButton cancel = new JButton("Cancel");
		cancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(cancel);
		
		JLabel h2 = new JLabel("Create an account");
		h2.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		frame.add(h2);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(lblGender);
		
		JRadioButton male = new JRadioButton("Male");
		male.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(female);
		
		JTextField country = new JTextField();
		country.setColumns(10);
		frame.add(country);
		
		
		
		JLabel nicNo = new JLabel("Your NIC No :");
		nicNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(nicNo);
		
		JTextField nic = new JTextField();
		nic.setColumns(10);
		frame.add(nic);

		JLabel pw = new JLabel("Password :");
		pw.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(pw);
		
		JTextField pwd = new JTextField();
		pwd.setColumns(10);
		frame.add(pwd);
     
		
		n.setBounds(522, 357, 132, 19);
		h1.setBounds(522, 211, 535, 40);
		c.setBounds(522, 400, 109, 26);
		name.setBounds(696, 358, 121, 21);
		create.setBounds(505, 549, 149, 31);
		btnClear.setBounds(696, 549, 120, 31);
		cancel.setBounds(856, 549, 120, 31);
		h2.setBounds(522, 261, 237, 19);
		lblGender.setBounds(522, 447, 109, 26);
		male.setBounds(692, 450, 74, 21);
		female.setBounds(793, 450, 98, 21);
		country.setBounds(696, 405, 121, 21);
		nic.setBounds(696, 317, 121, 21);
		nicNo.setBounds(522, 316, 132, 19);
		pw.setBounds(517, 496, 137, 26);
		pwd.setBounds(696, 501, 121, 21);

		
		create.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String customerName = name.getText();
		        String customerCountry = country.getText();
		        String customerNIC = nic.getText();
		        String customerPassword = pwd.getText();
		        String customerGender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "");

		        if (customerName.isEmpty() || customerCountry.isEmpty() || customerNIC.isEmpty() || customerPassword.isEmpty() || customerGender.isEmpty()) {
		            JOptionPane.showMessageDialog(frame, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        if (customerNIC.length()!=12) {
		            JOptionPane.showMessageDialog(frame, "Invalid NIC format.", "Error", JOptionPane.ERROR_MESSAGE);
		            return; 
		        }

		        
		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "")) {
		            String insertQuery = "INSERT INTO customer (nic,name,country,gender,password) VALUES (?, ?, ?, ?, ?)";
		            
		            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		            preparedStatement.setString(2, customerName);
		            preparedStatement.setString(3, customerCountry);
		            preparedStatement.setString(1, customerNIC);
		            preparedStatement.setString(5, customerPassword);
		            preparedStatement.setString(4, customerGender);

		            int rowsAffected = preparedStatement.executeUpdate();

		            if (rowsAffected > 0) {
		                JOptionPane.showMessageDialog(frame, "Customer details inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
		                frame.setVisible(false);
		                CloginData c1=new CloginData();
		        		c1.Data();
		            } else {
		                JOptionPane.showMessageDialog(frame, "Failed to insert customer details.", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		});


		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nic.setText("");
				pwd.setText("");
				country.setText("");
				name.setText("");
			    male.setSelected(false);
		        female.setSelected(false);
			
			}
		});
		

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);

				CloginData c1=new CloginData();
				c1.Data();
			}
		});
		
		
	}
}
