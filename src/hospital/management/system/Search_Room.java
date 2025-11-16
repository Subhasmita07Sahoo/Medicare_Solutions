package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Search_Room extends JFrame {

    Choice choice;
    JTable table;

    Search_Room(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JLabel For = new JLabel("Search for Room");
        For.setBounds(250,11,186,31);
        For.setForeground(Color.WHITE);
        For.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(For);

        JLabel status = new JLabel("Status :");
        status.setBounds(70,70,80,20);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "Select * from Room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel Roomno = new JLabel("Room Number");
        Roomno.setBounds(3,162,150,20);
        Roomno.setForeground(Color.WHITE);
        Roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Roomno);

        JLabel available = new JLabel("Availability");
        available.setBounds(175,162,150,20);
        available.setForeground(Color.WHITE);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(available);

        JLabel Price = new JLabel("Price");
        Price.setBounds(350,162,150,20);
        Price.setForeground(Color.WHITE);
        Price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Price);

        JLabel Bed = new JLabel("Bed Type");
        Bed.setBounds(525,162,150,20);
        Bed.setForeground(Color.WHITE);
        Bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Bed);

        JButton search = new JButton("Search");
        search.setBounds(200,420,120,25);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(380,420,120,25);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(450,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Search_Room();
    }
}
