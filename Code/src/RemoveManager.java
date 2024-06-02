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

public class RemoveManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveManagerData rm =new RemoveManagerData();
		rm.Data();
	}

}

class RemoveManagerData extends JFrame{
	
	PreparedStatement preparedStatement = null;

	
	public void Data() {
		JFrame frame = new JFrame("Remove Employee");
		frame.setBounds(00, 00,1540,820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel h1 = new JLabel("Remove Manager");
		h1.setFont(new Font("Javanese Text", Font.BOLD, 30));
		frame.getContentPane().add(h1);
		
		JButton edit = new JButton("Remove");
		edit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(edit);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(back);
		
		JLabel mNo = new JLabel("Manager Number :");
		mNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(mNo);
		
		JComboBox number = new JComboBox();
		frame.getContentPane().add(number);
		
		h1.setBounds(505, 383, 535, 40);
		edit.setBounds(505, 584, 149, 31);
		back.setBounds(727, 584, 121, 31);
		mNo.setBounds(505, 479, 162, 19);
		number.setBounds(713, 480, 113, 21);
		
		try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
            
            String query = "SELECT mid FROM manager";
            PreparedStatement statement = connection.prepareStatement(query);
            
    
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {
                String value = resultSet.getString("mid");
                number.addItem(value);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
		
		
		back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.setVisible(false);
            	Owner o1=new Owner();
        		o1.data();            
        		}
        });
		
		edit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	 String selectedText = (String) number.getSelectedItem();
		    	 
		    	 try {
		             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");

		             String deleteQuery = "DELETE FROM manager WHERE mid = ?";
		             PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
		             deleteStatement.setString(1, selectedText);

		             int rowsDeleted = deleteStatement.executeUpdate();

		             if (rowsDeleted > 0) {
	    	                JOptionPane.showMessageDialog(frame, "Manager removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	    	                frame.setVisible(false);
	    	                Owner o1=new Owner();
	    	        		o1.data();
		                
		                 number.removeItem(selectedText);
		             } else {
	    	                JOptionPane.showMessageDialog(frame, "Manager removal failed.", "Error", JOptionPane.ERROR_MESSAGE);
		             }

		             deleteStatement.close();
		             connection.close();
		         } catch (SQLException ex) {
		             ex.printStackTrace();
		         }
		    }
		});

	}
}
