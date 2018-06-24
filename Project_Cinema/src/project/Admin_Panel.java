package project;

import jdk.nashorn.internal.ir.LiteralNode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Admin_Panel extends JFrame {
    List<Session> sessions = new ArrayList<>();
    private JButton addSession = new JButton("add Session");
    private JLabel name = new JLabel("admin");
    private JLabel nameFilm = new JLabel("name");
    private JTextField nameFilm1 = new JTextField();
    private JLabel hall = new JLabel("hall");
    private JTextField hall1 = new JTextField();
    private JLabel date = new JLabel("date");
    private JTextField date1 = new JTextField();

    public Admin_Panel(){
        super("Cinema control");
        setSize(1024 , 720);

        Container container = getContentPane();
        container.setLayout(new GridLayout(15,10));
        container.add(name);
        container.add(nameFilm);
        container.add(nameFilm1);
        container.add(date);
        container.add(date1);
        container.add(hall);
        container.add(hall1);
        ButtonGroup bg = new ButtonGroup();
        bg.add(addSession);
        container.add(addSession);

        addSession.addActionListener((ev) -> {
               
        });

    }
}
