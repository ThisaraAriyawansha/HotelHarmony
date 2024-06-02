import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ViewRoomData vr = new ViewRoomData();
		vr.Data();
	}

}

class ViewRoomData extends JFrame{
	public void Data() {
		 JFrame frame = new JFrame("Room Details");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(400,200,800,500);

	        JPanel panel = new JPanel(new BorderLayout());
	        frame.add(panel);

	        
	        JTable table = new JTable();

	        
	        JScrollPane scrollPane = new JScrollPane(table);
	        panel.add(scrollPane, BorderLayout.CENTER);

	        JButton closeButton = new JButton("Close");
	        panel.add(closeButton, BorderLayout.SOUTH);

	        
	        closeButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                frame.setVisible(false);;
	            }
	        });

	        try {
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
	            Statement statement = connection.createStatement();
	            String query = "SELECT * FROM room"; 
	            ResultSet resultSet = statement.executeQuery(query);

	            DefaultTableModel model = new DefaultTableModel();

	           
	            int columnCount = resultSet.getMetaData().getColumnCount();
	            for (int i = 1; i <= columnCount; i++) {
	                model.addColumn(resultSet.getMetaData().getColumnName(i));
	            }
	            while (resultSet.next()) {
	                Object[] row = new Object[columnCount];
	                for (int i = 1; i <= columnCount; i++) {
	                    row[i - 1] = resultSet.getObject(i);
	                }
	                model.addRow(row);
	            }

	            
	            table.setModel(model);

	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        frame.setVisible(true);
		
	}
}
