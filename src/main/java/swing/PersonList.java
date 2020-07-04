package swing;


import models.Person;
import services.PersonService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.*;

public class PersonList extends JFrame {

    private JButton buttonUpdate = new JButton("Update");
    private JButton buttonUpPhoto = new JButton("Update Photo");
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
    JButton buttonSearch = new JButton("Search");

    JPanel panelInfo = new JPanel(new BorderLayout());
    JPanel panelPerson = new JPanel(new GridLayout(7, 2));
    JPanel panelButton = new JPanel(new GridBagLayout());
    JPanel panelButton1 = new JPanel(new GridLayout(1, 3));
    PersonService personService = new PersonService();
    private static Person person = new Person();
    JFrame frame = new JFrame("List");

    private static Profile profile;

    public void personList(String nickName) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        DefaultListModel defaultListModel = new DefaultListModel();
        JList northList = new JList(defaultListModel);
        northList.setLayoutOrientation(JList.VERTICAL);
        Font font = new Font("TimesRoman", Font.BOLD, 15);
        northList.setFont(font);
        northList.setBackground(Color.cyan);
        northList.setVisibleRowCount(0);

        JScrollPane northScroll = new JScrollPane(northList);
        northScroll.setPreferredSize(new Dimension(195, 100));

        mainPanel.add(northScroll, BorderLayout.CENTER);


        frame.add(BorderLayout.WEST, mainPanel);

        frame.setPreferredSize(new Dimension(600, 300));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        List<Person> list = personService.getPersons();
        for (int i = 0; i < list.size(); i++) {
             person = list.get(i);
            String login = person.getLogin();
            System.out.println("MOI LOGIN : " + login);
            System.out.println("NICKKK " + nickName);
            if (!person.getLogin().equals(nickName)) {
                defaultListModel.addElement("Login = " + login);
            } else {
                firstNameLabel.setText(person.getName());
                lastNameLabel.setText(person.getSurname());
                ageLabel.setText(String.valueOf(person.getAge()));
                emailLabel.setText(person.getEmail());
                phoneLabel.setText(person.getPhone());
                loginLabel.setText(person.getLogin());
                dataLabel.setText(person.getDate());

                Font font1 = new Font("Vardana", Font.ITALIC, 10);
                dataLabel1.setFont(font1);
                panelButton.add(dataLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                dataLabel.setFont(font1);
                dataLabel.setForeground(Color.blue);
                panelButton.add(dataLabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
                buttonPhoto.setSize(50, 10);
                panelButton.add(buttonPhoto, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

                panelPerson.add(firstNameLabel1);
                panelPerson.add(firstNameLabel);

                panelPerson.add(lastNameLabel1);
                panelPerson.add(lastNameLabel);

                panelPerson.add(ageLabel1);
                panelPerson.add(ageLabel);

                panelPerson.add(emailLabel1);
                panelPerson.add(emailLabel);

                panelPerson.add(phoneLabel1);
                panelPerson.add(phoneLabel);

                panelPerson.add(loginLabel1);
                panelPerson.add(loginLabel);

                panelButton1.add(buttonSearch);
                panelButton1.add(buttonUpdate);
                panelButton1.add(buttonUpPhoto);

                panelInfo.add(panelButton, BorderLayout.PAGE_START);
                panelInfo.add(panelPerson, BorderLayout.CENTER);

                frame.add(panelInfo, BorderLayout.CENTER);
                frame.add(panelButton1, BorderLayout.PAGE_END);
            }
        }

        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profile = new Profile();
                String line = String.valueOf(northList.getSelectedValue()).split("= ")[1];
                System.out.println(line);

                profile.searchMain(nickName, line);
                frame.setVisible(false);
            }
        });

        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < list.size() ; i++) {
                    Person person1 = list.get(i);
                    if(person1.getLogin().equals(nickName)){
                        UpdateClass updateClass = new UpdateClass();
                        updateClass.update(person1);
                    }
                }
            }
        });
    }

}
