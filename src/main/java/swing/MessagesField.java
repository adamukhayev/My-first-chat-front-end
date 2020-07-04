package swing;

import models.Msg;
import services.PersonService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class MessagesField extends JFrame {
    final int START_LOCATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;

    JTextArea dialogue;
    JTextField message;
    Msg msg = new Msg();
    PersonService personService = new PersonService();

    public void MessagesField(String accountName, String name) throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(name);
        dialogue = new JTextArea();
        dialogue.setBackground(Color.cyan);
        dialogue.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(dialogue);
        JPanel panelBP = new JPanel();
        panelBP.setLayout(new BoxLayout(panelBP, BoxLayout.X_AXIS));

        message = new JTextField();
        JButton sendMessage = new JButton("SEND MESSAGE");
        JButton backButton = new JButton("BACK");

        panelBP.add(message);
        panelBP.add(sendMessage);
        panelBP.add(backButton);

        add(BorderLayout.CENTER, scrollPane);
        add(BorderLayout.SOUTH, panelBP);
        setVisible(true);
        msg.setName(name);
        msg.setAccountName(accountName);
        MyTheard myTheard = new MyTheard();
        myTheard.start();
        sendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogue.setText(accountName + " : " + message.getText());
                msg.setMsg(accountName + " : " + message.getText());
                message.setText("");
                msg.setAccountName(accountName);
                msg.setName(name);
                personService.saveMsg(msg);


            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profile profile = new Profile();
                profile.searchMain(accountName, name);
                myTheard.stop();
                setVisible(false);
            }
        });
    }

    class MyTheard extends Thread {
        @Override
        public void run() {
            while (true) {
                List<Msg> list = null;
                try {
                    list = personService.getMessage(msg.getName(), msg.getAccountName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    Msg msg = list.get(i);
                    System.out.println("Message : "+msg.getMsg());
                    stringBuilder.append(msg.getMsg() + "\n");
                }
                Font font = new Font("TimesRoman", Font.BOLD, 15);
                dialogue.setFont(font);
                dialogue.setText(stringBuilder.toString());
                try {
                    Thread.sleep(Long.parseLong("500"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

