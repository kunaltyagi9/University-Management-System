package university.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener{
    Project(){
        setSize(1540,850);
        
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/third.jpg"));
        Image i3 = ic.getImage().getScaledInstance(1500, 750,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);
        
        JMenuBar mb  = new JMenuBar();
        
        //master
        JMenu master = new JMenu("New Information");
        master.setForeground(Color.BLUE);
        
        JMenuItem m1 = new JMenuItem("New Faculty Information");
        m1.setBackground(Color.WHITE);
        m1.addActionListener(this);
        master.add(m1);
        
        JMenuItem m2 = new JMenuItem("New Student Information");
        m2.setBackground(Color.WHITE);
        m2.addActionListener(this);
        master.add(m2);
        
        //details
        JMenu user = new JMenu("View Details");
        user.setForeground(Color.RED);
        
        JMenuItem u1 = new JMenuItem("View Student Details");
        u1.setBackground(Color.WHITE);
        u1.addActionListener(this);
        user.add(u1);
        
        JMenuItem u2 = new JMenuItem("View Teacher Details");
        u2.setBackground(Color.WHITE);
        u2.addActionListener(this);
        user.add(u2);
        
        //attendance
        JMenu attendance = new JMenu("Apply Leave");
        attendance.setForeground(Color.BLUE);
        
        JMenuItem a1 = new JMenuItem("Student Leave");
        a1.setBackground(Color.WHITE);
        a1.addActionListener(this);
        attendance.add(a1);
        
        JMenuItem a2 = new JMenuItem("Teacher Leave");
        a2.setBackground(Color.WHITE);
        a2.addActionListener(this);
        attendance.add(a2);

        //details
        JMenu attendance_detail = new JMenu("Leave Details");
        attendance_detail.setForeground(Color.RED);
        
        JMenuItem b1 = new JMenuItem("Student Leave Details");
        b1.setBackground(Color.WHITE);
        b1.addActionListener(this);
        attendance_detail.add(b1);
        
        JMenuItem b2 = new JMenuItem("Teacher Leave Details");
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);
        attendance_detail.add(b2);

        //exams
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        
        JMenuItem c1 = new JMenuItem("Examination Details");
        c1.setBackground(Color.WHITE);
        c1.addActionListener(this);
        exam.add(c1);
        
        JMenuItem c2 = new JMenuItem("Enter Marks");
        c2.setBackground(Color.WHITE);
        c2.addActionListener(this);
        exam.add(c2);

        //update
        JMenu report = new JMenu("Update Details");
        report.setForeground(Color.RED);
        
        JMenuItem r1 = new JMenuItem("Update Students Details");
        r1.setBackground(Color.WHITE);
        r1.addActionListener(this);
        report.add(r1);
        
        JMenuItem r2 = new JMenuItem("Update Teachers Details");
        r2.setBackground(Color.WHITE);
        r2.addActionListener(this);
        report.add(r2);
        
        //fee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        
        JMenuItem s1 = new JMenuItem("Fee Structure");
        s1.setBackground(Color.WHITE);
        s1.addActionListener(this);
        fee.add(s1);
        
        JMenuItem s2 = new JMenuItem("Student Fee Form");
        s2.setBackground(Color.WHITE);
        s2.addActionListener(this);
        fee.add(s2);
        
        //utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED); 
        
        JMenuItem ut1 = new JMenuItem("Notepad");
        ut1.setBackground(Color.WHITE);
        ut1.addActionListener(this);
        utility.add(ut1);
        
        JMenuItem ut2 = new JMenuItem("Calculator");
        ut2.setBackground(Color.WHITE);
        ut2.addActionListener(this);
        utility.add(ut2);
        
        JMenuItem ut3 = new JMenuItem("Web Browser");
        ut3.setBackground(Color.WHITE);
        ut3.addActionListener(this);
        utility.add(ut3);
        
        //about
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        
        JMenuItem aboutus = new JMenuItem("About Us");
        aboutus.setBackground(Color.WHITE);
        aboutus.addActionListener(this);
        about.add(aboutus);
        
        //exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        mb.add(master);
        mb.add(user);
        mb.add(attendance);
        mb.add(attendance_detail);
        mb.add(exam);
        mb.add(report);
        mb.add(fee);
        mb.add(utility);
        mb.add(about);
        mb.add(exit);
        
        setJMenuBar(mb);    
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("New Student Information")){
            new AddStudent().setVisible(true);
            
        }else if(msg.equals("New Faculty Information")){
            new AddTeacher().setVisible(true);
            
        }else if(msg.equals("View Student Details")){
            new StudentDetails().setVisible(true);
            
        }else if(msg.equals("View Teacher Details")){
            new TeacherDetails().setVisible(true);
           
        }
        else if(msg.equals("Update Students Details")){
            new UpdateStudent();
           
        }
        else if(msg.equals("Update Teachers Details")){
            new UpdateTeacher();
           
        }
        else if(msg.equals("Fee Structure")){
            new FeeStructure().setVisible(true);
           
        }
        else if(msg.equals("Student Fee Form")){
            new StudentFeeForm().setVisible(true);
           
        }
        else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Web Browser")){
            
            try{
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
            }catch(Exception e){ }
        }else if(msg.equals("Exit")){
            System.exit(0);
        }else if(msg.equals("About Us")){
            new AboutUs().setVisible(true);
        }else if(msg.equals("Student Leave")){
            new StudentLeave().setVisible(true);
        }else if(msg.equals("Teacher Leave")){
            new TeacherLeave().setVisible(true);
        }else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails().setVisible(true);
        }else if(msg.equals("Teacher Leave Details")){
            new TeacherLeaveDetails().setVisible(true);
        }else if(msg.equals("Examination Details")){
            new ExaminationDetails().setVisible(true);
        }else if(msg.equals("Enter Marks")){
            new EnterMarks().setVisible(true);
        }
        
    }
    
    
    public static void main(String[] args){
        new Project().setVisible(true);
    }
    
}
