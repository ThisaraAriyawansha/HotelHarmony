import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;

import javax.swing.*;




public class CheckOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckOutData ch =new CheckOutData();
		ch.Data();
	}

}
 class CheckOutData extends JFrame{
	 public void Data() {
		 JFrame frame = new JFrame();
			frame.setBounds(00, 00,1540,820);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.setLayout(null);
			
			JLabel n = new JLabel("Room Number :");
			n.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			frame.add(n);
			
			JLabel h1 = new JLabel("Check Out");
			h1.setFont(new Font("Javanese Text", Font.BOLD, 30));
			frame.add(h1);
			
			JButton pay = new JButton("Pay Now");
			pay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			frame.add(pay);
			
			
			JButton b2 = new JButton("Genarate");
			b2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			frame.add(b2);
			
			
			JButton cancel = new JButton("Cancel");
			cancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			frame.add(cancel);
			
			JLabel check = new JLabel("Amount :");
			check.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			frame.add(check);
			
			JLabel nicNo = new JLabel("Your NIC No :");
			nicNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			frame.add(nicNo);
			
			JLabel nic = new JLabel();
			nic.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			frame.add(nic);
			
			JLabel amt = new JLabel("......");
			amt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			frame.add(amt);
			
			JComboBox rnum = new JComboBox();
			rnum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			frame.add(rnum);
			
			JButton pay_1 = new JButton("Search");
			pay_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			frame.add(pay_1);
			
			n.setBounds(522, 444, 132, 19);
			h1.setBounds(522, 311, 535, 40);
			pay.setBounds(505, 584, 149, 31);
			cancel.setBounds(696, 584, 120, 31);
			check.setBounds(522, 495, 137, 26);
			nicNo.setBounds(522, 397, 132, 19);
			nic.setBounds(696, 398, 121, 21);
			amt.setBounds(696, 495, 137, 26);
			rnum.setBounds(696, 440, 130, 26);
			pay_1.setBounds(875, 391, 149, 31);
			b2.setBounds(875, 584, 149, 31);



			
			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
					) {
					            String query = "SELECT nic FROM id WHERE id = (SELECT MAX(id) FROM id);"; 

					            PreparedStatement preparedStatement = connection.prepareStatement(query);
					            ResultSet resultSet = preparedStatement.executeQuery();

					            if (resultSet.next()) {
					            	long maxValue = resultSet.getLong("nic");
					                nic.setText(String.valueOf(maxValue)); 
					            } 

					            resultSet.close();
					            preparedStatement.close();
					        } catch (SQLException ex) {
					            ex.printStackTrace();
					        }
			
			rnum.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	 String roomNumber = rnum.getSelectedItem().toString();
				     String nicc = nic.getText();
	                
	                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "")) {
	                   
	                    String query = "SELECT Amount FROM customer_room WHERE nic = ? AND rno = ?";
	                    PreparedStatement preparedStatement = connection.prepareStatement(query);
	                    preparedStatement.setString(1, nicc);
	                    preparedStatement.setString(2, roomNumber);

	                    ResultSet resultSet = preparedStatement.executeQuery();

	                    if (resultSet.next()) {
	                        double price = resultSet.getDouble("Amount");
	                        amt.setText(String.valueOf(price)); 
	                        //System.out.println("Price: " + price);
	                    } 

	                    preparedStatement.close();
	                } catch (SQLException EX) {
	                    EX.printStackTrace();
	                }
	                
	            }
	        });
			
			
			b2.addActionListener(new ActionListener() {
			      public void actionPerformed(ActionEvent e) {
			          try {
			              // Load the JRXML file (assuming it's in your project's source folder)
			              InputStream reportStream = getClass().getResourceAsStream("C:\\Users\\User\\eclipse-workspace\\MADSE224F-023\\final.jrxml");
			              JasperDesign jasperDesign = JRXmlLoader.load(reportStream);

			              // Compile the report design
			              JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

			              // Fill the report (no need to specify a data source as it's embedded in the report)
			              JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null);

			              // Show the report in a viewer
			              JasperViewer.viewReport(jasperPrint, false);
			          } catch (Exception ex) {
			              ex.printStackTrace();
			          }
			      }
			  });
			
			
			
			pay.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        String roomNumber = rnum.getSelectedItem().toString();
			        String nicc = nic.getText();
			        
			        
			        
			        
			        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "")) {
			            String updateStatusQuery = "UPDATE room SET available = 'Available' WHERE Rno = ?";
			            PreparedStatement updateStatusStatement = connection.prepareStatement(updateStatusQuery);
			            updateStatusStatement.setString(1, roomNumber);
			            
			            int rowsAffected = updateStatusStatement.executeUpdate(); 

			            if (rowsAffected > 0) {
			            	 rnum.setSelectedItem(-1);
			            	 amt.setText(".....");
			                JOptionPane.showMessageDialog(frame, "Payment successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
			                String deleteQuery = "DELETE FROM customer_room WHERE NIC = ? AND Rno = ?";
			                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
			                deleteStatement.setString(1, nicc);
			                deleteStatement.setString(2, roomNumber);

			               

			                int rowsAffectedd = deleteStatement.executeUpdate();
			            } else {
			                JOptionPane.showMessageDialog(frame, "Payment failed.", "Error", JOptionPane.ERROR_MESSAGE);
			            }

			            updateStatusStatement.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }
			});

			
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					BookRoomData R1=new BookRoomData();
					R1.Data();
				}
			});
			
			
			pay_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						
			            String nicNumber = nic.getText();

			            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
			            
			            String query = "SELECT rno FROM customer_room where nic=?";
			            PreparedStatement statement = connection.prepareStatement(query);
			            statement.setString(1, nicNumber);
			    
			            ResultSet resultSet = statement.executeQuery();
			            
			            
			            while (resultSet.next()) {
			                String value = resultSet.getString("Rno");
			                rnum.addItem(value);
			            }
			            
			            resultSet.close();
			            statement.close();
			            connection.close();
			        } catch (SQLException Ex) {
			            Ex.printStackTrace();
			        }
					
				}
			});
			
	 }
 }