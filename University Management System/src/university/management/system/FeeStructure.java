package university.management.system;

import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class FeeStructure extends JFrame{
    
    JTable table;
    
    public FeeStructure(){
        
        setSize(1000,700);
        setLocation(250,50);
        setLayout(null);
        
        JLabel i1 = new JLabel("Fee Structure");
        i1.setFont(new Font("serif",Font.BOLD, 30));
        i1.setBounds(50,10,400,30);
        add(i1);
        
        table = new JTable();
        
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 60, 1000, 700);
        add(jsp);
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new FeeStructure().setVisible(true);
    }
}
