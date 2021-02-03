import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

public class SignUp extends JFrame {

    JTextField tf1,tf2,tf3,tf4;
    JLabel l1,l2,l3,l4,l5,signUp;
    JPasswordField pf;
    ImageIcon sign;
    JComboBox cb;
    String user[] = {"General","Administrator"};
    SignUp() {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setTitle("Municipal Management System");
        signUp = new JLabel("Sign Up :");
        //sign = new ImageIcon("letter.png").getImage().getScaledInstance(20, 20, signUp.SCALE_DEFAULT)));
        //sign = new ImageIcon(new ImageIcon("letter.png").getImage().getScaledInstance(20, 20, signUp));
        signUp.setIcon(sign);
        signUp.setBounds(65,50, 200,30);
        signUp.setForeground(new Color(23, 212, 212));

        l1 = new JLabel("First Name");
        l1.setBounds(65,75, 200,30); 
        l1.setForeground(new Color(23, 212, 212));
        tf1 = new JTextField();
        tf1.setBackground(new Color(138, 222, 218));
        tf1.setBounds(65,100, 200,30);
        tf1.setPreferredSize(new DimensionUIResource(450, 50));
        
        l2 = new JLabel("Second Name");
        l2.setBounds(65,135, 200,30); 
        l2.setForeground(new Color(23, 212, 212));
        tf2 = new JTextField();
        tf2.setBounds(65,160, 200,30);
        tf2.setPreferredSize(new DimensionUIResource(450, 50));
        
        l3 = new JLabel("E-Mail");
        l3.setBounds(65,195, 200,30); 
        l3.setForeground(new Color(23, 212, 212));
        tf3 = new JTextField();
        tf3.setBounds(65,220, 200,30);
        tf3.setPreferredSize(new DimensionUIResource(450, 50));
        
        l4 = new JLabel("Password");
        l4.setBounds(65,255, 200,30); 
        l4.setForeground(new Color(23, 212, 212));
        pf = new JPasswordField();
        pf.setBounds(65,280, 200,30);
        pf.setPreferredSize(new DimensionUIResource(450, 50));

        l5 = new JLabel("Select type of user");
        l5.setBounds(65,315, 200,30);
        l5.setForeground(new Color(23, 212, 212));
        cb = new JComboBox(user);
        cb.setBounds(65,340, 80,30);
        
        this.add(signUp);
        this.add(l1); 
        this.add(l2);
        this.add(l3);
        this.add(l4);
        this.add(l5);
        this.add(tf1);
        this.add(tf2);
        this.add(tf3);
        this.add(pf);
        this.add(cb);

        this.setLayout(null);
        this.setResizable(true);
        this.setSize(450, 450);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(3, 17, 38));
        ImageIcon icon = new ImageIcon("icon.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.pack();
    }
}