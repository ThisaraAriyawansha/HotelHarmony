import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Welcome extends JFrame {
	public Welcome() {
        JFrame frame = new JFrame("Welcome....!");
        frame.getContentPane().setForeground(new Color(0, 0, 77));
        frame.setBounds(0, 0, 1540, 820);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(new Color(0, 0, 57)); 
        frame.setVisible(true);

        JButton menuButton = new JButton("Menu");
        menuButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(menuButton);

        JLabel welcomeLabel = new JLabel("<html>Welcome To<br>Urban Serenity Hotel<html>");
        welcomeLabel.setBackground(new Color(128, 128, 0));
        welcomeLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 50));
        //welcomeLabel.setOpaque(true); 
        //welcomeLabel.setForeground(Color.BLACK); 
        welcomeLabel.setForeground(Color.GRAY); 
        frame.getContentPane().add(welcomeLabel);



        menuButton.setBounds(1200, 668, 120, 31);
        welcomeLabel.setBounds(85, 78, 657, 274);

        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Menu m = new Menu();
            }
        });
    }

    public static void main(String[] args) {
    	Welcome framee = new Welcome();
    }
}
