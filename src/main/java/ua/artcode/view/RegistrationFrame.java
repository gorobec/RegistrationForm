package ua.artcode.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gorobec on 27.11.16.
 */
public class RegistrationFrame extends JFrame {

    private JLabel nameLabel = new JLabel("Name:");
    private JLabel surnameLabel = new JLabel("Surname:");
    private JLabel phoneLabel = new JLabel("Phone:");
    private JLabel emailLabel = new JLabel("Email:");
    private JLabel passwordLabel = new JLabel("Password:");


    private JTextField name = new JTextField(15);
    private JTextField surname = new JTextField(15);
    private JTextField phone = new JTextField(15);
    private JTextField email = new JTextField(15);
    private JTextField password = new JTextField(15);

    private JButton register = new JButton("Register");
    private JButton cancel = new JButton("Cancel");


    public RegistrationFrame() {

        setTitle("Registration form");
        setResizable(false);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(600, 400));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 15, 15);

        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(nameLabel, constraints);
        constraints.gridx = 1;
        add(name, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(surnameLabel, constraints);
        constraints.gridx = 1;
        add(surname, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(phoneLabel, constraints);
        constraints.gridx = 1;
        add(phone, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        add(emailLabel, constraints);
        constraints.gridx = 1;
        add(email, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        add(passwordLabel, constraints);
        constraints.gridx = 1;
        add(password, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        add(register, constraints);
        constraints.gridx = 1;
        add(cancel, constraints);

        pack();
    }
}
