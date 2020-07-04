package swing;

import lombok.SneakyThrows;
import models.Person;
import services.PersonService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateClass {
    PersonService personService = new PersonService();
    JLabel nameLabel = new JLabel("Name");
    JLabel surnameLabel = new JLabel("Last name");
    JLabel ageLabel = new JLabel("Age");
    JLabel emailLabel = new JLabel("Email");
    JLabel phoneLabel = new JLabel("Phone");
    JLabel loginLabel = new JLabel("Login");

    JTextField nameT = new JTextField(20);
    JTextField surnameT = new JTextField(20);
    JTextField ageT = new JTextField(20);
    JTextField emailT = new JTextField(20);
    JTextField phoneT = new JTextField(20);
    JTextField loginT = new JTextField(20);

    JButton buttonUpdate = new JButton("Update");
    JButton buttonBack = new JButton("Back");

    int id = 0;

    public void update(Person person){

        JFrame frame = new JFrame("Update");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLayout(new GridLayout(7,2));

        frame.add(nameLabel);
        nameT.setText(person.getName());
        frame.add(nameT);
        frame.add(surnameLabel);
        surnameT.setText(person.getSurname());
        frame.add(surnameT);
        frame.add(ageLabel);
        ageT.setText(String.valueOf(person.getAge()));
        frame.add(ageT);
        frame.add(emailLabel);
        emailT.setText(person.getEmail());
        frame.add(emailT);
        frame.add(phoneLabel);
        phoneT.setText(person.getPhone());
        frame.add(phoneT);
        frame.add(loginLabel);
        loginT.setText(person.getLogin());

        id = person.getPerson_id();
        frame.add(loginT);
        frame.add(buttonUpdate);
        frame.add(buttonBack);
        frame.pack();
        frame.setVisible(true);
        buttonUpdate.addActionListener(new ButtonUpdate());
    }
    public class ButtonUpdate implements ActionListener{

        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            Person personUpdate = new Person();
            personUpdate.setName(nameT.getText());
            personUpdate.setSurname(surnameT.getText());
            personUpdate.setAge(Integer.parseInt(ageT.getText()));
            personUpdate.setEmail(emailT.getText());
            personUpdate.setPhone(phoneT.getText());
            personUpdate.setLogin(loginT.getText());
            personUpdate.setPerson_id(id);
            System.out.println("ID "+personUpdate.getPerson_id());
            personService.updatePerson(personUpdate);
        }
    }

}
