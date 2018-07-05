package project;
import jdk.nashorn.internal.ir.LiteralNode;
import javax.swing.*;
import java.awt.*;
//import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import  java.io.*;

public class Admin_Panel extends JFrame {
    static    List<Session> sessions = new ArrayList<>();

    private JButton addSession = new JButton("add Session");
    private JLabel name = new JLabel("admin");
    private JLabel nameFilm = new JLabel("name");
    private JTextField nameFilm1 = new JTextField();
    private JLabel hall = new JLabel("hall");
    private JTextField hall1 = new JTextField();
    private JLabel date = new JLabel("date: ");
    private JLabel year = new JLabel("year");
    private JTextField inputYear = new JTextField();
    private JLabel month = new JLabel("month");
    private JTextField inputMonth = new JTextField();
    private JLabel day = new JLabel("day");
    private JTextField inputDay = new JTextField();
    private JLabel hour = new JLabel("hour");
    private JTextField inputHour = new JTextField();
    private JLabel minute = new JLabel("minute");
    private JTextField inputMinute = new JTextField();
    private JButton outputList = new JButton("output list of sessions" );
    private JButton deleteSesion = new JButton("delete session");
    private JButton outpuFilms = new JButton(" films");
    private JButton exit = new JButton("exit");
    private JButton outputFromFile = new JButton("output from file");


    public Admin_Panel(){
        super("Cinema control");
        setSize(2000 , 1024);
        Container container = getContentPane();
        container.setLayout(new GridLayout(25,10));
        container.add(name);
        container.add(nameFilm);
        container.add(nameFilm1);
        container.add(date);
        container.add(year);
        container.add(inputYear);
        container.add(month);
        container.add(inputMonth);
        container.add(day);
        container.add(inputDay);
        container.add(hour);
        container.add(inputHour);
        container.add(minute);
        container.add(inputMinute);
        container.add(hall);
        container.add(hall1);
        ButtonGroup bg = new ButtonGroup();
        bg.add(addSession);
        bg.add(outputList);
        bg.add(deleteSesion);
        bg.add(outpuFilms);
        bg.add(exit);
        container.add(addSession);
        container.add(outputList);
        container.add(deleteSesion);
        container.add(outpuFilms);
        container.add(exit);

        addSession.addActionListener((ev) -> {
                //Date date = new Date(year , month , dayOfMonth , hour , minute);
                String name = nameFilm1.getText();
                String yearText = inputYear.getText();
                String monthText = inputMonth.getText();
                String dayText = inputDay.getText();
                String hourText = inputHour.getText();
                String minuteText = inputMinute.getText();
                String hall1Text = hall1.getText();
               try{
                    int hall = Integer.valueOf(hall1Text);
                    int year = Integer.valueOf(yearText);
                    int month  = Integer.valueOf(monthText);
                    int dayOfMonth  = Integer.valueOf(dayText);
                    int hour = Integer.valueOf(hourText);
                    int minute = Integer.valueOf(minuteText);

                        Session session = new Session(new Film(name) , new Hall(hall) ,LocalDateTime.of(year , month , dayOfMonth , hour , minute));
                        sessions.add(session);

                   nameFilm1.setText("");
                   hall1.setText("");
                   inputYear.setText("");
                   inputMonth.setText("");
                   inputDay.setText("");
                   inputHour.setText("");
                   inputMinute.setText("");
                   FileWriter fw = new FileWriter("Sessiona");
                   Session session1 = new Session(new Film(name) , new Hall(hall) ,LocalDateTime.of(year , month , dayOfMonth , hour , minute));
//                    for(Session session1:sessions){
//                        fw.write(session1.toString());
//                        fw.flush();
//                    }
                   fw.write(sessions.toString());
                   fw.flush();
                   fw.close();
               }catch(Exception e){
                   System.out.println(e);
                   JOptionPane.showMessageDialog(null , "All field must " , "Mistake" ,JOptionPane.ERROR_MESSAGE );



               }

        });
        outputList.addActionListener((ev) -> {
            StringBuilder sb = new StringBuilder();
            sessions.forEach(e -> sb.append(e));
            JOptionPane.showMessageDialog(null , sb.toString() , "Sessions" ,JOptionPane.PLAIN_MESSAGE );

        });
        deleteSesion.addActionListener((ev) -> {
            for(Session session : sessions){
                System.out.println(session);
            }
            class DeleteSession extends JFrame{
                private JLabel nameToDelete = new JLabel("What film you want to delete?");
                private JTextField inputtoDelete = new JTextField();
                private JButton delete = new JButton("delete session");
                private JButton exit = new JButton("back");
                public DeleteSession(){
                    super("Delete");
                    setSize(500 , 500);

                    Container container = getContentPane();
                    container.setLayout(new GridLayout(5,3));
                    container.add(nameToDelete);
                    container.add(inputtoDelete);
                    ButtonGroup bg = new ButtonGroup();
                    bg.add(delete);
                    bg.add(exit);
                    container.add(delete);
                    container.add(exit);
                    delete.addActionListener((ev) -> {
                            Iterator<Session> iter = sessions.iterator();
                            String film = inputtoDelete.getText();
                            while (iter.hasNext()) {
                                Session session = iter.next();
                                if (session.getFilm().getName().equals(film)) {
                                    iter.remove();
                                }
                            }
                            inputtoDelete.setText("");
                    });
                    exit.addActionListener((ev) -> {
                        dispose();
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
            JOptionPane.showMessageDialog(null , sb.toString() , "Films" ,JOptionPane.PLAIN_MESSAGE );
            System.out.println(names2);
        });
        exit.addActionListener((ev) -> {
            dispose();
        });
        outputFromFile.addActionListener((ev) -> {
            File file = new File("OutputSessions.txt");
            if (!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                FileReader fr = new FileReader("Sessiona");
                BufferedReader br = new BufferedReader(fr);

                String line =  br.readLine();
                String[] strs = line.split("");
             //   Session ses = new Session(new Film(strs[0]),new Hall(hall) , strs[2])
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
