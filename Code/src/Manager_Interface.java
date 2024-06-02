import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Manager_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager m1=new Manager();
		m1.data();
	}

}

class Manager extends JFrame{
	public void data() {
		JFrame frame = new JFrame("Manager");
		//frame.setBounds(400,200,800,500);
		frame.setBounds(400,200,800,500);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton hiringemployee = new JButton("Hiring Employee");
		hiringemployee.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		hiringemployee.setLayout(null);
		hiringemployee.setVisible(true);
		frame.getContentPane().add(hiringemployee);
		hiringemployee.setBounds(20,20,300,30);
		
		JButton viewinfo = new JButton("View Employee Information");
		viewinfo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		viewinfo.setLayout(null);
		viewinfo.setVisible(true);
		frame.getContentPane().add(viewinfo);
		viewinfo.setBounds(20,70,300,30);
		
		JButton remployee = new JButton("Remove Employee");
		remployee.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		remployee.setLayout(null);
		remployee.setVisible(true);
		frame.getContentPane().add(remployee);
		remployee.setBounds(20,120,300,30);
		
		JButton room = new JButton("Add Room");
		room.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		room.setLayout(null);
		room.setVisible(true);
		frame.getContentPane().add(room);
		room.setBounds(20,170,300,30);
		
		JButton view = new JButton("View Room Status");
		view.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		view.setLayout(null);
		view.setVisible(true);
		frame.getContentPane().add(view);
		view.setBounds(20,220,300,30);
		
		JButton editroom = new JButton("Edit Room Details");
		editroom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		editroom.setLayout(null);
		editroom.setVisible(true);
		frame.getContentPane().add(editroom);
		editroom.setBounds(20,270,300,30);
		
		JButton viewcus = new JButton("View Customer Information");
		viewcus.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		viewcus.setLayout(null);
		viewcus.setVisible(true);
		frame.getContentPane().add(viewcus);
		viewcus.setBounds(20,321,300,30);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		back.setLayout(null);
		back.setVisible(true);
		frame.getContentPane().add(back);
		back.setBounds(294,386,150,30);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\MADSE224F-023\\images\\manager.png"));
		frame.add(lblNewLabel);
		lblNewLabel.setBounds(350,18,400,400);

		
		
		hiringemployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	Esigndata E1=new Esigndata();
        		E1.data();

            	}
        });
		
		viewinfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	view ve = new view();
                ve.data();

            	}
        });
		
		remployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	RemoveEmpData re=new RemoveEmpData();
        		re.Data();

            	}
        });
		
		room.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

        		Addroomdata R1=new Addroomdata();
        		R1.data();

            	}
        });
		
		
		view.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	ViewRoomData vr = new ViewRoomData();
        		vr.Data();

            	}
        });
		
		
		editroom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	EditRoomData er=new EditRoomData();
        		er.Data();

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
            	Mlogindata M1=new Mlogindata();
        		M1.Data();

            	}
        });
		

	}
}