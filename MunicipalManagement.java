import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/*
frames to include :
1. loading screen
2. welcome screen new user or existing user
3. login
4. signup
5. main screen for administrator
6. main screen for general
*/

class welcomeScreen extends JFrame implements ActionListener {
    JLabel l1;

    welcomeScreen() {
        l1 = new JLabel("yay");
        l1.setBounds(65, 75, 200, 30);
        l1.setForeground(new Color(23, 212, 212));

        this.add(l1);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(450, 450);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(3, 17, 38));
        ImageIcon icon = new ImageIcon("icon.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}

class SignUp extends JFrame implements ActionListener {

    JTextField tf1, tf3;
    JLabel l1, l2, l3, l4, l5, signUp, icon;
    JPasswordField pf;
    JButton submit, back;
    ImageIcon sign = new ImageIcon("letter2.png");
    JComboBox cb;
    String user[] = { "General", "Administrator" };

    SignUp() {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setTitle("Municipal Management System");
        signUp = new JLabel("Sign Up :");

        signUp.setBounds(105, 35, 200, 45);
        signUp.setForeground(new Color(23, 212, 212));
        signUp.setFont(new Font("Times New Roman", Font.PLAIN, 40));

        icon = new JLabel();
        icon.setIcon(sign);
        icon.setBounds(65, 35, 35, 35);

        l1 = new JLabel("UserName");
        l1.setBounds(65, 75, 200, 30);
        l1.setForeground(new Color(23, 212, 212));
        tf1 = new JTextField();
        tf1.setBackground(new Color(138, 222, 218));
        tf1.setBounds(65, 100, 200, 30);
        tf1.setPreferredSize(new DimensionUIResource(450, 50));

        l3 = new JLabel("User ID");
        l3.setBounds(65, 195, 200, 30);
        l3.setForeground(new Color(23, 212, 212));
        tf3 = new JTextField();
        tf3.setBounds(65, 220, 200, 30);
        tf3.setPreferredSize(new DimensionUIResource(450, 50));

        l4 = new JLabel("Password");
        l4.setBounds(65, 255, 200, 30);
        l4.setForeground(new Color(23, 212, 212));
        pf = new JPasswordField();
        pf.setBounds(65, 280, 200, 30);
        pf.setPreferredSize(new DimensionUIResource(450, 50));

        l5 = new JLabel("Select type of user");
        l5.setBounds(65, 315, 200, 30);
        l5.setForeground(new Color(23, 212, 212));
        cb = new JComboBox(user);
        cb.setBounds(65, 340, 110, 30);

        // submit = new JButton(new ImageIcon("application.png"));
        submit = new JButton("Submit");
        submit.setBounds(200, 360, 110, 30);
        submit.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(200, 300, 110, 30);
        back.addActionListener(this);
        this.add(icon);
        this.add(signUp);
        this.add(l1);
        this.add(l3);
        this.add(l4);
        this.add(l5);
        this.add(tf1);
        this.add(tf3);
        this.add(pf);
        this.add(cb);
        this.add(submit);
        this.add(back);

        this.setLayout(null);
        this.setResizable(false);
        this.setSize(450, 450);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(3, 17, 38));
        ImageIcon icon = new ImageIcon("icon.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                String url = "jdbc:mysql://127.0.0.1:3306/info";
                String username = "root";
                String password = "deepak";
                String name = tf1.getText();
                String pass = pf.getText();
                // int id = ;
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);

                Statement stm = con.createStatement();
                String sql = "INSERT INTO management (ID,Name,Password,UserType) values ("
                        + Integer.parseInt(tf3.getText()) + ",'" + tf1.getText() + "','" + pf.getText() + "','"
                        + (String) cb.getSelectedItem() + "')";
                stm.executeUpdate(sql);
                // con.close();
                JOptionPane.showMessageDialog(null, "User created");
                this.setVisible(false);
                new LogIn();

            } catch (Exception E) {
                // E.printStackTrace();
                JOptionPane.showMessageDialog(null, "Plz enter a unique id");
            }
            System.out.println("working");

            // retrieving data from table
            System.out.println("trying to fetch data from table");

            try {
                String url = "jdbc:mysql://127.0.0.1:3306/info";
                String username = "root";
                String password = "deepak";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);

                String query = "select ID, name from management";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                rs.next();
                int id = rs.getInt("ID");
                String name = rs.getString("Name");

                System.out.println(id);
                System.out.println(name);

                System.out.println("data retrieved");
                con.close();
                System.out.println("closed");
            } catch (Exception E) {
                System.out.println(E);
            }
        }
        if (e.getSource() == back) {
            this.setVisible(false);
            new welcomeScreen();
        }
    }
}

