package university.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class EnterMarks extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b1, b2;
    Choice crollno;
    JComboBox csemester;

    EnterMarks(){

        setSize(1000,500);
        setLocation(300,150);
        setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 400, 300);
        add(image);

        l1 = new JLabel("Enter marks of Student");
        l1.setFont(new Font("serif", Font.BOLD, 20));
        l1.setBounds(50,0,500,40);
        add(l1);

        l2 = new JLabel("Select Roll Number");
        l2.setBounds(50,70,150,20);
        add(l2);

        crollno = new Choice();
        crollno.setBounds(200, 70, 150, 20);
        add(crollno);
        
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel l5 = new JLabel("Select Semester");
        l5.setBounds(50,115,150,20);
        add(l5);

        String semester[] = {"1st Semester", "2nd Semester" , "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
        csemester = new JComboBox(semester);
        csemester.setBounds(200, 115, 150, 20);
        add(csemester);

        l3 = new JLabel("Enter Subject");
        l3.setBounds(100,150,200,40);
        add(l3);

        l4 = new JLabel("Enter Marks");
        l4.setBounds(320,150,200,40);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(50,200,200,20);
        add(t2);

        t3 = new JTextField();
        t3.setBounds(250,200,200,20);
        add(t3);

        t4 = new JTextField();
        t4.setBounds(50,230,200,20);
        add(t4);

        t5 = new JTextField();
        t5.setBounds(250,230,200,20);
        add(t5);

        t6 = new JTextField();
        t6.setBounds(50,260,200,20);
        add(t6);

        t7 = new JTextField();
        t7.setBounds(250,260,200,20);
        add(t7);

        t8 = new JTextField();
        t8.setBounds(50,290,200,20);
        add(t8);

        t9 = new JTextField();
        t9.setBounds(250,290,200,20);
        add(t9);

        t10 = new JTextField();
        t10.setBounds(50,320,200,20);
        add(t10);

        t11 = new JTextField();
        t11.setBounds(250,320,200,20);
        add(t11);

        b1 = new JButton("Submit");
        b1.setBounds(70,360,150,25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(280,360,150,25);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == b1) {
            try{
                conn c1 = new conn();

                String s1 = "insert into subject values('"+crollno.getSelectedItem()+"','"+csemester.getSelectedItem()+"', '"+t2.getText()+"','"+t4.getText()+"','"+t6.getText()+"','"+t8.getText()+"','"+t10.getText()+"')";
                String s2 = "insert into marks values('"+crollno.getSelectedItem()+"','"+csemester.getSelectedItem()+"','"+t3.getText()+"','"+t5.getText()+"','"+t7.getText()+"','"+t9.getText()+"','"+t11.getText()+"')";

                c1.s.executeUpdate(s1);
                c1.s.executeUpdate(s2);

                JOptionPane.showMessageDialog(null,"Marks Inserted Successfully");
                this.setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new EnterMarks().setVisible(true);
    }
}