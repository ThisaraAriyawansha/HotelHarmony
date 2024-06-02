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

public class OLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ologindata o1=new Ologindata();
		o1.Data();
	}

}
class Ologindata extends JFrame{
	
	PreparedStatement preparedStatement = null;
	
	public void Data() {
		JFrame f=new JFrame("Owner Loging");
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(1540,820);
		
		JLabel h=new JLabel("Login");
		h.setFont(new Font("Times New Roman", Font.BOLD, 25));
		h.setLayout(null);
		h.setVisible(true);
		f.add(h);
		
		JLabel u=new JLabel("User Name");
		u.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		u.setLayout(null);
		u.setVisible(true);
		f.add(u);
		
		JLabel p=new JLabel("Password");
		p.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		p.setLayout(null);
		p.setVisible(true);
		f.add(p);
		
		JTextField uname=new JTextField();
		uname.setLayout(null);
		uname.setVisible(true);
		f.add(uname);
		
		JPasswordField pw=new JPasswordField();
		pw.setLayout(null);
		pw.setVisible(true);
		f.add(pw);
		
		JButton log=new JButton("Login");
		log.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		log.setLayout(null);
		log.setVisible(true);
		f.add(log);
		
		JButton cl=new JButton("Clear");
		cl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cl.setLayout(null);
		cl.setVisible(true);
		f.add(cl);
		
		JButton ex=new JButton("Exit");
		ex.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ex.setLayout(null);
		ex.setVisible(true);
		f.add(ex);
		
		h.setBounds(522,257,100,35);
		u.setBounds(522,340,100,35);
		p.setBounds(522,421,100,35);
		uname.setBounds(660,347,100,25);
		pw.setBounds(660,428,100,25);
		log.setBounds(508,503,100,30);
		cl.setBounds(660,503,100,30);
		ex.setBounds(797,503,100,30);
		
		ex.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		f.setVisible(false);
                Menu m = new Menu();

            }
        });
		cl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	uname.setText("");
            	pw.setText("");

            	}
        });
		
		
		
    	log.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
    	        String username = "root";
    	        String password = "";
    	        String userrname=uname.getText().toString();
    	    	String passwordd=pw.getText().toString();
    	        try {
    	            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

    	            
    	            String sqlQuery = "SELECT * FROM owner WHERE username = ? AND password = ?";
    	            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
    	            preparedStatement.setString(1, userrname); 
    	            preparedStatement.setString(2, passwordd); 

    	            ResultSet resultSet = preparedStatement.executeQuery();

    	            if (resultSet.next())  {
    	                // Login successful
    	            	f.setVisible(false);
    	                Owner o1 = new Owner();
    	                o1.data();
    	            } else {
    	                // Login failed
    	                JOptionPane.showMessageDialog(f, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
    	            }

    	            //resultSet.close();
    	            preparedStatement.close();
    	            connection.close();
    	        } catch (SQLException ex) {
    	            ex.printStackTrace();
    	        }
    	    }
    	});

	}
}
