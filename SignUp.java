import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

public class SignUp extends JFrame {

    JTextField tf1,tf2,tf3,tf4;
    JLabel l1,l2,l3,l4;
    SignUp() {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setTitle("Municipal Management System");
        // this.setLayout();
        l1 = new JLabel("First Name");
        l1.setBounds(50,80, 200,30); 
        l1.setForeground(new Color(255, 255, 255));
        tf1 = new JTextField();
        tf1.setBounds(50,100, 200,30);
        tf1.setPreferredSize(new DimensionUIResource(450, 50));

        tf2 = new JTextField();
        tf2.setBounds(50,175, 200,30);
        tf2.setPreferredSize(new DimensionUIResource(450, 50));

        tf3 = new JTextField();
        tf3.setBounds(50,250, 200,30);
        tf3.setPreferredSize(new DimensionUIResource(450, 50));

        tf4 = new JTextField();
        tf4.setBounds(50,325, 200,30);
        tf4.setPreferredSize(new DimensionUIResource(450, 50));
        
        this.add(l1);   
        this.add(tf1);
        this.add(tf2);
        this.add(tf3);
        this.add(tf4);
        this.setLayout(null);
        // tf1=new JTextField("textfield 1");
        // this..add(tf1);

        // tf2=new JTextField("textfield 2");
        // tf2.setBounds(50,100, 200,30);
        // this..add(tf2);

        // tf3=new JTextField("textfield 3");
        // tf3.setBounds(50,100, 200,30);
        // this..add(tf3);

        // tf4=new JTextField("textfield 4");
        // tf4.setBounds(50,100, 200,30);
        // this..add(tf4);

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