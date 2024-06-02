import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EditRoomEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditRoomEmpData ed =new EditRoomEmpData();
		ed.Data();
	}

}

class EditRoomEmpData extends JFrame{
	public void Data() {
		JFrame frame = new JFrame("Edit Room for Employee");
		frame.setBounds(00, 00,1540,820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(null);
		
		JLabel h1 = new JLabel("Edit Room");
		h1.setFont(new Font("Javanese Text", Font.BOLD, 30));
		frame.add(h1);
		
		JButton edit = new JButton("Edit Details");
		edit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(edit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(btnClear);
		
		JButton cancel = new JButton("Cancel");
		cancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(cancel);
		
		JLabel check = new JLabel("Cleaning Status :");
		check.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(check);
		
		JLabel nicNo = new JLabel("Room Number :");
		nicNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nicNo.setBounds(522, 426, 132, 19);
		frame.add(nicNo);
		
		JComboBox comboBox = new JComboBox();
		frame.add(comboBox);
		
		JComboBox cln = new JComboBox();
		cln.setModel(new DefaultComboBoxModel(new String[] {"Cleaned", "Dirty"}));
		frame.add(cln);
		
		h1.setBounds(522, 346, 535, 40);
		edit.setBounds(505, 584, 149, 31);
		btnClear.setBounds(696, 584, 120, 31);
		cancel.setBounds(863, 584, 121, 31);
		check.setBounds(522, 495, 137, 26);
		comboBox.setBounds(716, 427, 107, 21);
		cln.setBounds(716, 500, 107, 21);

		
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
		
		edit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String selectedRoomNumber = (String) comboBox.getSelectedItem(); 
		        String cleaningStatus = (String) cln.getSelectedItem(); 

		        // Check if any field is empty
		        if (selectedRoomNumber == null ||  cleaningStatus.isEmpty()) {
		            JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        try {
		            

		            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
		            String updateQuery = "UPDATE room SET status=? WHERE Rno=?";

		            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
		            
		            preparedStatement.setString(2, selectedRoomNumber);
		            preparedStatement.setString(1, cleaningStatus);

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
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Employee E1= new Employee();
				E1.data();
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox.setSelectedIndex(-1);
				cln.setSelectedIndex(-1);
			}
		});
	}
}