// have to change a lot
class LogIn extends JFrame implements ActionListener {
    JLabel wrongPass;
    JButton login;
    JTextField tf1;
    JPasswordField p;
    JLabel l1, l2;
    ImageIcon sign = new ImageIcon("letter2.png");

    LogIn() {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setTitle("Municipal Management System");

        l1 = new JLabel("User ID");
        l1.setBounds(65, 75, 200, 30);
        l1.setForeground(new Color(23, 212, 212));
        tf1 = new JTextField();
        tf1.setBackground(new Color(138, 222, 218));
        tf1.setBounds(65, 100, 200, 30);
        //tf1.setPreferredSize(new DimensionUIResource(450, 50));

        l2 = new JLabel("Password");
        l2.setBounds(65, 135, 200, 30);
        l2.setForeground(new Color(23, 212, 212));
        // pf = new JPasswordField();
        // pf.setBounds(65, 160, 200, 30);
        // //pf.setPreferredSize(new DimensionUIResource(450, 50));

        p = new JPasswordField();
        p.setBounds(65,160,200,30);

        login = new JButton("LogIn");
        login.setBounds(200, 360, 110, 30);
        login.addActionListener(this);

        wrongPass = new JLabel();
        wrongPass.setBounds(65, 200, 200, 30);
        wrongPass.setForeground(new Color(23, 212, 212));

        this.add(wrongPass);
        this.add(l1);
        this.add(l2);
        this.add(tf1);
        this.add(p);
        this.add(login);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(450, 450);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(3, 17, 38));
        ImageIcon icon = new ImageIcon("icon.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {

            
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/info", "root", "deepak");

                Statement stm = con.createStatement();
                String enteredID = tf1.getText();

                System.out.println(enteredID);
                ResultSet resultSet = stm.executeQuery("SELECT COUNT(*) AS rowcount FROM management;");
                resultSet.next();
                int rowCount = resultSet.getInt("rowcount");
                resultSet = stm.executeQuery("SELECT ID FROM management;");
                System.out.println("MyTable has " + rowCount + " row(s).");

                //bala code aau thare lekhe mg
                boolean logchk=true;
                for (int i = 1; i <= rowCount; i++) {
                    while (resultSet.next()) {
                        if (enteredID.equalsIgnoreCase(resultSet.getString("ID"))){
                        } 
                        logchk = true; 
                        
                        if(logchk){
                            resultSet = stm.executeQuery("SELECT Password FROM management where ID='" + enteredID + "' ");
                            resultSet.next();
                            // String pas = resultSet.getString("Password");
                            System.out.println(resultSet.getString("Password"));
                            System.out.println(p.getText());
                            // System.out.println(resultSet.getString("UserType"));
                            String pass = resultSet.getString("Password");
                            System.out.println(pass);
                            //boolean logchk;
                            if (pass.equals(p.getText())) {
                                resultSet = stm.executeQuery("SELECT UserType FROM management where ID='" +enteredID + "' ");
                                resultSet.next();
                                System.out.println("workinng");
                                if (resultSet.getString("UserType").equals("General")){
                                    this.setVisible(false);
                                    
                                    new GeneralMainScreen(enteredID);
                                }
                                
                                
                                else if (resultSet.getString("UserType").equals("Administrator")){
                                    this.setVisible(false);

                                    new AdminMainScreen(enteredID);
                                }
                            } else if(!(pass.equals(p.getText()))){
                                wrongPass.setText("Wrong Password");
                                p.setText("");
                            }
                        }
                        else if(!(enteredID.equalsIgnoreCase(resultSet.getString("ID")))){
                            wrongPass.setText("Wrong UserID");
                            tf1.setText("");
                            p.setText("");
                        }

                    }
                }
                // this.setVisible(false);

            } catch (Exception E) {
                E.printStackTrace();
                // JOptionPane.showMessageDialog(null, "Plz enter a unique id");
            }
        }
    }

}

