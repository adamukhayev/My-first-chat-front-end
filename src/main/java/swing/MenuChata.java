package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.SQLException;

public class MenuChata {
    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();
    private static JPanel panel2 = new JPanel();
    private static JButton button;
    private static JTextField textField;
    private static JTextArea jTextArea = new JTextArea();
    private  JTextField searchTF;



    public void menu(String str) throws IOException {

        panel.setLayout(new BorderLayout());

        Font font = new Font("TimesRoman", Font.BOLD, 30);
        jTextArea.setFont(font);
        jTextArea.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        panel.add(jScrollPane, BorderLayout.CENTER);
        panel.setBounds(10, 10, 500, 500);
        frame.add(panel, BorderLayout.CENTER);
        JPanel panel1 = new JPanel();
        button = new JButton("Отправить");

        textField = new JTextField(20);
        panel1.setLayout(new FlowLayout());
        panel1.add(textField);
        panel1.add(button);
        panel.add(panel1, BorderLayout.PAGE_END);


         searchTF = new JTextField(15);
        JButton searchButton = new JButton("Search");

        panel2.setLayout(new GridLayout(2,1));
        panel2.setBounds(510,10,175,50);
        panel2.add(searchTF); panel2.add(searchButton);
        frame.add(panel2,BorderLayout.EAST);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());


        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jTextArea.setText(str+" : "+textField.getText());
            }

        });

        searchButton.addActionListener(new SearchAction());

    }

    public class SearchAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            Profile profile = new Profile();
//            profile.searchMain(searchTF.getText());


        }
    }
}
