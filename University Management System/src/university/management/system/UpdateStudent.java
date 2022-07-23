/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.management.system;


import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class UpdateStudent extends JFrame implements ActionListener{

    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,lab,lab1,lab2;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    JButton b,b1,b2; 
    String id_emp;
    JLabel lblname, lblfname, lbldob, lblx, lblxii, lblaadhar, lblrollno;
    Choice crollno;

    UpdateStudent(){
        setSize(900,650);
        setLocation(350,50);
        setLayout(null);

        id8 = new JLabel("Update Student Details:");
        id8.setBounds(50,10,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,40));
        id8.setForeground(Color.black);
        add(id8);
        
        JLabel l1 = new JLabel("Select Roll Number");
        l1.setBounds(50,100, 200,20);
        l1.setFont(new Font("serif",Font.PLAIN,18));
        add(l1);
        
        crollno = new Choice();
        crollno.setBounds(250,100,200,20);
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


        id1 = new JLabel("Name");
        id1.setBounds(50,170,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        add(id1);

        lblname=new JLabel();
        lblname.setBounds(200,170,150,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);

        id2 = new JLabel("Father's Name");
        id2.setBounds(400,170,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        add(id2);

        lblfname=new JLabel();
        lblfname.setBounds(600,170,150,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        
        id12= new JLabel("Roll No");
        id12.setBounds(50,220,150,30);
        id12.setFont(new Font("serif",Font.BOLD,20));
        add(id12);

        lblrollno=new JLabel();   
        lblrollno.setBounds(200,220,150,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);

        id4= new JLabel("Date of Birth");  
        id4.setBounds(400,220,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        add(id4);

        lbldob=new JLabel();
        lbldob.setBounds(600,220,150,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);

        id5= new JLabel("Address");
        id5.setBounds(50,270,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        add(id5);

        t5=new JTextField();
        t5.setBounds(200,270,150,30);
        add(t5);

        id6= new JLabel("Phone");
        id6.setBounds(400,270,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        add(id6);

        t6=new JTextField();
        t6.setBounds(600,270,150,30);
        add(t6);

        id7= new JLabel("Email Id");
        id7.setBounds(50,320,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        add(id7);

        t7=new JTextField();
        t7.setBounds(200,320,150,30);
        add(t7);

        id9= new JLabel("Class X(%)");
        id9.setBounds(400,320,130,30);
        id9.setFont(new Font("serif",Font.BOLD,20));    
        add(id9);

        lblx=new JLabel();
        lblx.setBounds(600,320,150,30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);

        id10= new JLabel("Class XII(%)");
        id10.setBounds(50,370,130,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        add(id10);

        lblxii=new JLabel();
        lblxii.setBounds(200,370,150,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);


        id11= new JLabel("Aadhar No");
        id11.setBounds(400,370,100,30);
        id11.setFont(new Font("serif",Font.BOLD,20));
        add(id11);

        lblaadhar=new JLabel();
        lblaadhar.setBounds(600,370,150,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);

        lab=new JLabel("Course");
        lab.setBounds(50,420,150,30);
	lab.setFont(new Font("serif",Font.BOLD,20));
        add(lab);
            
        t13=new JTextField();   
        t13.setBounds(200,420,150,30);
        add(t13);
        
        lab2=new JLabel("Branch");
        lab2.setBounds(400,420,150,30);
	lab2.setFont(new Font("serif",Font.BOLD,20));
        add(lab2);
            
        t14=new JTextField();   
        t14.setBounds(600,420,150,30);
        add(t14);
        
        try {
            conn c = new conn();
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblfname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                t5.setText(rs.getString("address"));
                t6.setText(rs.getString("phone"));
                t7.setText(rs.getString("email"));
                lblx.setText(rs.getString("class_x"));
                lblxii.setText(rs.getString("class_xii"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblrollno.setText(rs.getString("rollno"));
                t13.setText(rs.getString("course"));
                t14.setText(rs.getString("branch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    conn c = new conn();
                    String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblfname.setText(rs.getString("fname"));
                        lbldob.setText(rs.getString("dob"));
                        t5.setText(rs.getString("address"));
                        t6.setText(rs.getString("phone"));
                        t7.setText(rs.getString("email"));
                        lblx.setText(rs.getString("class_x"));
                        lblxii.setText(rs.getString("class_xii"));
                        lblaadhar.setText(rs.getString("aadhar"));
                        lblrollno.setText(rs.getString("rollno"));
                        t13.setText(rs.getString("course"));
                        t14.setText(rs.getString("branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,520,150,40);
        b.addActionListener(this);
        add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,520,150,40);
        b1.addActionListener(this);
        add(b1);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){
            try{
                conn con = new conn();
                String str = "update student set address='"+t5.getText()+"',phone='"+t6.getText()+"',email='"+t7.getText()+"',course='"+t13.getText()+"',branch='"+t14.getText()+"' where rollno='"+crollno.getSelectedItem()+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Information updated successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==b1){
            setVisible(false);
        }
    }

    public static void main(String[] arg){
        new UpdateStudent();
    }
}