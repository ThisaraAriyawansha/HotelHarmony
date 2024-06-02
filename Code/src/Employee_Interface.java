import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Employee_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee E1= new Employee();
		E1.data();
	}

}

class Employee extends JFrame{
	public void data() {
		JFrame frame = new JFrame("Employee");
		frame.setBounds(400,200,800,500);
		//frame.setSize(1540,820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		
		JButton editroom = new JButton("Edit Room Details");
		editroom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		editroom.setLayout(null);
		editroom.setVisible(true);
		frame.add(editroom);
		editroom.setBounds(20,20,300,30);
		
		JButton viewcus = new JButton("View Customer Information");
		viewcus.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		viewcus.setLayout(null);
		viewcus.setVisible(true);
		frame.add(viewcus);
		viewcus.setBounds(20,70,300,30);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		back.setLayout(null);
		back.setVisible(true);
		frame.add(back);
		back.setBounds(100,120,150,30);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\MADSE224F-023\\images\\employee1.jpg"));
		frame.add(lblNewLabel);
		lblNewLabel.setBounds(350,18,400,400);
		
		editroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditRoomEmpData ed =new EditRoomEmpData();
				ed.Data();
			}
		});
		
		viewcus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCustomerData D=new ViewCustomerData();
				D.data();
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
                Menu m = new Menu();

			}
		});

	}
}