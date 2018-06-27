package project;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.*;
import java.util.Scanner;

public class Home extends JFrame {
    private JLabel nameLabel = new JLabel("Username: ");
    private JButton adminButton = new JButton("Admin");
    private JButton userButton = new JButton("User");

    public Home(){
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
          class Autorize extends JFrame {
              private JLabel password = new JLabel("input password");
              private JTextField pass = new JTextField();
              private JButton registr = new JButton("login");
              private JButton exit = new JButton("back");

              public Autorize() {
                  super("Enter Password");
                  setSize(500, 500);
                  Container container = getContentPane();
                  container.setLayout(new GridLayout(6, 6));
                  container.add(pass);
                  container.add(password);
                  ButtonGroup bg = new ButtonGroup();
                  bg.add(registr);
                  bg.add(exit);
                  container.add(registr);
                  container.add(exit);
                  registr.addActionListener((ev) ->{
                      String password = "moder";
                      String buff = pass.getText();
                      if(buff.equals(password)){
                          Admin_Panel ap = new Admin_Panel();
                          ap.setVisible(true);
                      }else {
                          JOptionPane.showMessageDialog(null , "Password incorect" , "Mistake" ,JOptionPane.ERROR_MESSAGE );
                      }
                        dispose();
                  });
                  exit.addActionListener((ev) -> {
                      dispose();
                  });

              }

          }
            Autorize app = new Autorize();
            app.setVisible(true);

         });


    }

}
