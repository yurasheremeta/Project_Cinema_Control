package project;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class User_Panel extends JFrame {
    List<Session> sessions = new ArrayList<>();
    private JLabel name = new JLabel("user");

    private JButton sortByDate = new JButton("output by date");
    private JButton sortByName = new JButton("output by name");
    private JButton output = new JButton("output List");



    public User_Panel(){
        super("Cinema COntrol");
        setSize(600 , 600);

        Container container = getContentPane();
        container.setLayout(new GridLayout(6,2));
        container.add(name);

        ButtonGroup bg = new ButtonGroup();
        bg.add(sortByDate);
        bg.add(sortByName);
        bg.add(output);
        container.add(output);
        container.add(sortByDate);
        container.add(sortByName);


        output.addActionListener((ev) -> {

        });

    }
}
