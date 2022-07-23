package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class ExaminationDetails extends JFrame implements ActionListener{

   private JTable table;
   private JTextField search;
   private JButton b1,b2;

   public ExaminationDetails() {

        setBounds(300, 100, 1000, 475);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("Check Result");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 24));
        l1.setBounds(80, 15, 400, 47);
        add(l1);
        
        search = new JTextField();
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        search.setBounds(80, 90, 200, 30);
        add(search);
        
        b1 = new JButton("Result");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(300, 90, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(440, 90, 120, 30);
        b2.addActionListener(this);
        add(b2);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
               int row = table.getSelectedRow();
               search.setText(table.getModel().getValueAt(row, 9).toString());
            }
        });
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 130, 1000, 310);
        add(scrollPane);
        
        try {
            conn con = new conn();
            String sql = "select * from student";
            ResultSet rs = con.s.executeQuery(sql);

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){ 
            try{
                conn con = new conn();
                new Marks(search.getText()).setVisible(true);
                this.setVisible(false);
            } catch(Exception e){}
        } else if (ae.getSource() == b2) {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new ExaminationDetails();
    }
}