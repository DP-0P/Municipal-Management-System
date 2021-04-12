import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class LoadingScreen extends JFrame {
    JProgressBar load;
    JLabel mm, loading, copy;

    LoadingScreen() {
        mm = new JLabel("MUNICIPAL MANAGEMENT SYSTEM");
        mm.setBounds(28, 15, 350, 71);
        mm.setFont(new Font("Cooper Black", Font.PLAIN, 18));
        mm.setForeground(new Color(0x45A29E));

        loading = new JLabel("Loading...");
        loading.setBounds(165, 80, 200, 25);
        loading.setFont(new Font(" ", Font.PLAIN, 16));
        loading.setForeground(new Color(0xC5C6C7));

        load = new JProgressBar();
        load.setBackground(new Color(0x1f2833));
        load.setForeground(new Color(0xC5C6C7));
        load.setBorder(BorderFactory.createLineBorder(new Color(0x66fcf1)));
        load.setBounds(125, 110, 150, 25);

        copy = new JLabel("© Deepak 2021, All rights reserved.");
        copy.setBounds(100, 140, 350, 71);
        copy.setForeground(new Color(0x7a807c));

        this.add(load);
        this.add(mm);
        this.add(loading);
        this.add(copy);

        this.setUndecorated(true);
        this.setSize(400, 200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x1f2833));
        this.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(45);
                load.setValue(i);

                if (i == 100) {
                    new WelcomeScreen();
                    this.setVisible(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class WelcomeScreen extends JFrame implements ActionListener {
    JSeparator div;
    JButton log, signup, exit;
    JLabel su, li, welcome, copy;

    WelcomeScreen() {
        copy = new JLabel("© Deepak 2021, All rights reserved.");
        copy.setBounds(120, 380, 350, 71);
        copy.setForeground(new Color(0x7a807c));

        div = new JSeparator();
        div.setOrientation(SwingConstants.VERTICAL);
        div.setBounds(224, 185, 200, 150);
        div.setBackground(new Color(0xC5C6C7));
        div.setForeground(null);

        li = new JLabel("New User ?");
        li.setFont(new Font("Cooper Black", Font.PLAIN, 13));
        li.setForeground(new Color(0xC5C6C7));

        su = new JLabel("Existing User ?");
        su.setFont(new Font("Cooper Black", Font.PLAIN, 13));
        su.setForeground(new Color(0xC5C6C7));

        welcome = new JLabel("WELCOME");
        welcome.setBounds(55, 75, 350, 71);
        welcome.setFont(new Font("Cooper Black", Font.PLAIN, 60));
        welcome.setForeground(new Color(0x45A29E));

        signup = new JButton("Sign Up");
        signup.setFont(new Font(" ", Font.PLAIN, 15));
        signup.setBorder(BorderFactory.createLineBorder(new Color(0x66fcf1)));
        signup.setForeground(new Color(0x45A29E));
        signup.setBackground(new Color(0x1f2833));
        signup.addActionListener(this);
        signup.setFocusable(false);

        exit = new JButton("EXIT");
        exit.setFont(new Font(" ", Font.PLAIN, 15));
        exit.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        exit.setForeground(new Color(0x45A29E));
        exit.setBackground(new Color(0x1f2833));
        exit.addActionListener(this);
        exit.setFocusable(false);

        log = new JButton("Log In");
        log.setFont(new Font("", Font.PLAIN, 15));
        log.setBorder(BorderFactory.createLineBorder(new Color(0x66fcf1)));
        log.setForeground(new Color(0x45A29E));
        log.setBackground(new Color(0x1f2833));
        log.addActionListener(this);
        log.setFocusable(false);

        this.add(div);
        this.add(copy);
        this.add(exit);
        this.add(welcome);
        this.add(li);
        this.add(su);
        this.add(signup);
        this.add(log);

        this.setUndecorated(true);
        this.setSize(448, 448);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x1f2833));
        this.setVisible(true);

        log.setBounds(260, 250, 70, 25);
        signup.setBounds(100, 250, 70, 25);
        li.setBounds(100, 200, 100, 25);
        su.setBounds(260, 200, 120, 25);
        exit.setBounds(385, 5, 45, 45);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signup) {
            this.setVisible(false);
            new SignUp();
        }
        if (e.getSource() == log) {
            this.setVisible(false);
            new LogIn();
        }
        if (e.getSource() == exit)
            System.exit(0);
    }
}

class SignUp extends JFrame implements ActionListener {
    JTextField enterName, enterID;
    JLabel username, id, pass, type, signUp, icon, idError, copy;
    JPasswordField pf;
    JButton submit, back, exit;
    JSeparator userLine, idLine, passLine;
    JComboBox cb;
    String user[] = { "General", "Administrator" };

