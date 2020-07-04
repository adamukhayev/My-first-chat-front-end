package swing;

import lombok.SneakyThrows;
import models.AddFriend;
import models.Person;
import services.PersonService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Profile extends JFrame {
    private ArrayList<String> list = new ArrayList<>();

    private JLabel firstNameLabel = new JLabel();
    private JLabel lastNameLabel = new JLabel();
    private JLabel ageLabel = new JLabel();
    private JLabel emailLabel = new JLabel();
    private JLabel phoneLabel = new JLabel();
    private JLabel loginLabel = new JLabel();
    private JLabel accuntLabel = new JLabel();

    private JLabel firstNameLabel1 = new JLabel("   Name : ");
    private JLabel lastNameLabel1 = new JLabel("   Last Name : ");
    private JLabel ageLabel1 = new JLabel("   Age : ");
    private JLabel emailLabel1 = new JLabel("   Email : ");
    private JLabel phoneLabel1 = new JLabel("   Phone : ");
    private JLabel loginLabel1 = new JLabel("   Login : ");

    private JLabel dataLabel1 = new JLabel("Registration  ");
    private JLabel dataLabel = new JLabel();
    private JButton buttonPhoto = new JButton("Photo");
    private JButton buttonSms = new JButton("Send a message");

    private JButton buttonAdd = new JButton("Add +");
    private JButton deleteAdd = new JButton("Delete");
    private JButton buttonBack = new JButton("Back");
    private Person person;
    private String personNick = null;

    private Boolean bol = true;

    JPanel panel1 = new JPanel();

    private JPanel panel = new JPanel();
    private static PersonList personList;
     private static AddFriend addFriend ;
     private static PersonService personService = new PersonService();

    Profile() {

        setSize(300, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        Font font = new Font("Vardana", Font.ITALIC, 10);
        dataLabel1.setFont(font);
        panel3.add(dataLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        dataLabel.setFont(font);
        dataLabel.setForeground(Color.blue);
        panel3.add(dataLabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        buttonPhoto.setSize(50, 10);
        panel3.add(buttonPhoto, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel3.add(buttonSms, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel1.setLayout(new GridLayout(1, 3));
        panel.setLayout(new GridLayout(6, 2));
        panel.add(firstNameLabel1);
        panel.add(firstNameLabel);
        panel.add(lastNameLabel1);
        panel.add(lastNameLabel);
        panel.add(ageLabel1);
        panel.add(ageLabel);
        panel.add(emailLabel1);
        panel.add(emailLabel);
        panel.add(phoneLabel1);
        panel.add(phoneLabel);
        panel.add(loginLabel1);
        panel.add(loginLabel);



        add(panel, BorderLayout.CENTER);
        add(panel3, BorderLayout.PAGE_START);
        add(panel1, BorderLayout.PAGE_END);
        setVisible(true);

        buttonPhoto.addActionListener(new PhotoAdd());
        buttonSms.addActionListener(new SmsButton());
        buttonBack.addActionListener(new BackButton());
        buttonAdd.addActionListener(new AddAction());
        deleteAdd.addActionListener(new DeleteButton());
    }

    public void searchMain(String nickName, String text) {
        personNick = nickName;
        accuntLabel.setText(nickName);
         person = personService.getPersonById(text);
        setTitle(nickName);
        firstNameLabel.setText(person.getName());
        lastNameLabel.setText(person.getSurname());
        ageLabel.setText(String.valueOf(person.getAge()));
        emailLabel.setText(person.getEmail());
        phoneLabel.setText(person.getPhone());
        loginLabel.setText(person.getLogin());
        dataLabel.setText(person.getDate());
        System.out.println("Proverka "+personNick);
        addFriend = new AddFriend();
            addFriend.setNickName1(nickName);
            addFriend.setNickName2(text);

       addFriend = personService.bol(addFriend);
        System.out.println(bol);
        if (Objects.isNull(addFriend)) {
            panel1.add(buttonAdd);
            panel1.add(buttonBack);
        } else {
            panel1.add(deleteAdd);
            panel1.add(buttonBack);
        }


        setVisible(true);
    }


    public class SmsButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            MessagesField messagesField = new MessagesField();
            String str = loginLabel.getText();

            try {
                messagesField.MessagesField(accuntLabel.getText(), str);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            setVisible(false);
        }
    }

    public class AddAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Friend");
            System.out.println("PROVERKA "+personNick);System.out.println("PROVERKA1 "+person.getLogin());
            addFriend = new AddFriend();
            addFriend.setNickName1(personNick);
            addFriend.setNickName2(person.getLogin());
            personService.addFriend(addFriend);

        }
    }

    public class BackButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            personList = new PersonList();
            try {
                personList.personList(accuntLabel.getText());
                setVisible(false);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public class DeleteButton implements ActionListener {

        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("GETID "+addFriend.getId());
            personService.deletePerson(addFriend.getId());
        }
    }

    public class PhotoAdd implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

//            String urlPhoto = list.get(5);
//            Main main = new Main();
//            main.push(urlPhoto);


        }
    }
}
