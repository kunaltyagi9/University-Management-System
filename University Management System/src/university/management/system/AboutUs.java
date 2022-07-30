package university.management.system;

import java.awt.*;
import javax.swing.*;

public class AboutUs extends JFrame{

	private JPanel contentPane;

        public static void main(String[] args) {
            new AboutUs().setVisible(true);			
	}
    
        public AboutUs() {
            
            super("About Us - University Name");
            setBackground(new Color(173, 216, 230));
            setBounds(400, 150, 700, 500);
		
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);

            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/about.jpg"));
            Image i2 = i1.getImage().getScaledInstance(300, 200,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel l1 = new JLabel(i3);
            l1.setBounds(350, 0, 300, 200);
            contentPane.add(l1);


            JLabel l3 = new JLabel("<html>University<br/>Management System</html>");
            l3.setForeground(new Color(0, 250, 154));
            l3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
            l3.setBounds(70, 20, 250, 130);
            contentPane.add(l3);

            JLabel l6 = new JLabel("Developed By : Code for Interview");
            l6.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
            l6.setBounds(70, 220, 600, 35);
            contentPane.add(l6);

            JLabel l7 = new JLabel("Roll Number - ??");
            l7.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            l7.setBounds(70, 280, 600, 34);
            contentPane.add(l7);

            JLabel l8 = new JLabel("Contact : codeforinterview03@gmail.com");
            l8.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            l8.setBounds(70, 320, 600, 34);
            contentPane.add(l8);

            JLabel l9 = new JLabel("Education - B.Tech (Computer Science)");
            l9.setFont(new Font("Trebuchet MS", Font.BOLD , 20));
            l9.setBounds(70, 360, 600, 34);
            contentPane.add(l9);

            JLabel l10 = new JLabel("Phone - +91 9999 999999");
            l10.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
            l10.setBounds(70, 400, 600, 34);
            contentPane.add(l10);
                
                
            contentPane.setBackground(Color.WHITE);
	}
        

}