    SignUp() {
        copy = new JLabel("© Deepak 2021, All rights reserved.");
        copy.setBounds(120, 380, 350, 71);
        copy.setForeground(new Color(0x7a807c));

        signUp = new JLabel("Create Account");
        signUp.setBounds(25, 45, 400, 51);
        signUp.setFont(new Font("Cooper Black", Font.PLAIN, 50));
        signUp.setForeground(new Color(0x45A29E));

        username = new JLabel("User Name");
        username.setBounds(55, 95, 200, 30);
        username.setFont(new Font("Cooper Black", Font.PLAIN, 13));
        username.setForeground(new Color(0x45A29E));

        enterName = new JTextField();
        enterName.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        enterName.setBackground(new Color(0x1f2833));
        enterName.setForeground(new Color(0xC5C6C7));
        enterName.setBounds(55, 120, 200, 30);

        userLine = new JSeparator();
        userLine.setOrientation(SwingConstants.HORIZONTAL);
        userLine.setBounds(55, 150, 200, 30);
        userLine.setBackground(new Color(0xC5C6C7));
        userLine.setForeground(null);

        id = new JLabel("User ID");
        id.setBounds(55, 155, 200, 30);
        id.setFont(new Font("Cooper Black", Font.PLAIN, 13));
        id.setForeground(new Color(0x45A29E));

        enterID = new JTextField();
        enterID.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        enterID.setBackground(new Color(0x1f2833));
        enterID.setForeground(new Color(0xC5C6C7));
        enterID.setBounds(55, 180, 200, 30);

        idLine = new JSeparator();
        idLine.setOrientation(SwingConstants.HORIZONTAL);
        idLine.setBounds(55, 210, 200, 30);
        idLine.setBackground(new Color(0xC5C6C7));
        idLine.setForeground(null);

        pass = new JLabel("Password");
        pass.setBounds(55, 215, 200, 30);
        pass.setFont(new Font("Cooper Black", Font.PLAIN, 13));
        pass.setForeground(new Color(0x45A29E));

        pf = new JPasswordField();
        pf.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        pf.setBackground(new Color(0x1f2833));
        pf.setForeground(new Color(0xC5C6C7));
        pf.setBounds(55, 240, 200, 30);

        passLine = new JSeparator();
        passLine.setOrientation(SwingConstants.HORIZONTAL);
        passLine.setBounds(55, 270, 200, 30);
        passLine.setBackground(new Color(0xC5C6C7));
        passLine.setForeground(null);

        type = new JLabel("Select type of user");
        type.setBounds(55, 275, 200, 30);
        type.setFont(new Font("Cooper Black", Font.PLAIN, 13));
        type.setForeground(new Color(0x45A29E));

        cb = new JComboBox(user);
        cb.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        cb.setBackground(new Color(0x1f2833));
        cb.setForeground(new Color(0xC5C6C7));
        cb.setBounds(55, 310, 110, 30);

        exit = new JButton("EXIT");
        exit.setFont(new Font(" ", Font.PLAIN, 15));
        exit.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        exit.setForeground(new Color(0x45A29E));
        exit.setBackground(new Color(0x1f2833));
        exit.addActionListener(this);
        exit.setFocusable(false);
        exit.setBounds(385, 5, 45, 45);

        submit = new JButton("SUBMIT");
        submit.setFont(new Font(" ", Font.PLAIN, 15));
        submit.setBorder(BorderFactory.createLineBorder(new Color(0x66fcf1)));
        submit.setForeground(new Color(0x45A29E));
        submit.setBackground(new Color(0x1f2833));
        submit.addActionListener(this);
        submit.setFocusable(false);
        submit.setBounds(55, 355, 90, 30);

        back = new JButton("< BACK");
        back.setFont(new Font(" ", Font.PLAIN, 15));
        back.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        back.setForeground(new Color(0x45A29E));
        back.setBackground(new Color(0x1f2833));
        back.addActionListener(this);
        back.setFocusable(false);
        back.setBounds(15, 5, 90, 45);

        this.add(copy);
        this.add(passLine);
        this.add(idLine);
        this.add(userLine);
        this.add(exit);
        this.add(signUp);
        this.add(username);
        this.add(id);
        this.add(pass);
        this.add(type);
        this.add(enterName);
        this.add(enterID);
        this.add(pf);
        this.add(back);
        this.add(submit);
        this.add(cb);

        this.setUndecorated(true);
        this.setSize(448, 448);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x1f2833));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                String url = "jdbc:mysql://127.0.0.1:3306/info";
                String username = "root";
                String password = "deepak";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);
                Statement stm = con.createStatement();

                if (enterID.getText().length() == 5) {

                    String sql = "INSERT INTO management (ID,Name,Password,UserType) values ("
                            + Integer.parseInt(enterID.getText()) + ",'" + enterName.getText() + "','" + pf.getText()
                            + "','" + (String) cb.getSelectedItem() + "')";
                    stm.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "User created");
                    this.setVisible(false);
                    new LogIn();
                } else {
                    enterID.setText("");

                    idError = new JLabel("ID should be of length 5");
                    idError.setFont(new Font(" ", Font.PLAIN, 13));
                    idError.setForeground(new Color(0x66fcf1));
                    idError.setBounds(55, 210, 200, 30);
                    this.add(idError);

                    pass.setBounds(55, 230, 200, 30);
                    pf.setBounds(55, 255, 200, 30);
                    passLine.setBounds(55, 280, 200, 30);
                    type.setBounds(55, 285, 200, 30);
                    cb.setBounds(55, 320, 110, 30);
                    submit.setBounds(55, 360, 90, 30);
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
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
                System.out.println("data retrieved");
                con.close();
                System.out.println("closed");
            } catch (Exception E) {
                System.out.println(E);
            }
        }
        if (e.getSource() == back) {
            this.setVisible(false);
            new WelcomeScreen();
        }
        if (e.getSource() == exit)
            System.exit(0);
    }
}

class LogIn extends JFrame implements ActionListener {
    JButton login, exit, back;
    JTextField usertf;
    JPasswordField pf;
    JLabel userid, pass, wrongPass, wrongid, log, copy;
    JSeparator userLine, passLine;