class GeneralMainScreen extends JFrame implements ActionListener {
    JButton insert, display;
    String ID;
    GeneralMainScreen(String id) {

        ID = id;

        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setTitle("Municipal Management System");

        insert = new JButton("insert");
        insert.setBounds(200, 360, 110, 30);
        insert.addActionListener(this);

        display = new JButton("display");
        display.setBounds(200, 320, 110, 30);
        display.addActionListener(this);

        this.add(display);
        this.add(insert);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(450, 450);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(3, 17, 38));
        ImageIcon icon = new ImageIcon("icon.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == display) {
            this.setVisible(false);
            new adminDisplay(ID);
        }
        

    }
}

class AdminMainScreen extends JFrame implements ActionListener {
    JButton edit, display;
    String ID;

    AdminMainScreen(String id) {
        ID = id;
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setTitle("Municipal Management System");

        edit = new JButton("Edit");
        edit.setBounds(200, 360, 110, 30);
        edit.addActionListener(this);

        display = new JButton("Display");
        display.setBounds(200, 320, 110, 30);
        display.addActionListener(this);

        this.add(display);
        this.add(edit);

        this.setLayout(null);
        this.setResizable(false);
        this.setSize(450, 450);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(3, 17, 38));
        ImageIcon icon = new ImageIcon("icon.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == display) {
            this.setVisible(false);
            new adminDisplay(ID);
        }
        if (e.getSource() == edit) {
            this.setVisible(false);
            new adminEdit(ID);
        }

    }

}

class adminEdit extends JFrame implements ActionListener {
    String id;
    JTextField tf1, tf2, tf3, tf4;
    JLabel l1, l2, l3, l4;
    JButton save,back;

    adminEdit(String ID) {
        id = ID;

        l1 = new JLabel("Occupation");
        l1.setBounds(65, 75, 200, 30);
        l1.setForeground(new Color(23, 212, 212));
        tf1 = new JTextField();
        tf1.setBackground(new Color(138, 222, 218));
        tf1.setBounds(65, 100, 200, 30);
        tf1.setPreferredSize(new DimensionUIResource(450, 50));

        l2 = new JLabel("Date Of Birth");
        l2.setBounds(65, 145, 200, 30);
        l2.setForeground(new Color(23, 212, 212));
        tf2 = new JTextField();
        tf2.setBounds(65, 170, 200, 30);
        tf2.setPreferredSize(new DimensionUIResource(450, 50));

        l3 = new JLabel("Family Type ");
        l3.setBounds(65, 215, 200, 30);
        l3.setForeground(new Color(23, 212, 212));
        tf3 = new JTextField();
        tf3.setBounds(65, 240, 200, 30);
        tf3.setPreferredSize(new DimensionUIResource(450, 50));

        l4 = new JLabel("Status");
        l4.setBounds(65, 285, 200, 30);
        l4.setForeground(new Color(23, 212, 212));
        tf4 = new JTextField();
        tf4.setBounds(65, 310, 200, 30);
        tf4.setPreferredSize(new DimensionUIResource(450, 50));

        save = new JButton("Save");
        save.setBounds(200, 360, 110, 30);
        save.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(75, 360, 110, 30);
        back.addActionListener(this);

        this.add(back);
        this.add(tf1);
        this.add(l1);
        this.add(l2);
        this.add(tf2);
        this.add(l3);
        this.add(tf3);
        this.add(tf4);
        this.add(l4);
        this.add(save);

        this.setLayout(null);
        this.setResizable(false);
        this.setSize(450, 450);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(3, 17, 38));
        ImageIcon icon = new ImageIcon("icon.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == save) {
            try {

                String url = "jdbc:mysql://127.0.0.1:3306/info";
                String username = "root";
                String password = "deepak";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);
                Statement stm = con.createStatement();

                String sql = "UPDATE management SET Occupation = '" + tf1.getText() + "' , DOB='" + tf2.getText()+ "' , FamilyType='" + tf3.getText() + "' , Status='" + tf4.getText() + "'where ID='" + id + "';";
               stm.executeUpdate(sql);
            } catch (Exception E) {
                System.out.println(E);
            }
        }

        if(e.getSource()==back){
            this.setVisible(false);
            new AdminMainScreen(id);
        }

    }

}

