import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
	
    private Image backgroundImage;

	
    public Menu() {
        setTitle("Menu");
        setSize(1540, 820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Use BorderLayout for the frame

        
        backgroundImage = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\MADSE224F-023\\images\\a-beautiful-morning-at-the-beach-resorts-of-maldives-wallpaper-2880x1800_8.jpg").getImage(); // Replace "background.jpg" with your image file

        // Set up your menus and menu items as before

        // Create a custom JPanel for painting the background image
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        setContentPane(contentPane);

        
        
        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create a menu
        JMenu owner = new JMenu("Owner");
        owner.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        menuBar.add(owner);
        
        JMenu manager = new JMenu("Manager");
        manager.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        menuBar.add(manager);
        
        JMenu employee = new JMenu("Employee");
        employee.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        menuBar.add(employee);
        
        JMenu customer = new JMenu("Customer");
        customer.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        menuBar.add(customer);
        
       

        // Create menu items for owner

        JMenuItem ologin = new JMenuItem("Login");
        ologin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        

        // Add action listeners to the owner
        ologin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your open file logic here
            	//setVisible(false); 
            	Ologindata o1 = new Ologindata();
            	o1.Data();
            }
        });

        // Add menu items to the owner
        owner.add(ologin);
        
        
        //...........................................................
     // Create menu items for manager
        
        JMenuItem mlogin = new JMenuItem("Login");
        mlogin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        //Add menu items to the manager
        manager.add(mlogin);
        
        mlogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	//setVisible(false); 
            	Mlogindata m1 = new Mlogindata();
            	m1.Data();

            }
        });
      
        
        //...........................................................
     // Create menu items for employee
        
        JMenuItem elogin = new JMenuItem("Login");
        elogin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        employee.add(elogin);
        
        elogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	//setVisible(false); 
            	Elogindata e1 = new Elogindata();
            	e1.Data();

            }
        });
        
        
        
        //...........................................................
     // Create menu items for Customer

        JMenuItem viewroom = new JMenuItem("View Room");
        viewroom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        
        JMenuItem registration = new JMenuItem("Registration");
        registration.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        
        JMenuItem reviews = new JMenuItem("View Reviews");
        reviews.setFont(new Font("Times New Roman", Font.PLAIN, 16));

        
      //Add menu items to the customer
        customer.add(viewroom);
        customer.add(registration);
        customer.add(reviews);
        setVisible(true);
        
        
        viewroom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	ViewRoomData vr = new ViewRoomData();
        		vr.Data();
            	

            }
        });
        
        
        
        
        registration.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	CloginData c1=new CloginData();
        		c1.Data();

            }
        });
        
        reviews.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	ReviewData rd=new ReviewData();
        		rd.Data();
            	
            }
        });
        
       
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Menu m = new Menu();
            }
        });
    }
}