    LogIn() {
        copy = new JLabel("© Deepak 2021, All rights reserved.");
        copy.setBounds(120, 380, 350, 71);
        copy.setForeground(new Color(0x7a807c));

        log = new JLabel("Log In ");
        log.setBounds(55, 45, 300, 51);
        log.setFont(new Font("Cooper Black", Font.PLAIN, 50));
        log.setForeground(new Color(0x45A29E));

        userid = new JLabel("User ID");
        userid.setBounds(55, 95, 200, 30);
        userid.setFont(new Font("Cooper Black", Font.PLAIN, 13));
        userid.setForeground(new Color(0x45A29E));

        usertf = new JTextField();
        usertf.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        usertf.setBackground(new Color(0x1f2833));
        usertf.setForeground(new Color(0xC5C6C7));
        usertf.setBounds(55, 120, 200, 30);

        userLine = new JSeparator();
        userLine.setOrientation(SwingConstants.HORIZONTAL);
        userLine.setBounds(55, 150, 200, 30);
        userLine.setBackground(new Color(0xC5C6C7));
        userLine.setForeground(null);

        pass = new JLabel("Password");
        pass.setBounds(55, 155, 200, 30);
        pass.setFont(new Font("Cooper Black", Font.PLAIN, 13));
        pass.setForeground(new Color(0x45A29E));

        pf = new JPasswordField();
        pf.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        pf.setBackground(new Color(0x1f2833));
        pf.setForeground(new Color(0xC5C6C7));
        pf.setBounds(55, 180, 200, 30);

        passLine = new JSeparator();
        passLine.setOrientation(SwingConstants.HORIZONTAL);
        passLine.setBounds(55, 210, 200, 30);
        passLine.setBackground(new Color(0xC5C6C7));
        passLine.setForeground(null);

        exit = new JButton("EXIT");
        exit.setFont(new Font(" ", Font.PLAIN, 15));
        exit.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        exit.setForeground(new Color(0x45A29E));
        exit.setBackground(new Color(0x1f2833));
        exit.addActionListener(this);
        exit.setFocusable(false);
        exit.setBounds(385, 5, 45, 45);

        back = new JButton("< BACK");
        back.setFont(new Font(" ", Font.PLAIN, 15));
        back.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        back.setForeground(new Color(0x45A29E));
        back.setBackground(new Color(0x1f2833));
        back.addActionListener(this);
        back.setFocusable(false);
        back.setBounds(15, 5, 90, 45);

        login = new JButton("Log In");
        login.setFont(new Font(" ", Font.PLAIN, 15));
        login.setBorder(BorderFactory.createLineBorder(new Color(0x66fcf1)));
        login.setForeground(new Color(0x45A29E));
        login.setBackground(new Color(0x1f2833));
        login.addActionListener(this);
        login.setFocusable(false);
        login.setBounds(55, 230, 70, 30);

        wrongPass = new JLabel();
        wrongPass.setBounds(55, 225, 200, 30);
        wrongPass.setFont(new Font(" ", Font.PLAIN, 13));
        wrongPass.setForeground(new Color(0x66fcf1));

        wrongid = new JLabel();
        wrongid.setBounds(55, 150, 200, 30);
        wrongid.setFont(new Font(" ", Font.PLAIN, 13));
        wrongid.setForeground(new Color(0x66fcf1));

        this.add(copy);
        this.add(passLine);
        this.add(exit);
        this.add(back);
        this.add(log);
        this.add(userid);
        this.add(userLine);
        this.add(pass);
        this.add(usertf);
        this.add(pf);
        this.add(login);
        this.add(wrongPass);
        this.add(wrongid);

        this.setUndecorated(true);
        this.setSize(448, 448);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x1f2833));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.setVisible(false);
            new WelcomeScreen();
        }

        if (e.getSource() == exit)
            System.exit(0);

        if (e.getSource() == login) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/info", "root", "deepak");

                Statement stm = con.createStatement();
                String enteredID = usertf.getText();

                ResultSet resultSet = stm.executeQuery("SELECT COUNT(*) AS rowcount FROM management;");
                resultSet.next();
                int rowCount = resultSet.getInt("rowcount");
                resultSet = stm.executeQuery("SELECT ID FROM management;");
                System.out.println("MyTable has " + rowCount + " row(s).");

                boolean logchk = false;
                String retrievepass = "";
                for (int i = 1; i <= rowCount; i++) {
                    while (resultSet.next()) {
                        if (enteredID.equals(resultSet.getString("ID"))) {
                            resultSet = stm
                                    .executeQuery("SELECT Password FROM management where ID='" + enteredID + "' ");
                            resultSet.next();
                            retrievepass = resultSet.getString("Password");
                            logchk = true;
                            break;
                        }
                    }
                }

                if (logchk) {
                    if (retrievepass.equals(pf.getText())) {
                        resultSet = stm.executeQuery("SELECT UserType FROM management where ID='" + enteredID + "' ");
                        resultSet.next();

                        if (resultSet.getString("UserType").equals("General")) {
                            this.setVisible(false);
                            new GeneralMainScreen(enteredID);
                        } else if (resultSet.getString("UserType").equals("Administrator")) {
                            this.setVisible(false);
                            new AdminMainScreen(enteredID);
                        }
                    } else {
                        pf.setText("");
                        login.setBounds(55, 250, 70, 30);
                        wrongPass.setText("Entered password is wrong !!!");
                    }
                } else {
                    pf.setText("");
                    usertf.setText("");
                    login.setBounds(55, 250, 70, 30);
                    wrongid.setText("Entered User ID is wrong !!!");

                    pass.setBounds(55, 170, 200, 30);
                    pf.setBounds(55, 195, 200, 30);
                    passLine.setBounds(55, 225, 200, 30);
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
    }
}

