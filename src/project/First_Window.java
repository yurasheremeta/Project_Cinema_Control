package project;
import javax.swing.*;
import java.awt.*;

public class First_Window extends JFrame {
    private JLabel nameLabel = new JLabel("Username: ");
    private JButton adminButton = new JButton("Admin");
    private JButton userButton = new JButton("User");
    public First_Window(){
        super("Cinema Control");
        setSize(600 , 600);
        Container container = getContentPane();
        container.setLayout(new GridLayout(6,4));
        container.add(nameLabel);
        ButtonGroup bg = new ButtonGroup();
        bg.add(userButton);
        bg.add(adminButton);
        container.add(userButton);
        container.add(adminButton);
        userButton.addActionListener((ev) -> {
            User_Panel up = new User_Panel();
            up.setVisible(true);
        });
        adminButton.addActionListener((ev) ->{
            Admin_Panel ap = new Admin_Panel();
            ap.setVisible(true);
        });
    }

}
