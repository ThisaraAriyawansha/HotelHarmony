import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Review {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReviewData rd=new ReviewData();
		rd.Data();
	}

}

class ReviewData extends JFrame{
	public void Data() {
		JFrame f=new JFrame("Customer Reviews");
		f.setVisible(true);
		f.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Reviews");
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 50));
		f.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Luxurious Stay:");
		lblNewLabel_1.setFont(new Font("Bodoni MT", Font.PLAIN, 30));
		f.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html>\"My stay at the Urban Serenity Hotel was absolutely luxurious.<br> The room was spacious and beautifully decorated. The staff was incredibly attentive, and the amenities were top-notch. I especially enjoyed the delicious breakfast buffet. I can't wait to visit again!\"<html>");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		f.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Great Service:");
		lblNewLabel_1_1.setFont(new Font("Bodoni MT", Font.PLAIN, 30));
		f.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("<html>\"I was impressed with the exceptional service at the Urban Serenity Hotel.The staff went out of their way to make me feel welcome and comfortable. The concierge helped me plan my city tours, and the room service was prompt. I had a fantastic stay!\"<html>");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		f.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Family-Friendly:");
		lblNewLabel_1_1_1.setFont(new Font("Bodoni MT", Font.PLAIN, 30));
		f.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("<html>\"Our family had a wonderful time at the Urban Serenity Hotel. The kids loved the swimming pool and the kids' club. The resort's beachfront location was a bonus, and we enjoyed the delicious meals at the on-site restaurants.\"<html>");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		f.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Family-Friendly:");
		lblNewLabel_1_1_1_1.setFont(new Font("Bodoni MT", Font.PLAIN, 30));
		f.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("<html>\"The food at the Urban Serenity Hotel was a highlight of my stay. Each dish was a work of art, and the flavors were out of this world. The restaurant's sommelier recommended the perfect wine pairings. A gastronomic delight!\"<html>");
		lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		f.add(lblNewLabel_2_1_1_1);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(715, 704, 113, 33);
		f.add(btnNewButton);
		f.setVisible(true);
		f.setBounds(00, 00,1540,820);
		
		
		lblNewLabel.setBounds(525, 74, 503, 109);
		lblNewLabel_1.setBounds(40, 227, 225, 39);
		lblNewLabel_2.setBounds(40, 293, 328, 206);
		lblNewLabel_1_1.setBounds(400, 227, 225, 39);
		lblNewLabel_2_1.setBounds(400, 269, 380, 206);
		lblNewLabel_1_1_1.setBounds(809, 227, 225, 39);
		lblNewLabel_2_1_1.setBounds(790, 269, 348, 206);
		lblNewLabel_1_1_1_1.setBounds(1177, 227, 225, 39);
		lblNewLabel_2_1_1_1.setBounds(1148, 276, 348, 193);

		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
			}
		});
	    }
	}