class GeneralMainScreen extends JFrame implements ActionListener {
    JButton edit, display, back, exit, upgradeBtn, delete;
    String ID, pn;
    JLabel editmsg, upgrade, confirm, copy, mm, profile, profileName;

    GeneralMainScreen(String id) {
        ID = id;

        mm = new JLabel("Municipal Management");
        mm.setBounds(15, 50, 450, 71);
        mm.setFont(new Font("Cooper Black", Font.PLAIN, 35));
        mm.setForeground(new Color(0x45A29E));

        exit = new JButton("EXIT");
        exit.setFont(new Font(" ", Font.PLAIN, 15));
        exit.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        exit.setForeground(new Color(0x45A29E));
        exit.setBackground(new Color(0x1f2833));
        exit.addActionListener(this);
        exit.setFocusable(false);
        exit.setBounds(385, 5, 45, 45);

        back = new JButton("< BACK");
        back.setFont(new Font(" ", Font.PLAIN, 15));
        back.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        back.setForeground(new Color(0x45A29E));
        back.setBackground(new Color(0x1f2833));
        back.addActionListener(this);
        back.setFocusable(false);
        back.setBounds(15, 5, 90, 45);

        profile = new JLabel();
        profile.setIcon(new ImageIcon("user3.png"));
        profile.setBounds(15, 115, 90, 45);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/info", "root", "deepak");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Name FROM management WHERE ID = '" + ID + "'");
            rs.next();
            pn = rs.getString("Name");
        } catch (Exception E) {
            E.printStackTrace();
        }

        profileName = new JLabel(pn + " (General User)");
        profileName.setBounds(70, 115, 400, 45);
        profileName.setFont(new Font(" ", Font.PLAIN, 18));
        profileName.setForeground(new Color(0xC5C6C7));

        copy = new JLabel("© Deepak 2021, All rights reserved.");
        copy.setBounds(120, 380, 350, 71);
        copy.setForeground(new Color(0x7a807c));

        display = new JButton("DISPLAY");
        display.setFont(new Font(" ", Font.PLAIN, 15));
        display.setBorder(BorderFactory.createLineBorder(new Color(0x66fcf1)));
        display.setForeground(new Color(0x45A29E));
        display.setBackground(new Color(0x1f2833));
        display.addActionListener(this);
        display.setFocusable(false);
        display.setBounds(70, 180, 70, 30);

        edit = new JButton("EDIT");
        edit.setFont(new Font(" ", Font.PLAIN, 15));
        edit.setBorder(BorderFactory.createLineBorder(new Color(0x66fcf1)));
        edit.setForeground(new Color(0x45A29E));
        edit.setBackground(new Color(0x1f2833));
        edit.addActionListener(this);
        edit.setFocusable(false);
        edit.setBounds(70, 230, 70, 30);

        delete = new JButton("DELETE");
        delete.setFont(new Font(" ", Font.PLAIN, 15));
        delete.setBorder(BorderFactory.createLineBorder(new Color(0x66fcf1)));
        delete.setForeground(new Color(0x45A29E));
        delete.setBackground(new Color(0x1f2833));
        delete.addActionListener(this);
        delete.setFocusable(false);
        delete.setBounds(70, 280, 70, 30);

        editmsg = new JLabel("Only users of Admin Type can edit their data");
        editmsg.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        editmsg.setForeground(new Color(0xC5C6C7));

        upgrade = new JLabel("Want to upgrade to Admin");
        upgrade.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        upgrade.setForeground(new Color(0xC5C6C7));

        upgradeBtn = new JButton("UPGRADE");
        upgradeBtn.setFont(new Font(" ", Font.PLAIN, 15));
        upgradeBtn.setBorder(BorderFactory.createLineBorder(new Color(0x66fcf1)));
        upgradeBtn.setForeground(new Color(0x45A29E));
        upgradeBtn.setBackground(new Color(0x1f2833));
        upgradeBtn.addActionListener(this);
        upgradeBtn.setFocusable(false);

        this.add(back);
        this.add(exit);
        this.add(display);
        this.add(profile);
        this.add(editmsg);
        this.add(delete);
        this.add(upgrade);
        this.add(upgradeBtn);
        this.add(profileName);
        this.add(edit);
        this.add(mm);
        this.add(copy);

        this.setUndecorated(true);
        this.setSize(448, 448);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x1f2833));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            try {
                String url = "jdbc:mysql://127.0.0.1:3306/info";
                String username = "root";
                String password = "deepak";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);
                Statement stm = con.createStatement();
                String sql = "DELETE FROM management WHERE id='" + ID + "';";
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "User Deleted !!!");

                this.setVisible(false);
                new WelcomeScreen();
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
        if (e.getSource() == display) {
            this.setVisible(false);
            new generalDisplay(ID);
        }
        if (e.getSource() == exit)
            System.exit(0);

        if (e.getSource() == back) {
            this.setVisible(false);
            new LogIn();
        }
        if (e.getSource() == edit) {
            editmsg.setBounds(70, 310, 400, 30);
            upgrade.setBounds(70, 335, 400, 30);
            upgradeBtn.setBounds(70, 360, 80, 30);
        }
        if (e.getSource() == upgradeBtn) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/info", "root", "deepak");
                Statement stm = con.createStatement();
                stm.executeUpdate("UPDATE management SET UserType = 'Administrator' WHERE ID = '" + ID + "';");
                this.setVisible(false);
                new LogIn();
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
    }
}

