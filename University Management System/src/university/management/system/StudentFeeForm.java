package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class StudentFeeForm extends JFrame implements ActionListener{

    JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2,b3;
    Choice c1;
    JLabel lblprice;

    public static void main(String[] args) {
        new StudentFeeForm();
    }

    public StudentFeeForm() {
        setBounds(300, 100, 900, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);
       
        JLabel l1 = new JLabel("Select Roll No");
	l1.setFont(new Font("Tahoma", Font.BOLD, 16));
	l1.setBounds(40, 60, 150, 20);
	add(l1);

	c1 = new Choice();
        c1.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	c1.setBounds(200, 60, 150, 20);
	add(c1);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                c1.add(rs.getString("rollno"));
            }
        }catch(Exception e) { }
        
	JLabel l2 = new JLabel("Name");
	l2.setFont(new Font("Tahoma", Font.BOLD, 16));
	l2.setBounds(40, 100, 150, 20);
	add(l2);

        JLabel lblname = new JLabel();
	lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblname.setBounds(200, 100, 150, 20);
	add(lblname);

	JLabel l3 = new JLabel("Father's Name");
	l3.setFont(new Font("Tahoma", Font.BOLD, 16));
	l3.setBounds(40, 140, 150, 20);
	add(l3);

	JLabel lblfname = new JLabel();
	lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblfname.setBounds(200, 140, 150, 20);
	add(lblfname);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from student where rollno = '"+c1.getSelectedItem()+"'");
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblfname.setText(rs.getString("fname"));
            }
        }catch(Exception e){}
        
        JLabel l7 = new JLabel("Course");
	l7.setFont(new Font("Tahoma", Font.BOLD, 16));
	l7.setBounds(40, 180, 150, 20);
	add(l7);

        String course[] = new String[] { "BTech", "MTech", "MBA", "BBA", "BCA", "BSc", "MSc", "Mcom", "Bcom", "MCA" };
	comboBox_3 = new JComboBox(course);
	comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
	comboBox_3.setBounds(200, 180, 150, 20);
	add(comboBox_3);
        
	JLabel l4 = new JLabel("Branch");
	l4.setFont(new Font("Tahoma", Font.BOLD, 16));
	l4.setBounds(40, 220, 150, 20);
	add(l4);
        
        String courses[] = new String[] { "Mechanical", "CSE", "IT", "Civil", "Automobile", "Electronics", "Other" };
	comboBox = new JComboBox(courses);
	comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
	comboBox.setBounds(200, 220, 150, 20);
	add(comboBox);

        JLabel l5 = new JLabel("Semester");
	l5.setFont(new Font("Tahoma", Font.BOLD, 16));
	l5.setBounds(40, 260, 150, 20);
	add(l5);
        
        String semester[] = new String[] { "Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8" };
	comboBox_2 = new JComboBox(semester);
	comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	comboBox_2.setBounds(200, 260, 150, 20);
	add(comboBox_2);

	JLabel l6 = new JLabel("Total Payable");
	l6.setFont(new Font("Tahoma", Font.BOLD, 16));
	l6.setBounds(40, 300, 150, 20);
	add(l6);
        
        lblprice = new JLabel();
	lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setForeground(Color.RED);
	lblprice.setBounds(200, 300, 150, 20);
	add(lblprice);
        
	b1 = new JButton("Update");
	b1.addActionListener(this);
	b1.setBounds(30, 380, 100, 25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	add(b1);
        
        b2 = new JButton("Pay Fee");
	b2.addActionListener(this);
	b2.setBounds(150, 380, 100, 25);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	add(b2);

	b3 = new JButton("Back");
	b3.addActionListener(this);
	b3.setBounds(270, 380, 120, 25);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
	add(b3);

	setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == b1) {
            String degree = (String) comboBox_3.getSelectedItem();
            String semester = (String) comboBox_2.getSelectedItem();
            try{
                conn con = new conn();
                String query = "select * from fee where course ='"+degree+"'";
                ResultSet rs = con.s.executeQuery(query);
                    
                if (rs.next()) {
                    lblprice.setText(rs.getString(semester));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == b2){
            String rollno = c1.getSelectedItem();
            String degree = (String) comboBox_3.getSelectedItem();
            String branch = (String) comboBox.getSelectedItem();
            String semester = (String) comboBox_2.getSelectedItem();
            String price = lblprice.getText();
            try{
                conn con = new conn();
                String query = "insert into educationFee values('"+rollno+"', '"+degree+"', '"+branch+"', '"+semester+"', '"+price+"')";
                con.s.executeUpdate(query);
		JOptionPane.showMessageDialog(null, "Fees Paid Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == b3){
            setVisible(false);
        }
    }
}

