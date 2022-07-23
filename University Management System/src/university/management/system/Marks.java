package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener{

   JButton b1;
   
   Marks(String s){
       setSize(500,600);
       setLocation(500,100);
       setLayout(null);
       
       getContentPane().setBackground(Color.WHITE);
       
       JLabel college = new JLabel("Delhi Technical Univeristy");
       college.setFont(new Font("Tahoma", Font.BOLD, 20));
       college.setBounds(100, 10, 500, 22);
       add(college);
       
       JLabel heading = new JLabel("Result of Examination 2022");
       heading.setFont(new Font("Tahoma", Font.BOLD, 18));
       heading.setBounds(100, 50, 500, 20);
       add(heading);
       
       JLabel rollno = new JLabel("Roll Number: " + s);
       rollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
       rollno.setBounds(60, 100, 500, 20);
       add(rollno);
       
       JLabel semester = new JLabel();
       semester.setFont(new Font("Tahoma", Font.PLAIN, 18));
       semester.setBounds(60, 130, 500, 20);
       add(semester);
       
       JLabel subject1 = new JLabel();
       subject1.setFont(new Font("Tahoma", Font.PLAIN, 18));
       subject1.setBounds(100, 200, 500, 20);
       add(subject1);
       
       JLabel subject2 = new JLabel();
       subject2.setFont(new Font("Tahoma", Font.PLAIN, 18));
       subject2.setBounds(100, 230, 500, 20);
       add(subject2);
       
       JLabel subject3 = new JLabel();
       subject3.setFont(new Font("Tahoma", Font.PLAIN, 18));
       subject3.setBounds(100, 260, 500, 20);
       add(subject3);
       
       JLabel subject4 = new JLabel();
       subject4.setFont(new Font("Tahoma", Font.PLAIN, 18));
       subject4.setBounds(100, 290, 500, 20);
       add(subject4);
       
       JLabel subject5 = new JLabel();
       subject5.setFont(new Font("Tahoma", Font.PLAIN, 18));
       subject5.setBounds(100, 320, 500, 20);
       add(subject5);
       
       try{
           conn c = new conn();
           
           ResultSet rs1 = c.s.executeQuery("select * from subject where rollno='"+s+"'");
           if(rs1.next()){
               subject1.setText(rs1.getString("subject1"));
               subject2.setText(rs1.getString("subject2"));
               subject3.setText(rs1.getString("subject3"));
               subject4.setText(rs1.getString("subject4"));
               subject5.setText(rs1.getString("subject5"));
           }
           
           ResultSet rs2 = c.s.executeQuery("select * from marks where rollno='"+s+"'");
           
           if(rs2.next()){
               subject1.setText(subject1.getText() + "----------------------"+rs2.getString("marks1"));
               subject2.setText(subject2.getText() + "----------------------"+rs2.getString("marks2"));
               subject3.setText(subject3.getText() + "----------------------"+rs2.getString("marks3"));
               subject4.setText(subject4.getText() + "----------------------"+rs2.getString("marks4"));
               subject5.setText(subject5.getText() + "----------------------"+rs2.getString("marks5"));
               semester.setText("Semester: " + rs2.getString("semester"));
           }
         
       }catch(Exception e){
           e.printStackTrace();
       }
       
        b1 = new JButton("Back");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(250, 500, 120, 30);
        b1.addActionListener(this);
        add(b1);

       
       setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae) {
       setVisible(false);
   }
   
   public static void main(String[] args){
       new Marks("15332971");
   }
}