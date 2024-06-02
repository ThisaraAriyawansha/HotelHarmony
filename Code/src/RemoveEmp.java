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

public class RemoveEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveEmpData re=new RemoveEmpData();
		re.Data();
	}

}

class RemoveEmpData extends JFrame{
	public void Data() {
		JFrame frame = new JFrame("Remove Employee");
		frame.setBounds(00, 00,1540,820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(null);
		
		JLabel h1 = new JLabel("Remove Employee");
		h1.setFont(new Font("Javanese Text", Font.BOLD, 30));
		frame.add(h1);
		
		JButton edit = new JButton("Remove");
		edit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(edit);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(back);
		
		JLabel eNo = new JLabel("Employee Number :");
		eNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(eNo);
		
		JComboBox number = new JComboBox();
		frame.add(number);
		
		h1.setBounds(505, 383, 535, 40);
		edit.setBounds(505, 584, 149, 31);
		back.setBounds(727, 584, 121, 31);
		eNo.setBounds(505, 479, 162, 19);
		number.setBounds(713, 480, 113, 21);

		try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
            
            String query = "SELECT eid FROM employee";
            PreparedStatement statement = connection.prepareStatement(query);
            
    
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {
                String value = resultSet.getString("eid");
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
            	          
        		}
        });
		
		edit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	 String selectedText = (String) number.getSelectedItem();
		    	 
		    	 try {
		             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");

		             String deleteQuery = "DELETE FROM employee WHERE eid = ?";
		             PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
		             deleteStatement.setString(1, selectedText);

		             int rowsDeleted = deleteStatement.executeUpdate();

		             if (rowsDeleted > 0) {
	    	                JOptionPane.showMessageDialog(frame, "Employee removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	    	                frame.setVisible(false);
	    	                Owner o1=new Owner();
	    	        		o1.data();
		                
		                 number.removeItem(selectedText);
		             } else {
	    	                JOptionPane.showMessageDialog(frame, "Employee removal failed.", "Error", JOptionPane.ERROR_MESSAGE);
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
