import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Addroomdata R1=new Addroomdata();
		R1.data();

	}

}

class Addroomdata extends JFrame{
	
	PreparedStatement preparedStatement = null;

	
	public void data() {
		JFrame frame = new JFrame("Add Room");
		frame.setBounds(00, 00,1540,820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		
		JLabel n = new JLabel("Room Number :");
		n.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(n);
		
		JLabel avl = new JLabel("Available :");
		avl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(avl);
		
		JLabel cln = new JLabel("Cleanin Status :");
		cln.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(cln);
		
		JLabel ar = new JLabel("Add Room");
		ar.setFont(new Font("Times New Roman", Font.BOLD, 25));
		frame.getContentPane().add(ar);
		
		JLabel pr = new JLabel("Price :");
		pr.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(pr);
		
		JTextField rnumber = new JTextField();
		frame.add(rnumber);
		
		
		JTextField price = new JTextField();
		frame.add(price);
		
		JButton add = new JButton("Add Room");
		add.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(add);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(btnClear);
		
		JButton cancel = new JButton("Cancel");
		cancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(cancel);
		
		JLabel btype = new JLabel("Bed Type :");
		btype.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(btype);
		
		String[] lst={"Available", "Booked"};
		JComboBox avalable = new JComboBox(lst);
		frame.add(avalable);
		
		String[] cl= {"Cleaned", "Dirty"};
		JComboBox clln = new JComboBox(cl);
		frame.add(clln);
		
		String[] ty= {"Single Bed", "Double Bed"};
		JComboBox btypee = new JComboBox(ty);
		frame.add(btypee);
		
		n.setBounds(288, 401, 132, 19);
		avl.setBounds(288, 432, 148, 26);
		cln.setBounds(288, 468, 132, 25);
		ar.setBounds(288, 337, 148, 40);
		pr.setBounds(288, 505, 109, 26);
		rnumber.setBounds(442, 401, 121, 21);
		price.setBounds(442, 511, 121, 19);
		add.setBounds(259, 611, 149, 31);
		btnClear.setBounds(442, 611, 121, 31);
		cancel.setBounds(607, 611, 121, 31);
		btype.setBounds(288, 544, 109, 26);
		avalable.setBounds(442, 437, 121, 21);
		clln.setBounds(442, 472, 121, 21);
		btypee.setBounds(442, 549, 121, 21);

		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number=rnumber.getText().toString();
    	        String avl=avalable.getSelectedItem().toString();
    	        String cl=clln.getSelectedItem().toString();
    	        int pr=Integer.parseInt(price.getText());
    	        String type=btypee.getSelectedItem().toString();
		    	

    	        
    	        if (number.isEmpty()) {
    	            JOptionPane.showMessageDialog(frame, "Insert Field", "Error", JOptionPane.ERROR_MESSAGE);
    	        }

    	        String jdbcUrl = "jdbc:mysql://localhost:3306/hotel";
                String usernamee = "root";
                String passwordd = "";

                try {
                    Connection connection = DriverManager.getConnection(jdbcUrl, usernamee, passwordd);
                    String insertQuery = "INSERT INTO room(Rno,available,status,price,type) VALUES (?, ?, ?, ?, ?)";

                    // Create a PreparedStatement
                    preparedStatement = connection.prepareStatement(insertQuery);

                    preparedStatement.setString(1, number);
                    preparedStatement.setString(2, avl);
                    preparedStatement.setString(3, cl);
                    preparedStatement.setInt(4, pr);
                    preparedStatement.setString(5, type);
                    


                    // Execute the INSERT query
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
        	        	JOptionPane.showMessageDialog(frame, "Room inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        	        	frame.setVisible(false);
        	        	Manager m1=new Manager();
        	    		m1.data();

                    } else {
                        System.out.println("Room insertion failed.");
                    }
                
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    	        }
			
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rnumber.setText("");
				price.setText("");


			}
		});
		
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
	}
}
