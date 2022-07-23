package university.management.system;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class StudentLeave extends JFrame implements ActionListener{
    
    JButton b1,b2;
    Choice time, rollnumber;
    JDateChooser date;
    
    StudentLeave(){
        setSize(500,550);
        setLocation(600,100);
        setLayout(null);
        
        JLabel l1 = new JLabel("Apply Leave (Student)");
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        l1.setBounds(40, 50, 200, 30);
        add(l1);
        
        JLabel l2 = new JLabel("Roll Number");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l2.setBounds(60, 100, 200, 20);
        add(l2);
        
        rollnumber = new Choice();
        rollnumber.setBounds(60, 130, 200, 30);
        add(rollnumber);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                rollnumber.add(rs.getString("rollno"));    
            }
      
      
       }catch(Exception e){ }
       
        
        JLabel l3 = new JLabel("Date");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l3.setBounds(60, 180, 200, 20);
        add(l3);
        
        date = new JDateChooser();
        date.setBounds(60, 210, 200, 25);
        add(date);
        
        JLabel l4 = new JLabel("Time");
        l4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l4.setBounds(60, 260, 200, 20);
        add(l4);
        
        time = new Choice();
        time.add("Full Day");
        time.add("Half Day");
        time.setBounds(60, 290, 200, 25);
        add(time);
       
        b1 =new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60, 350, 100, 25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200, 350, 100, 25);
        b2.addActionListener(this);
        add(b2);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == b1) {
            String rollno = rollnumber.getSelectedItem();
            String dateofleave = ((JTextField) date.getDateEditor().getUiComponent()).getText();
            String leavetime = time.getSelectedItem();
            
            String query = "insert into studentleave values('"+rollno+"','"+dateofleave+"','"+leavetime+"')";
       
            try{
                conn c1 = new conn();
                c1.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }    
    public static void main(String s[]){
        new StudentLeave();
    }
}