class generalDisplay extends JFrame implements ActionListener {
    JButton back, exit;
    String ID;
    ResultSet rs;
    Statement stm;
    Connection con;
    JLabel labelID, labelNAME, labelPASS, labelUSERTYPE, labelOCCUPATION, labelDOB, labelFAMILY, labelSTATUS, display,
            copy;

    generalDisplay(String id) {
        ID = id;

        display = new JLabel("User Details");
        display.setBounds(55, 45, 450, 71);
        display.setFont(new Font("Cooper Black", Font.PLAIN, 50));
        display.setForeground(new Color(0x45A29E));

        exit = new JButton("EXIT");
        exit.setFont(new Font(" ", Font.PLAIN, 15));
        exit.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        exit.setForeground(new Color(0x45A29E));
        exit.setBackground(new Color(0x1f2833));
        exit.addActionListener(this);
        exit.setFocusable(false);
        exit.setBounds(385, 5, 45, 45);

        back = new JButton("< BACK");
        back.setFont(new Font(" ", Font.PLAIN, 15));
        back.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        back.setForeground(new Color(0x45A29E));
        back.setBackground(new Color(0x1f2833));
        back.addActionListener(this);
        back.setFocusable(false);
        back.setBounds(15, 5, 90, 45);

        labelID = new JLabel();
        labelID.setBounds(65, 100, 200, 30);
        labelID.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelID.setForeground(new Color(0xC5C6C7));

        labelNAME = new JLabel();
        labelNAME.setBounds(65, 125, 200, 30);
        labelNAME.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelNAME.setForeground(new Color(0xC5C6C7));

        labelPASS = new JLabel();
        labelPASS.setBounds(65, 150, 200, 30);
        labelPASS.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelPASS.setForeground(new Color(0xC5C6C7));

        labelUSERTYPE = new JLabel();
        labelUSERTYPE.setBounds(65, 175, 200, 30);
        labelUSERTYPE.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelUSERTYPE.setForeground(new Color(0xC5C6C7));

        labelOCCUPATION = new JLabel();
        labelOCCUPATION.setBounds(65, 200, 200, 30);
        labelOCCUPATION.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelOCCUPATION.setForeground(new Color(0xC5C6C7));

        labelDOB = new JLabel();
        labelDOB.setBounds(65, 225, 200, 30);
        labelDOB.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelDOB.setForeground(new Color(0xC5C6C7));

        labelFAMILY = new JLabel();
        labelFAMILY.setBounds(65, 250, 200, 30);
        labelFAMILY.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelFAMILY.setForeground(new Color(0xC5C6C7));

        labelSTATUS = new JLabel();
        labelSTATUS.setBounds(65, 275, 200, 30);
        labelSTATUS.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelSTATUS.setForeground(new Color(0xC5C6C7));

        copy = new JLabel("© Deepak 2021, All rights reserved.");
        copy.setBounds(120, 380, 350, 71);
        copy.setForeground(new Color(0x7a807c));

        this.add(exit);
        this.add(back);
        this.add(display);
        this.add(labelID);
        this.add(labelNAME);
        this.add(labelPASS);
        this.add(labelUSERTYPE);
        this.add(labelOCCUPATION);
        this.add(labelDOB);
        this.add(labelFAMILY);
        this.add(labelSTATUS);
        this.add(copy);

        this.setUndecorated(true);
        this.setSize(448, 448);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x1f2833));
        this.setVisible(true);

        try {
            labelID.setText("UserID = " + ID);
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
            e1.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.setVisible(false);
            new GeneralMainScreen(ID);
        }
        if (e.getSource() == exit)
            System.exit(0);
    }
}

class AdminMainScreen extends JFrame implements ActionListener {
    JButton edit, display, back, delete, exit;
    String ID;
    JLabel mm, profile, profileName, copy;
    String pn;

