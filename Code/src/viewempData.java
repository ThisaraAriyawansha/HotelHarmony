import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class viewempData {
    public static void main(String[] args) {
        view ve = new view();
        ve.data();
    }
}

class view extends JFrame {
        public void data() {
            JFrame frame = new JFrame("Employee Details");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setBounds(400,200,800,500);
            frame.setLayout(new BorderLayout());

            JButton back = new JButton("Back");
            frame.add(back, BorderLayout.SOUTH);

            JTable table = new JTable();

            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);

            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }
            });

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM employee";
                ResultSet resultSet = statement.executeQuery(query);

                DefaultTableModel model = new DefaultTableModel();

                model.setColumnIdentifiers(new Object[]{"eid", "name", "number", "age", "gender", "mid"});
                while (resultSet.next()) {
                    String id = resultSet.getString("eid");
                    String name = resultSet.getString("name");
                    String num = resultSet.getString("number");
                    String age = resultSet.getString("age");
                    String gender = resultSet.getString("gender");
                    String mid = resultSet.getString("mid");

                    model.addRow(new Object[]{id, name, num, age, gender, mid});
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

