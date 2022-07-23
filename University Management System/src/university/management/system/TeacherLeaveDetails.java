package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener{

    JTable table;
    Choice cemployeeId;
    JButton search, print, add, update, back;
    
    TeacherLeaveDetails() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Employee id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);
        
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()) {
                cemployeeId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        back = new JButton("Back");
        back.setBounds(220, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from teacher where rollno = '"+cemployeeId.getSelectedItem()+"'";
            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}