    AdminMainScreen(String id) {
        ID = id;

        mm = new JLabel("Municipal Management");
        mm.setBounds(15, 50, 450, 71);
        mm.setFont(new Font("Cooper Black", Font.PLAIN, 35));
        mm.setForeground(new Color(0x45A29E));

        exit = new JButton("EXIT");
        exit.setFont(new Font(" ", Font.PLAIN, 15));
        exit.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        exit.setForeground(new Color(0x45A29E));
        exit.setBackground(new Color(0x1f2833));
        exit.addActionListener(this);
        exit.setFocusable(false);
        exit.setBounds(385, 5, 45, 45);

        back = new JButton("< BACK");
        back.setFont(new Font(" ", Font.PLAIN, 15));
        back.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        back.setForeground(new Color(0x45A29E));
        back.setBackground(new Color(0x1f2833));
        back.addActionListener(this);
        back.setFocusable(false);
        back.setBounds(15, 5, 90, 45);

        profile = new JLabel();
        profile.setIcon(new ImageIcon("user3.png"));
        profile.setBounds(15, 115, 90, 45);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/info", "root", "deepak");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Name FROM management WHERE ID = '" + ID + "'");
            rs.next();
            pn = rs.getString("Name");
        } catch (Exception E) {
            E.printStackTrace();
        }

        profileName = new JLabel(pn + " (Admin User)");
        profileName.setBounds(70, 115, 400, 45);
        profileName.setFont(new Font(" ", Font.PLAIN, 18));
        profileName.setForeground(new Color(0xC5C6C7));

        copy = new JLabel("© Deepak 2021, All rights reserved.");
        copy.setBounds(120, 380, 350, 71);
        copy.setForeground(new Color(0x7a807c));

        display = new JButton("DISPLAY");
        display.setFont(new Font(" ", Font.PLAIN, 15));
        display.setBorder(BorderFactory.createLineBorder(new Color(0x66fcf1)));
        display.setForeground(new Color(0x45A29E));
        display.setBackground(new Color(0x1f2833));
        display.addActionListener(this);
        display.setFocusable(false);
        display.setBounds(70, 180, 70, 30);

        edit = new JButton("EDIT");
        edit.setFont(new Font(" ", Font.PLAIN, 15));
        edit.setBorder(BorderFactory.createLineBorder(new Color(0x66fcf1)));
        edit.setForeground(new Color(0x45A29E));
        edit.setBackground(new Color(0x1f2833));
        edit.addActionListener(this);
        edit.setFocusable(false);
        edit.setBounds(70, 230, 70, 30);

        delete = new JButton("DELETE");
        delete.setFont(new Font(" ", Font.PLAIN, 15));
        delete.setBorder(BorderFactory.createLineBorder(new Color(0x66fcf1)));
        delete.setForeground(new Color(0x45A29E));
        delete.setBackground(new Color(0x1f2833));
        delete.addActionListener(this);
        delete.setFocusable(false);
        delete.setBounds(70, 280, 70, 30);

        this.add(mm);
        this.add(exit);
        this.add(profile);
        this.add(profileName);
        this.add(copy);
        this.add(delete);
        this.add(edit);
        this.add(display);
        this.add(back);

        this.setUndecorated(true);
        this.setSize(448, 448);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x1f2833));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit)
            System.exit(0);

        if (e.getSource() == display) {
            this.setVisible(false);
            new adminDisplay(ID);
        }
        if (e.getSource() == edit) {
            this.setVisible(false);
            new adminEdit(ID);
        }
        if (e.getSource() == back) {
            this.setVisible(false);
            new LogIn();
        }
        if (e.getSource() == delete) {
            try {
                String url = "jdbc:mysql://127.0.0.1:3306/info";
                String username = "root";
                String password = "deepak";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);
                Statement stm = con.createStatement();
                String sql = "DELETE FROM management WHERE id='" + ID + "';";
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "User Deleted !!!");

                this.setVisible(false);
                new WelcomeScreen();
            } catch (Exception E) {
                System.out.println(E);
            }
        }
    }
}

class adminEdit extends JFrame implements ActionListener {
    String id;
    JTextField tf1, tf2, tf3, tf4;
    JLabel l1, l2, l3, l4, dedit, copy;
    JButton save, back, exit;
    JSeparator line1, line2, line3, line4;

