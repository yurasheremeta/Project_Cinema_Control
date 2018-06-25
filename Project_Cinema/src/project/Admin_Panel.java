package project;
import jdk.nashorn.internal.ir.LiteralNode;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Admin_Panel extends JFrame {
    static   List<Session> sessions = new ArrayList<>();
    private JButton addSession = new JButton("add Session");
    private JLabel name = new JLabel("admin");
    private JLabel nameFilm = new JLabel("name");
    private JTextField nameFilm1 = new JTextField();
    private JLabel hall = new JLabel("hall");
    private JTextField hall1 = new JTextField();
    private JLabel date = new JLabel("date");
    private JTextField date1 = new JTextField();
    private JButton outputList = new JButton("output list of sessions" );
    private JButton deleteSesion = new JButton("delete session");
    private JButton outpuFilms = new JButton(" films");

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
        bg.add(outputList);
        bg.add(deleteSesion);
        bg.add(outpuFilms);
        container.add(addSession);
        container.add(outputList);
        container.add(deleteSesion);
        container.add(outpuFilms);

        addSession.addActionListener((ev) -> {
                String name = nameFilm1.getText();
               String date1Text = date1.getText();
               String hall1Text = hall1.getText();
               try{
                   double date = Double.valueOf(date1Text);
                    int hall = Integer.valueOf(hall1Text);

                   Session session = new Session(new Film(name) , new Hall(hall) , date);
                   sessions.add(session);
                   nameFilm1.setText(" ");
                   hall1.setText(" ");
                   date1.setText(" ");
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null , "Wrong" , "Mistake" ,JOptionPane.ERROR_MESSAGE );

               }
        });
        outputList.addActionListener((ev) -> {
            StringBuilder sb = new StringBuilder();
            sessions.forEach(e -> sb.append(e));
            JOptionPane.showMessageDialog(null , sb.toString() , "Users" ,JOptionPane.PLAIN_MESSAGE );
        });
        deleteSesion.addActionListener((ev) -> {
            for(Session session : sessions){
                System.out.println(session);
            }
            class DeleteSession extends JFrame{
                private JLabel nameToDelete = new JLabel("What film you want to delete?");
                private JTextField inputtoDelete = new JTextField();
                private JButton delete = new JButton("delete session");
                public DeleteSession(){
                    super("Delete");
                    setSize(500 , 500);

                    Container container = getContentPane();
                    container.setLayout(new GridLayout(5,3));
                    container.add(nameToDelete);
                    container.add(inputtoDelete);
                    ButtonGroup bg = new ButtonGroup();
                    bg.add(delete);
                    container.add(delete);

                    delete.addActionListener((ev) -> {
                            Iterator<Session> iter = sessions.iterator();
                            String film = inputtoDelete.getText();
                            while (iter.hasNext()) {
                                Session session = iter.next();
                                if (session.getFilm().getName().equals(film)) {
                                    iter.remove();
                                }
                            }
                    });
                }
            }
            DeleteSession ds = new DeleteSession();
            ds.setVisible(true);
        });
        outpuFilms.addActionListener((ev) ->{
            List<String> names2 = sessions.stream()
                    .filter(e -> e != null)
                    .map(e -> e.getFilm().getName())
                    .distinct()
                    .collect(Collectors.toList());
            StringBuilder sb = new StringBuilder();
            sessions.forEach(e -> sb.append(e.getFilm().getName()+"\n"));
            JOptionPane.showMessageDialog(null , sb.toString() , "Users" ,JOptionPane.PLAIN_MESSAGE );
            System.out.println(names2);
        });

    }
}
