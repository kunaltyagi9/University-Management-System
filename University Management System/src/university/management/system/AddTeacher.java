package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

class AddTeacher extends JFrame implements ActionListener{

    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,id16,id17,lab,lab1,lab2;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b,b1,b2,b3;
    JComboBox c1,c2;
    JDateChooser dcdob;
    JLabel lblempId;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    long first = Math.abs(first4);

    AddTeacher(){
        setLayout(null);

        id8 = new JLabel("New Teacher Details");
        id8.setBounds(320,25,500,50);
        id8.setFont(new Font("serif",Font.BOLD,30));
        id8.setForeground(Color.black);
        add(id8);
        
        id1 = new JLabel("Name");
        id1.setBounds(50,150,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        add(id1);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        add(t1);

        id2 = new JLabel("Father's Name");
        id2.setBounds(400,150,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        add(id2);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        add(t2);
        
        id11= new JLabel("Employee id");
        id11.setBounds(50,200,150,30);
        id11.setFont(new Font("serif",Font.BOLD,20));
        add(id11);

        lblempId = new JLabel("101"+first);
        lblempId.setBounds(200,200,150,30);
        lblempId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblempId);

        id4= new JLabel("Date of Birth");  
        id4.setBounds(400,200,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        add(id4);

        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);

        id5= new JLabel("Address");
        id5.setBounds(50,250,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        add(id5);

        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        add(t5);

        id6= new JLabel("Phone");
        id6.setBounds(400,250,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        add(id6);

        t6=new JTextField();
        t6.setBounds(600,250,150,30);
        add(t6);

        id7= new JLabel("Email Id");
        id7.setBounds(50,300,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        add(id7);

        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        add(t7);

        id8= new JLabel("Class X(%)");
        id8.setBounds(400,300,130,30);
        id8.setFont(new Font("serif",Font.BOLD,20));    
        add(id8);

        t8=new JTextField();
        t8.setBounds(600,300,150,30);
        add(t8);

        id9= new JLabel("Class XII(%)");
        id9.setBounds(50,350,130,30);
        id9.setFont(new Font("serif",Font.BOLD,20));
        add(id9);

        t9=new JTextField();
        t9.setBounds(200,350,150,30);
        add(t9);


        id10= new JLabel("Aadhar No");
        id10.setBounds(400,350,100,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        add(id10);

        t10=new JTextField();
        t10.setBounds(600,350,150,30);
        add(t10);

        lab=new JLabel("Education");
        lab.setBounds(50,400,150,30);
	lab.setFont(new Font("serif",Font.BOLD,20));
        add(lab);
            
        String course[] = {"B.Tech","BBA","BCA","Bsc","Msc","MBA","MCA","BA","BCom"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,400,150,30);
        add(c1);
        
        lab2=new JLabel("Department");
        lab2.setBounds(400,400,150,30);
	lab2.setFont(new Font("serif",Font.BOLD,20));
        add(lab2);
        
        String branch[] = {"Computer Science","Electronics","Electrical","Mechanical","Civil"};
        c2 = new JComboBox(branch);
        c2.setBackground(Color.WHITE);
        c2.setBounds(600,400,150,30);
        add(c2);
        
        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,550,150,40);
        add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,550,150,40);
        add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        setSize(900,700);
        setLocation(350,50);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){
        
        String a = t1.getText();
        String bb = t2.getText();
        String d = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
        String e = t5.getText();
        String ff = t6.getText();
        String g = t7.getText();
        String h = t8.getText();
        String i = t9.getText();
        String j = t10.getText();
        String k = (String)c1.getSelectedItem();
        String l = lblempId.getText();
        String m = (String)c2.getSelectedItem();
        
        if(ae.getSource() == b){
            try{
                conn cc = new conn();
                String q = "insert into teacher values('"+a+"','"+bb+"','"+d+"','"+e+"','"+ff+"','"+g+"','"+h+"','"+i+"','"+j+"','"+k+"','"+l+"','"+m+"')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Teacher Details Inserted Successfully");
                setVisible(false);
                
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }else if(ae.getSource() == b1){
            setVisible(false);
        }
    }
    public static void main(String[] arg){
        new AddTeacher();
    }
}