    adminEdit(String ID) {
        id = ID;

        dedit = new JLabel("Data Edit");
        dedit.setBounds(55, 45, 450, 51);
        dedit.setFont(new Font("Cooper Black", Font.PLAIN, 60));
        dedit.setForeground(new Color(0x45A29E));

        exit = new JButton("EXIT");
        exit.setFont(new Font(" ", Font.PLAIN, 15));
        exit.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        exit.setForeground(new Color(0x45A29E));
        exit.setBackground(new Color(0x1f2833));
        exit.addActionListener(this);
        exit.setFocusable(false);
        exit.setBounds(385, 5, 45, 45);

        back = new JButton("< BACK");
        back.setFont(new Font(" ", Font.PLAIN, 15));
        back.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        back.setForeground(new Color(0x45A29E));
        back.setBackground(new Color(0x1f2833));
        back.addActionListener(this);
        back.setFocusable(false);
        back.setBounds(15, 5, 90, 45);

        l1 = new JLabel("Occupation");
        l1.setBounds(55, 95, 200, 30);
        l1.setFont(new Font("Cooper Black", Font.PLAIN, 13));
        l1.setForeground(new Color(0x45A29E));

        tf1 = new JTextField();
        tf1.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        tf1.setBackground(new Color(0x1f2833));
        tf1.setForeground(new Color(0xC5C6C7));
        tf1.setBounds(55, 120, 200, 30);

        line1 = new JSeparator();
        line1.setOrientation(SwingConstants.HORIZONTAL);
        line1.setBounds(55, 150, 200, 30);
        line1.setBackground(new Color(0xC5C6C7));
        line1.setForeground(null);

        l2 = new JLabel("Date Of Birth");
        l2.setBounds(55, 155, 200, 30);
        l2.setFont(new Font("Cooper Black", Font.PLAIN, 13));
        l2.setForeground(new Color(0x45A29E));

        tf2 = new JTextField();
        tf2.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        tf2.setBackground(new Color(0x1f2833));
        tf2.setForeground(new Color(0xC5C6C7));
        tf2.setBounds(55, 180, 200, 30);

        line2 = new JSeparator();
        line2.setOrientation(SwingConstants.HORIZONTAL);
        line2.setBounds(55, 210, 200, 30);
        line2.setBackground(new Color(0xC5C6C7));
        line2.setForeground(null);

        l3 = new JLabel("Family Type ");
        l3.setBounds(55, 215, 200, 30);
        l3.setFont(new Font("Cooper Black", Font.PLAIN, 13));
        l3.setForeground(new Color(0x45A29E));

        tf3 = new JTextField();
        tf3.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        tf3.setBackground(new Color(0x1f2833));
        tf3.setForeground(new Color(0xC5C6C7));
        tf3.setBounds(55, 240, 200, 30);

        line3 = new JSeparator();
        line3.setOrientation(SwingConstants.HORIZONTAL);
        line3.setBounds(55, 270, 200, 30);
        line3.setBackground(new Color(0xC5C6C7));
        line3.setForeground(null);

        l4 = new JLabel("Status");
        l4.setBounds(55, 275, 200, 30);
        l4.setFont(new Font("Cooper Black", Font.PLAIN, 13));
        l4.setForeground(new Color(0x45A29E));

        tf4 = new JTextField();
        tf4.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        tf4.setBackground(new Color(0x1f2833));
        tf4.setForeground(new Color(0xC5C6C7));
        tf4.setBounds(55, 300, 200, 30);

        line4 = new JSeparator();
        line4.setOrientation(SwingConstants.HORIZONTAL);
        line4.setBounds(55, 330, 200, 30);
        line4.setBackground(new Color(0xC5C6C7));
        line4.setForeground(null);

        save = new JButton("Save");
        save.setFont(new Font(" ", Font.PLAIN, 15));
        save.setBorder(BorderFactory.createLineBorder(new Color(0x66fcf1)));
        save.setForeground(new Color(0x45A29E));
        save.setBackground(new Color(0x1f2833));
        save.addActionListener(this);
        save.setFocusable(false);
        save.setBounds(55, 350, 70, 30);

        copy = new JLabel("© Deepak 2021, All rights reserved.");
        copy.setBounds(120, 380, 350, 71);
        copy.setForeground(new Color(0x7a807c));

        this.add(back);
        this.add(exit);
        this.add(tf1);
        this.add(l1);
        this.add(line1);
        this.add(l2);
        this.add(tf2);
        this.add(line2);
        this.add(l3);
        this.add(tf3);
        this.add(line3);
        this.add(tf4);
        this.add(l4);
        this.add(line4);
        this.add(save);
        this.add(dedit);
        this.add(copy);

        this.setUndecorated(true);
        this.setSize(448, 448);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x1f2833));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit)
            System.exit(0);

        if (e.getSource() == save) {
            try {

                String url = "jdbc:mysql://127.0.0.1:3306/info";
                String username = "root";
                String password = "deepak";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);
                Statement stm = con.createStatement();

                String sql = "UPDATE management SET Occupation = '" + tf1.getText() + "' , DOB='" + tf2.getText()
                        + "' , FamilyType='" + tf3.getText() + "' , Status='" + tf4.getText() + "'where ID='" + id
                        + "';";
                stm.executeUpdate(sql);

                this.setVisible(false);
                new AdminMainScreen(id);
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
        if (e.getSource() == back) {
            this.setVisible(false);
            new AdminMainScreen(id);
        }
    }
}

class adminDisplay extends JFrame implements ActionListener {
    JButton back, export, exit;
    String ID;
    ResultSet rs;
    Statement stm;
    Connection con;
    JLabel labelID, labelNAME, labelPASS, labelUSERTYPE, labelOCCUPATION, labelDOB, labelFAMILY, labelSTATUS, display,
            copy;

