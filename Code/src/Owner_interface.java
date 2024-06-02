import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;


public class Owner_interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Owner o1=new Owner();
		o1.data();
	}

}
class Owner extends JFrame{
	public void data() {
		JFrame frame = new JFrame("Owner");
		frame.setBounds(400,200,800,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		
		JButton hiringmanager = new JButton("Hiring Manager");
		hiringmanager.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		hiringmanager.setLayout(null);
		hiringmanager.setVisible(true);
		frame.add(hiringmanager);
		hiringmanager.setBounds(20,20,300,30);
		
		JButton viewinfo = new JButton("View Employee Information");
		viewinfo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		viewinfo.setLayout(null);
		viewinfo.setVisible(true);
		frame.add(viewinfo);
		viewinfo.setBounds(20,70,300,30);
		
		JButton rmanager = new JButton("Remove Manager");
		rmanager.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rmanager.setLayout(null);
		rmanager.setVisible(true);
		frame.add(rmanager);
		rmanager.setBounds(20,120,300,30);
		
		JButton remployee = new JButton("Remove Employee");
		remployee.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		remployee.setLayout(null);
		remployee.setVisible(true);
		frame.add(remployee);
		remployee.setBounds(20,170,300,30);
		
		JButton view = new JButton("View Room Status");
		view.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		view.setLayout(null);
		view.setVisible(true);
		frame.add(view);
		view.setBounds(20,220,300,30);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		back.setLayout(null);
		back.setVisible(true);
		frame.add(back);
		back.setBounds(100,270,150,30);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\MADSE224F-023\\images\\owner1.png"));
		frame.add(lblNewLabel);
		lblNewLabel.setBounds(350, 22,400, 400);

		hiringmanager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Msigndata M1=new Msigndata();
        		M1.data();
            }
        });
		
		viewinfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	view ve = new view();
                ve.data();
            }
        });
		
		rmanager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	RemoveManagerData rm =new RemoveManagerData();
        		rm.Data();
            }
        });
		
		remployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	RemoveEmpData re=new RemoveEmpData();
        		re.Data();
            }
        });
		
		view.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ViewRoomData vr = new ViewRoomData();
        		vr.Data();
            }
        });
		
		back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Ologindata o1=new Ologindata();
        		o1.Data();
            }
        });

		
		

	}
}
