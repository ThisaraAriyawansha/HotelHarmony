import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BookRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookRoomData R1=new BookRoomData();
		R1.Data();
	}

}

class BookRoomData extends JFrame{
	public void Data() {
		JFrame frame = new JFrame();
		frame.setBounds(00, 00,1540,820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(null);
		
		JLabel n = new JLabel("Room Number :");
		n.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(n);
		
		JLabel h1 = new JLabel("Booking a Room");
		h1.setFont(new Font("Javanese Text", Font.BOLD, 30));
		frame.add(h1);
		
		JLabel c = new JLabel("No of Days :");
		c.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(c);
		
		JButton cal = new JButton("Calculate");
		cal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(cal);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(btnClear);
		
		JButton cancel = new JButton("Cancel");
		cancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(cancel);
		
		JLabel check = new JLabel("Check In Time :");
		check.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(check);
		
		JLabel amt = new JLabel("Amount :");
		amt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(amt);
		
		JTextField country = new JTextField();
		country.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(country);
		
		JLabel nicNo = new JLabel("Your NIC No :");
		nicNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(nicNo);
		
		JLabel nic = new JLabel();
		nic.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(nic);
		
		JButton book = new JButton("Booking");
		book.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(book);
		
		JLabel time = new JLabel("");
		time.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(time);
		
		JLabel amount = new JLabel("");
		amount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(amount);
		
		JComboBox comboBox = new JComboBox();
		frame.add(comboBox);
		
		
		JButton checkOut = new JButton("Check Out ");
		checkOut.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(checkOut);
		
		n.setBounds(522, 373, 132, 19);
		h1.setBounds(522, 257, 535, 40);
		c.setBounds(522, 414, 109, 26);
		cal.setBounds(505, 584, 149, 31);
		btnClear.setBounds(696, 584, 120, 31);
		cancel.setBounds(863, 584, 121, 31);
		check.setBounds(522, 463, 137, 26);
		amt.setBounds(522, 510, 137, 26);
		country.setBounds(696, 419, 121, 21);
		nicNo.setBounds(522, 331, 132, 19);
		nic.setBounds(696, 332, 121, 21);
		time.setBounds(696, 463, 200, 26);
		amount.setBounds(696, 508, 137, 26);
		comboBox.setBounds(696, 374, 121, 21);
		book.setBounds(505, 642, 149, 31);
		checkOut.setBounds(835, 649, 149, 31);

		Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = sdf.format(currentDate);

        time.setText("" + formattedDateTime);
		
        
        
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
            
            String query = "SELECT Rno FROM room WHERE available = 'Available'";
            PreparedStatement statement = connection.prepareStatement(query);

            
    
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {
                String value = resultSet.getString("Rno");
                comboBox.addItem(value);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
        
        
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
) {
            String query = "SELECT nic FROM id WHERE id = (SELECT MAX(id) FROM id);"; 

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
            	long maxValue = resultSet.getLong("nic");
            	//long  maxValue = resultSet.getInt(1); 
                nic.setText(String.valueOf(maxValue)); 
            } 

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
		cal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String num=comboBox.getSelectedItem().toString();
				int day=Integer.parseInt(country.getText());
				
				
				try {
    	        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");

    	            
    	            String sqlQuery = "SELECT price FROM room WHERE Rno = ?";
    	            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
    	            preparedStatement.setString(1, num); 

    	            ResultSet resultSet = preparedStatement.executeQuery();

    	            if (resultSet.next())  {
    	            	int price = resultSet.getInt("price");
    	            	int tot=price*day;
    	            	amount.setText(String.valueOf(tot));
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
				country. setText("");
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				CloginData c1=new CloginData();
				c1.Data();
			}
		});
		
		book.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String roomNumber = comboBox.getSelectedItem().toString();
		        String checkInTime = time.getText();
		        String amountt = amount.getText();
		        String customerNIC = nic.getText();

		        // Assuming you have a JDBC connection set up to your database
		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "")) {
		            String insertQuery = "INSERT INTO customer_room (nic,rno,time,Amount) VALUES (?, ?, ?, ?)";
		            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		            preparedStatement.setString(2, roomNumber);
		            preparedStatement.setString(3, checkInTime);
		            preparedStatement.setString(4, amountt);
		            preparedStatement.setString(1, customerNIC);

		            int rowsAffected = preparedStatement.executeUpdate();

		            if (rowsAffected > 0) {
		            	
		            	 String updateStatusQuery = "UPDATE room SET available = 'Booked' WHERE Rno = ?";
		                 PreparedStatement updateStatusStatement = connection.prepareStatement(updateStatusQuery);
		                 updateStatusStatement.setString(1, roomNumber);
		                 updateStatusStatement.executeUpdate();
		                 updateStatusStatement.close();
		                 
		                 
		                JOptionPane.showMessageDialog(frame, "Booking successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
		               
		            } else {
		                JOptionPane.showMessageDialog(frame, "Booking failed.", "Error", JOptionPane.ERROR_MESSAGE);
		            }

		            preparedStatement.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		});

		
		
		checkOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckOutData ch =new CheckOutData();
				ch.Data();
			}
		});
	}
	
	
}
