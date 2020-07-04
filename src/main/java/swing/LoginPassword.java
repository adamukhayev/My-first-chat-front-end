package swing;


import models.Person;
import services.PersonService;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPassword {
    private static JFrame frame;
    private static JLabel loginPasswordException;
    private static JTextField loginTextField;
    private static JPasswordField passwordTextField;
    private static PersonService personService = new PersonService();

    public static void main(String[] args) {
        frame = new JFrame("Login");
        ImageIcon imageIcon = new ImageIcon("src/img/дверь1.png");
        frame.setIconImage(imageIcon.getImage());
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLayout(new GridBagLayout());

        Font font = new Font("Vardana", Font.ITALIC, 10);

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setForeground(Color.blue);
        loginLabel.setFont(font);
        JLabel loginPasswordLabel = new JLabel("Password");
        loginPasswordLabel.setForeground(Color.blue);
        loginPasswordLabel.setFont(font);

        loginPasswordException = new JLabel();
        loginPasswordException.setForeground(Color.red);
        loginPasswordException.setFont(font);

        loginTextField = new JTextField(15);
        loginTextField.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        passwordTextField = new JPasswordField(15);
        passwordTextField.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        JButton loginButton = new JButton("Login in");
        loginButton.setFont(font);
        loginButton.setBackground(Color.orange);
        loginButton.setCursor(cursor);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.blue));

        JButton registrationButton = new JButton("Registration");
        registrationButton.setFont(font);
        registrationButton.setBackground(Color.green);
        registrationButton.setForeground(Color.black);
        registrationButton.setCursor(cursor);
        registrationButton.setBorder(BorderFactory.createLineBorder(Color.blue));

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(font);
        exitButton.setCursor(cursor);
        exitButton.setBorder(BorderFactory.createLineBorder(Color.blue));

        JCheckBox checkBox = new JCheckBox("Confirm that you are not a bot");
        frame.setMaximumSize(new Dimension(50, 50));
        frame.add(loginLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(loginTextField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(loginPasswordLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(passwordTextField, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(loginPasswordException, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(loginButton, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(registrationButton, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.add(exitButton, new GridBagConstraints(0, 5, 2, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        frame.setVisible(true);
        frame.pack();


        loginButton.addActionListener(new LoginButtonActionListner());
        exitButton.addActionListener(new ExitButtonActionListner());
        registrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registration registration = new Registration();
                registration.mainRegistration();
            }
        });

    }

    public static class LoginButtonActionListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Person person = new Person();
            try {
                person.setLogin(loginTextField.getText());
                person.setPassword(passwordTextField.getText());
                String strInfo = personService.loginPerson(person);
                if (!strInfo.equals("not found")) {
                    frame.setVisible(false);
                    System.out.println(person.getLogin());
                    PersonList personList = new PersonList();
                    personList.personList(person.getLogin());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
    }

    public static class ExitButtonActionListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
        }
    }
}