    adminDisplay(String id) {
        ID = id;

        display = new JLabel("User Details");
        display.setBounds(55, 45, 450, 71);
        display.setFont(new Font("Cooper Black", Font.PLAIN, 50));
        display.setForeground(new Color(0x45A29E));

        exit = new JButton("EXIT");
        exit.setFont(new Font(" ", Font.PLAIN, 15));
        exit.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        exit.setForeground(new Color(0x45A29E));
        exit.setBackground(new Color(0x1f2833));
        exit.addActionListener(this);
        exit.setFocusable(false);
        exit.setBounds(385, 5, 45, 45);

        back = new JButton("< BACK");
        back.setFont(new Font(" ", Font.PLAIN, 15));
        back.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        back.setForeground(new Color(0x45A29E));
        back.setBackground(new Color(0x1f2833));
        back.addActionListener(this);
        back.setFocusable(false);
        back.setBounds(15, 5, 90, 45);

        labelID = new JLabel();
        labelID.setBounds(65, 100, 200, 30);
        labelID.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelID.setForeground(new Color(0xC5C6C7));

        labelNAME = new JLabel();
        labelNAME.setBounds(65, 125, 200, 30);
        labelNAME.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelNAME.setForeground(new Color(0xC5C6C7));

        labelPASS = new JLabel();
        labelPASS.setBounds(65, 150, 200, 30);
        labelPASS.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelPASS.setForeground(new Color(0xC5C6C7));

        labelUSERTYPE = new JLabel();
        labelUSERTYPE.setBounds(65, 175, 200, 30);
        labelUSERTYPE.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelUSERTYPE.setForeground(new Color(0xC5C6C7));

        labelOCCUPATION = new JLabel();
        labelOCCUPATION.setBounds(65, 200, 200, 30);
        labelOCCUPATION.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelOCCUPATION.setForeground(new Color(0xC5C6C7));

        labelDOB = new JLabel();
        labelDOB.setBounds(65, 225, 200, 30);
        labelDOB.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelDOB.setForeground(new Color(0xC5C6C7));

        labelFAMILY = new JLabel();
        labelFAMILY.setBounds(65, 250, 200, 30);
        labelFAMILY.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelFAMILY.setForeground(new Color(0xC5C6C7));

        labelSTATUS = new JLabel();
        labelSTATUS.setBounds(65, 275, 200, 30);
        labelSTATUS.setFont(new Font("Cooper Black", Font.PLAIN, 12));
        labelSTATUS.setForeground(new Color(0xC5C6C7));

        copy = new JLabel("© Deepak 2021, All rights reserved.");
        copy.setBounds(120, 380, 350, 71);
        copy.setForeground(new Color(0x7a807c));

        export = new JButton("EXPORT");
        export.setFont(new Font(" ", Font.PLAIN, 15));
        export.setBorder(BorderFactory.createLineBorder(new Color(0x66fcf1)));
        export.setForeground(new Color(0x45A29E));
        export.setBackground(new Color(0x1f2833));
        export.addActionListener(this);
        export.setFocusable(false);
        export.setBounds(65, 310, 70, 30);

        this.add(export);
        this.add(back);
        this.add(display);
        this.add(copy);
        this.add(exit);
        this.add(labelID);
        this.add(labelNAME);
        this.add(labelPASS);
        this.add(labelUSERTYPE);
        this.add(labelOCCUPATION);
        this.add(labelDOB);
        this.add(labelFAMILY);
        this.add(labelSTATUS);

        this.setUndecorated(true);
        this.setSize(448, 448);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x1f2833));
        this.setVisible(true);

        try {
            labelID.setText("UserID = " + ID);
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
            e1.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit)
            System.exit(0);
        if (e.getSource() == back) {
            this.setVisible(false);
            new AdminMainScreen(ID);
        }
        if (e.getSource() == export) {
            this.setVisible(false);
            new AdminExport(ID);
        }
    }
}

class AdminExport extends JFrame implements ActionListener {

    JButton export, back, exit;
    JTable dataTable;
    JScrollPane tablePane;
    JLabel table, copy;
    String ID;

    AdminExport(String id) {
        ID = id;

        table = new JLabel("Table Details");
        table.setBounds(45, 45, 450, 71);
        table.setFont(new Font("Cooper Black", Font.PLAIN, 50));
        table.setForeground(new Color(0x45A29E));

        exit = new JButton("EXIT");
        exit.setFont(new Font(" ", Font.PLAIN, 15));
        exit.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        exit.setForeground(new Color(0x45A29E));
        exit.setBackground(new Color(0x1f2833));
        exit.addActionListener(this);
        exit.setFocusable(false);
        exit.setBounds(630, 10, 90, 45);

        back = new JButton("< BACK");
        back.setFont(new Font(" ", Font.PLAIN, 15));
        back.setBorder(BorderFactory.createLineBorder(new Color(0x1f2833)));
        back.setForeground(new Color(0x45A29E));
        back.setBackground(new Color(0x1f2833));
        back.addActionListener(this);
        back.setFocusable(false);
        back.setBounds(15, 10, 90, 45);

        copy = new JLabel("© Deepak 2021, All rights reserved.");
        copy.setBounds(275, 530, 350, 71);
        copy.setForeground(new Color(0x7a807c));

        export = new JButton("EXPORT");
        export.setFont(new Font(" ", Font.PLAIN, 15));
        export.setBorder(BorderFactory.createLineBorder(new Color(0x66fcf1)));
        export.setForeground(new Color(0x45A29E));
        export.setBackground(new Color(0x1f2833));
        export.addActionListener(this);
        export.setFocusable(false);
        export.setBounds(45, 525, 70, 30);

        dataTable = new JTable();

        tablePane = new JScrollPane();
        tablePane.setBounds(45, 110, 650, 400);
        tablePane.setViewportView(dataTable);

        this.add(export);
        this.add(tablePane);
        this.add(table);
        this.add(back);
        this.add(exit);
        this.add(copy);

        this.setUndecorated(true);
        this.setSize(740, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x1f2833));
        this.setVisible(true);

        DefaultTableModel model = new DefaultTableModel(
                new String[] { "ID", "Name", "User Type", "Occupation", "Date Of Birth", "Family Type", "Status" }, 0);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/info", "root", "deepak");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM management;");

            while (rs.next()) {
                String ID = rs.getString("ID");
                String Name = rs.getString("Name");
                String UserType = rs.getString("UserType");
                String Occupation = rs.getString("Occupation");
                String dob = rs.getString("DOB");
                String ft = rs.getString("FamilyType");
                String status = rs.getString("Status");
                model.addRow(new Object[] { ID, Name, UserType, Occupation, dob, ft, status });
            }
            dataTable.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.setVisible(false);
            new adminDisplay(ID);
        }
        if (e.getSource() == exit)
            System.exit(0);

        if (e.getSource() == export) {
            try {

                File myObj = new File("D:\\Report.txt");
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/info", "root", "deepak");
                Statement stm = con.createStatement();
                String sql = "SELECT * INTO OUTFILE 'D:\\Report.txt' FROM management;";
                stm.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "File Exported Successfully !!!");

            } catch (Exception E) {
                E.printStackTrace();
            }
        }
    }
}

class MunicipalManagement {
    public static void main(String[] args) {
        new LoadingScreen();
    }
}
