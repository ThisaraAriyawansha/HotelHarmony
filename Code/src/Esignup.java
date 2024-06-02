import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Esignup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BackgroundPanell B1=new BackgroundPanell("C:\\Users\\User\\eclipse-workspace\\MADSE224F-023\\images\\Mlogin.jpg");

		
		Esigndata E1=new Esigndata();
		E1.data();

	}

}

class BackgroundPanell extends JPanel {

	
    private Image backgroundImage;

    public BackgroundPanell(String imagePath) {
        backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

class Esigndata extends JFrame{
	
	PreparedStatement preparedStatement = null;

	
	public void data() {
		JFrame frame = new JFrame("Employee Registration");
		frame.setBounds(00, 00,1540,820);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setExtendedState(JFrame.NORMAL);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		
		//BackgroundPanell backgroundPanel = new BackgroundPanell("C:\\Users\\User\\eclipse-workspace\\MADSE224F-023\\images\\Mlogin.jpg");
		//frame.setVisible(true);
		//frame.setContentPane(backgroundPanel);
		
		JLabel n = new JLabel("Name :");
		n.setForeground(Color.BLACK); 
		n.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		n.setLayout(null);
		n.setVisible(true);
		frame.add(n);
		
		JLabel p = new JLabel("Phone Number :");
		p.setForeground(Color.BLACK); 
		p.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		p.setLayout(null);
		p.setVisible(true);
		frame.add(p);
		
		JLabel a = new JLabel("Age :");
		a.setForeground(Color.BLACK); 
		a.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		a.setLayout(null);
		a.setVisible(true);
		frame.add(a);
		
		JLabel g = new JLabel("Gender :");
		g.setForeground(Color.BLACK); 
		g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		g.setLayout(null);
		g.setVisible(true);
		frame.add(g);
		
		JLabel s = new JLabel("Singup");
		s.setForeground(Color.BLACK); 
		s.setFont(new Font("Times New Roman", Font.BOLD, 25));
		s.setLayout(null);
		s.setVisible(true);
		frame.add(s);
		
		JLabel u = new JLabel("Username :");
		u.setForeground(Color.BLACK); 
		u.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		u.setLayout(null);
		u.setVisible(true);
		frame.add(u);
		
		JLabel pw = new JLabel("Password :");
		pw.setForeground(Color.BLACK); 
		pw.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pw.setLayout(null);
		pw.setVisible(true);
		frame.add(pw);
		
		JTextField name = new JTextField();
		name.setLayout(null);
		name.setVisible(true);
		frame.add(name);
		
		
		JTextField number = new JTextField();
		number.setLayout(null);
		number.setVisible(true);
		frame.add(number);
		
		JRadioButton male = new JRadioButton("Male");
		male.setForeground(Color.BLACK); 
		male.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		male.setOpaque(false);
		male.setLayout(null);
		male.setVisible(true);
		frame.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setForeground(Color.BLACK); 
		female.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		female.setOpaque(false);
		female.setLayout(null);
		female.setVisible(true);
		frame.add(female);
		
		JTextField uname = new JTextField();
		uname.setLayout(null);
		uname.setVisible(true);
		frame.add(uname);
		
		JTextField pwd = new JPasswordField();
		pwd.setLayout(null);
		pwd.setVisible(true);
		frame.add(pwd);
		
		JTextField age = new JTextField();
		age.setLayout(null);
		age.setVisible(true);
		frame.add(age);
		
		JButton save = new JButton("Save");
		save.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		save.setLayout(null);
		frame.setVisible(true);
		frame.add(save);
		
		JButton cl = new JButton("Clear");
		cl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cl.setLayout(null);
		frame.setVisible(true);
		frame.add(cl);
		
		JButton ex = new JButton("Exit");
		ex.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ex.setLayout(null);
		ex.setVisible(true);
		frame.add(ex);
		
		JLabel mi = new JLabel("Manager Id :");
		mi.setForeground(Color.BLACK); 
		mi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mi.setLayout(null);
		mi.setVisible(true);
		frame.add(mi);
		
		JComboBox mid = new JComboBox();
		mid.setLayout(null);
		mid.setVisible(true);
		frame.add(mid);
		
		n.setBounds(288, 401, 95, 19);
		p.setBounds(288, 432, 148, 26);
		a.setBounds(288, 468, 68, 25);
		g.setBounds(288, 503, 109, 26);
		s.setBounds(288, 337, 109, 40);
		u.setBounds(288, 539, 109, 26);
		pw.setBounds(288, 575, 109, 26);
		name.setBounds(442, 401, 121, 21);
		number.setBounds(442, 438, 121, 19);
		male.setBounds(435, 508, 68, 21);
		female.setBounds(536, 508,90,21);
		uname.setBounds(442, 545, 121, 19);
		pwd.setBounds(442, 582, 121, 19);
		age.setBounds(442, 473, 121, 19);
		save.setBounds(285, 668, 121, 31);
		cl.setBounds(442, 668, 121, 31);
		ex.setBounds(611, 668, 121, 31);
		mi.setBounds(288, 611, 109, 26);
		mid.setBounds(442, 617, 111, 19);


		try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
            
            String query = "SELECT mid FROM manager";
            PreparedStatement statement = connection.prepareStatement(query);
            
    
            ResultSet resultSet = statement.executeQuery();
            
            // Populate the JComboBox with retrieved values
            while (resultSet.next()) {
                String value = resultSet.getString("mid");
                mid.addItem(value);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
		
		ex.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.setVisible(false);
            	Manager m1=new Manager();
        		m1.data();
            }
        });
		
		cl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	uname.setText("");
            	pwd.setText("");
            	name.setText("");
            	number.setText("");
            	age.setText("");
            	female.setSelected(false);
            	male.setSelected(false);
            	}
        });
		
		save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
    	        String namee=name.getText().toString();
    	        String numberr=number.getText().toString();
    	        String agee=age.getText().toString();
    	        String gender=male.isSelected() ? "Male":(female.isSelected()? "Female":"");
    	        String username=uname.getText().toString();
    	        String password=pwd.getText().toString();
		    	String m = (String) mid.getSelectedItem();

    	        
    	        if (namee.isEmpty() || numberr.isEmpty() ||gender.isEmpty() || username.isEmpty() || password.isEmpty()||agee.isEmpty()) {
    	            JOptionPane.showMessageDialog(frame, "Insert Field", "Error", JOptionPane.ERROR_MESSAGE);
    	        }

    	        else if(numberr.length()!=10) {
    	        	JOptionPane.showMessageDialog(frame, "Enter Correct Phone Number", "Error", JOptionPane.ERROR_MESSAGE);
    	        }
    	        else {
    	        
    	        String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
                String usernamee = "root";
                String passwordd = "";

                try {
                    Connection connection = DriverManager.getConnection(jdbcUrl, usernamee, passwordd);
                    String insertQuery = "INSERT INTO employee(name,number,age,gender,username,password,mid) VALUES (?, ?, ?, ?, ?, ?, ?)";

                    // Create a PreparedStatement
                    preparedStatement = connection.prepareStatement(insertQuery);

                    preparedStatement.setString(1, namee);
                    preparedStatement.setString(2, numberr);
                    preparedStatement.setString(3, agee);
                    preparedStatement.setString(4, gender);
                    preparedStatement.setString(5, username);
                    preparedStatement.setString(6, password);
                    preparedStatement.setString(7, m);


                    // Execute the INSERT query
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
        	        	JOptionPane.showMessageDialog(frame, "Data inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        	        	frame.setVisible(false);
        	        	Manager m1=new Manager();
        	    		m1.data();

                    } else {
                        System.out.println("Data insertion failed.");
                    }
                
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    	        }
    	        

            }
        });


	}
}
