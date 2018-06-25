package project;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class User_Panel extends JFrame {
   // List<Session> sessions = new ArrayList<>();
    private JLabel name = new JLabel("user");

    private JButton sortByDate = new JButton("output by date");
    private JButton sortByName = new JButton("output by name");
    private JButton sortByHall = new JButton("output by hall");
    private JButton output = new JButton("output List");
    private JButton outputFilms = new JButton("output list of films");



    public User_Panel(){
        super("Cinema COntrol");
        setSize(600 , 600);

        Container container = getContentPane();
        container.setLayout(new GridLayout(6,2));
        container.add(name);

        ButtonGroup bg = new ButtonGroup();
        bg.add(sortByDate);
        bg.add(sortByName);
        bg.add(sortByHall);
        bg.add(output);
        bg.add(outputFilms);
        container.add(output);
        container.add(sortByDate);
        container.add(sortByName);
        container.add(outputFilms);
        container.add(sortByHall);


        output.addActionListener((ev) -> {
            StringBuilder sb = new StringBuilder();
            Admin_Panel.sessions.forEach(e -> sb.append(e));
            JOptionPane.showMessageDialog(null , sb.toString() , "Sessions" ,JOptionPane.PLAIN_MESSAGE );
        });
        outputFilms.addActionListener((ev) -> {
            List<String> names2 = Admin_Panel.sessions.stream()
                    .filter(e -> e != null)
                    .map(e -> e.getFilm().getName())
                    .distinct()
                    .collect(Collectors.toList());
            StringBuilder sb = new StringBuilder();
            Admin_Panel.sessions.forEach(e -> sb.append(e.getFilm().getName()));
            JOptionPane.showMessageDialog(null , sb.toString() , "Films" ,JOptionPane.PLAIN_MESSAGE );
            System.out.println(names2);

        });
        sortByName.addActionListener((ev) ->{
            Collections.sort(Admin_Panel.sessions , new ComparatorByName());
            for(Session session: Admin_Panel.sessions){
                System.out.println(session);
            }

        });
        sortByHall.addActionListener((ev) -> {
            Collections.sort(Admin_Panel.sessions, new ComparatorByHall());
            for(Session session: Admin_Panel.sessions){
                System.out.println(session);
            }
        });


    }
}
