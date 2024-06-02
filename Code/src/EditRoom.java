import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditRoomData er=new EditRoomData();
		er.Data();
	}

}

class EditRoomData{
	public void Data() {
		JFrame frame = new JFrame("Edit Room");
		frame.setBounds(00, 00,1540,820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel n = new JLabel("Room Number :");
		n.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(n);
		
		JLabel avl = new JLabel("Available :");
		avl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(avl);
		
		JLabel cln = new JLabel("Cleanin Status :");
		cln.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(cln);
		
		JLabel ar = new JLabel("Edit Room");
		ar.setFont(new Font("Times New Roman", Font.BOLD, 25));
		frame.getContentPane().add(ar);
		
		JLabel pr = new JLabel("Price :");
		pr.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(pr);
		
		JTextField uname = new JTextField();
		uname.setColumns(10);
		frame.getContentPane().add(uname);
		
		JButton add = new JButton("Edit Details");
		add.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(add);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(btnClear);
		
		JButton cancel = new JButton("Cancel");
		cancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(cancel);
		
		JLabel btype = new JLabel("Bed Type :");
		btype.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(btype);
		
		String[] lst={"Available", "Booked"};
		JComboBox avalable = new JComboBox(lst);
		frame.getContentPane().add(avalable);
		
		String[] cl= {"Cleaned", "Dirty"};
		JComboBox clln = new JComboBox(cl);
		frame.getContentPane().add(clln);
		
		String[] ty= {"Single Bed", "Double Bed"};
		JComboBox btypee = new JComboBox(ty);
		frame.getContentPane().add(btypee);
		
		JComboBox comboBox = new JComboBox();
		frame.getContentPane().add(comboBox);
		
		n.setBounds(288, 401, 132, 19);
		avl.setBounds(288, 432, 148, 26);
		cln.setBounds(288, 468, 132, 25);
		ar.setBounds(288, 337, 148, 40);
		pr.setBounds(288, 505, 109, 26);
		uname.setBounds(442, 511, 121, 19);
		add.setBounds(259, 611, 149, 31);
		btnClear.setBounds(442, 611, 121, 31);
		cancel.setBounds(607, 611, 121, 31);
		btype.setBounds(288, 544, 109, 26);
		avalable.setBounds(442, 437, 121, 21);
		clln.setBounds(442, 472, 121, 21);
		btypee.setBounds(442, 549, 121, 21);
		comboBox.setBounds(442, 402, 121, 21);
		
		
		try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
            
            String query = "SELECT Rno FROM room";
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
		

		add.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String selectedRoomNumber = (String) comboBox.getSelectedItem(); // Get the selected room number
		        String available = (String) avalable.getSelectedItem(); // Get the selected availability
		        String cleaningStatus = (String) clln.getSelectedItem(); // Get the selected cleaning status
		        String bedType = (String) btypee.getSelectedItem(); // Get the selected bed type
		        String priceText = uname.getText(); // Get the price as text

		        // Check if any field is empty
		        if (selectedRoomNumber == null || selectedRoomNumber.isEmpty() || available.isEmpty() || cleaningStatus.isEmpty() || bedType.isEmpty() || priceText.isEmpty()) {
		            JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        try {
		            int roomNumber = Integer.parseInt(selectedRoomNumber);
		            int price = Integer.parseInt(priceText);

		            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
		            String updateQuery = "UPDATE room SET available=?, status=?, type=?, price=? WHERE Rno=?";

		            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
		            preparedStatement.setString(1, available);
		            preparedStatement.setString(2, cleaningStatus);
		            preparedStatement.setString(3, bedType);
		            preparedStatement.setInt(4, price);
		            preparedStatement.setInt(5, roomNumber);

		            int rowsAffected = preparedStatement.executeUpdate();

		            if (rowsAffected > 0) {
		                JOptionPane.showMessageDialog(frame, "Room details updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
		            } else {
		                JOptionPane.showMessageDialog(frame, "Failed to update room details.", "Error", JOptionPane.ERROR_MESSAGE);
		            }

		            preparedStatement.close();
		            connection.close();
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(frame, "Invalid price format. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedIndex(-1);
				avalable.setSelectedIndex(-1);
				clln.setSelectedIndex(-1);
				btypee.setSelectedIndex(-1);
				uname.setText("");


			}
		});
		
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});

	}
}