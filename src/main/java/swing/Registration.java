package swing;


import models.Person;
import services.PersonService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration {
    PersonService personService = new PersonService();
    private static JFrame frame;
    private static JTextField loginTF;
    private static JPasswordField passwordTF;
    private static JPasswordField password2TF;
    private static JTextField nameTF;
    private static JTextField photoTF;
    private static JTextField lastNameTF;
    private static JTextField ageTF;
    private static JTextField emailTF;
    private static JTextField numberTF;
    private static JLabel exceptionLabel;

    public void mainRegistration() {
        frame = new JFrame("Registration");

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon("src/img/regi2.png");
        frame.setIconImage(imageIcon.getImage());
        frame.getContentPane().setBackground(Color.cyan);
        frame.setLayout(new GridBagLayout());

        JLabel nameLabel = new JLabel("Enter your name");
        JLabel lastNameLabel = new JLabel("Enter last name");
        JLabel ageLabel = new JLabel("Enter Age");
        JLabel emailLabel = new JLabel("Enter Email");
        JLabel numberLabel = new JLabel("Enter phone number");
        JLabel loginLabel = new JLabel("Enter login *");
        JLabel labelPhoto = new JLabel("Add photo");
        JLabel passwordLabel = new JLabel("Enter password *");
        JLabel passwordLabel2 = new JLabel("Confirm the password");
        exceptionLabel = new JLabel("information");
        exceptionLabel.setForeground(Color.RED);

        nameTF = new JTextField(15);
        lastNameTF = new JTextField(15);
        ageTF = new JTextField(15);
        emailTF = new JTextField(15);
        numberTF = new JTextField(15);
        loginTF = new JTextField(15);
        passwordTF = new JPasswordField(15);
        password2TF = new JPasswordField(15);
        photoTF = new JTextField(15);

        JCheckBox checkBox = new JCheckBox("Confirm that you are not a bot");

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        JButton signUp = new JButton("Sign up");
        signUp.setCursor(cursor);
        JButton exit = new JButton("Exit");
        exit.setCursor(cursor);

        frame.add(nameLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(nameTF, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(lastNameLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(lastNameTF, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(ageLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(ageTF, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(emailLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(emailTF, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(numberLabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(numberTF, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(loginLabel, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(loginTF, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(labelPhoto, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(photoTF, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(passwordLabel, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(passwordTF, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(passwordLabel2, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(password2TF, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(signUp, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(exit, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(exceptionLabel, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.pack();
        frame.setVisible(true);

        signUp.addActionListener(new SignUpButtonListener());

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });


    }

    public class SignUpButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Person person = new Person();
            person.setLogin(loginTF.getText());
            person.setPassword(passwordTF.getText());
            person.setPassword2(password2TF.getText());
            person.setName(nameTF.getText());
            person.setSurname(lastNameTF.getText());
            System.out.println("LAstName : "+lastNameTF.getText());
            if(!ageTF.getText().equals("")) {
                person.setAge(Integer.parseInt(ageTF.getText()));
            }else {
                person.setAge(0);
            }
            person.setEmail(emailTF.getText());
            person.setPhone(numberTF.getText());
            person.setUrl(photoTF.getText());

            if (!person.getLogin().equals("") && person.getPassword().length() > 5 && person.getPassword().equals(person.getPassword2())) {
                personService.savePerson(person);

                frame.setVisible(false);
            } else {
                exceptionLabel.setText("inccorect login");
            }
        }
    }
}