class adminDisplay extends JFrame implements ActionListener {
    JButton back;
    String ID;
    ResultSet rs;
    Statement stm;
    Connection con;
    JLabel labelID, labelNAME, labelPASS, labelUSERTYPE, labelOCCUPATION, labelDOB, labelFAMILY, labelSTATUS;

    adminDisplay(String id) {
        ID = id;

        labelID = new JLabel();
        labelID.setBounds(65, 70, 200, 30);
        labelID.setForeground(new Color(23, 212, 212));

        labelNAME = new JLabel();
        labelNAME.setBounds(65, 80, 200, 30);
        labelNAME.setForeground(new Color(23, 212, 212));

        labelPASS = new JLabel();
        labelPASS.setBounds(65, 90, 200, 30);
        labelPASS.setForeground(new Color(23, 212, 212));

        labelUSERTYPE = new JLabel();
        labelUSERTYPE.setBounds(65, 100, 200, 30);
        labelUSERTYPE.setForeground(new Color(23, 212, 212));

        labelOCCUPATION = new JLabel();
        labelOCCUPATION.setBounds(65, 110, 200, 30);
        labelOCCUPATION.setForeground(new Color(23, 212, 212));

        labelDOB = new JLabel();
        labelDOB.setBounds(65, 120, 200, 30);
        labelDOB.setForeground(new Color(23, 212, 212));

        labelFAMILY = new JLabel();
        labelFAMILY.setBounds(65, 130, 200, 30);
        labelFAMILY.setForeground(new Color(23, 212, 212));

        labelSTATUS = new JLabel();
        labelSTATUS.setBounds(65, 140, 200, 30);
        labelSTATUS.setForeground(new Color(23, 212, 212));

        back = new JButton("Back");
        back.setBounds(200, 360, 110, 30);
        back.addActionListener(this);

        this.add(back);
        this.add(labelID);
        this.add(labelNAME);
        this.add(labelPASS);
        this.add(labelUSERTYPE);
        this.add(labelOCCUPATION);
        this.add(labelDOB);
        this.add(labelFAMILY);
        this.add(labelSTATUS);

        this.setLayout(null);
        this.setResizable(false);
        this.setSize(450, 450);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(3, 17, 38));
        ImageIcon icon = new ImageIcon("icon.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            labelID.setText("UserID = " + ID);
            // Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/info", "root", "deepak");
            stm = con.createStatement();

            rs = stm.executeQuery("SELECT Name FROM management where ID='" + ID + "' ");
            rs.next();
            labelNAME.setText("Name = " + rs.getString("Name"));

            rs = stm.executeQuery("SELECT UserType FROM management where ID='" + ID + "' ");
            rs.next();
            labelUSERTYPE.setText("User Type = " + rs.getString("UserType"));

            rs = stm.executeQuery("SELECT Occupation FROM management where ID='" + ID + "' ");
            rs.next();
            labelOCCUPATION.setText("Occupation = " + rs.getString("Occupation"));

            rs = stm.executeQuery("SELECT DOB FROM management where ID='" + ID + "' ");
            rs.next();
            labelDOB.setText("Date Of Birth = " + rs.getString("DOB"));

            rs = stm.executeQuery("SELECT FamilyType FROM management where ID='" + ID + "' ");
            rs.next();
            labelFAMILY.setText("Family Type = " + rs.getString("FamilyType"));

            rs = stm.executeQuery("SELECT Password FROM management where ID='" + ID + "' ");
            rs.next();
            labelPASS.setText("Password = " + rs.getString("Password"));

            rs = stm.executeQuery("SELECT Status FROM management where ID='" + ID + "' ");
            rs.next();
            labelSTATUS.setText("Status = " + rs.getString("Status"));

        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            this.setVisible(false);
           new AdminMainScreen(ID);
        }

    }
}

class MunicipalManagement {
    public static void main(String[] args) {
        //new LogIn();
        // new adminInsert("12345", "yoo");
       new SignUp();
    }
}
