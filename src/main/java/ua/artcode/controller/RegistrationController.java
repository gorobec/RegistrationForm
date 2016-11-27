package ua.artcode.controller;

import ua.artcode.dao.IUserJsonDao;
import ua.artcode.exceptions.IncorrectEmailException;
import ua.artcode.exceptions.IncorrectNPasswordException;
import ua.artcode.exceptions.IncorrectNameSurnameException;
import ua.artcode.exceptions.IncorrectPhoneException;
import ua.artcode.model.User;
import ua.artcode.view.RegistrationFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gorobec on 27.11.16.
 */
public class RegistrationController {
    private RegistrationFrame frame;
    private IUserJsonDao dao;


    public RegistrationController(RegistrationFrame frame, IUserJsonDao dao) {
        this.frame = frame;
        this.dao = dao;


        frame.getRegister().addActionListener(new RegisterButtonListener());
        frame.getCancel().addActionListener(event -> {
            frame.getUserName().setText("");
            frame.getSurname().setText("");
            frame.getPhone().setText("");
            frame.getEmail().setText("");
            frame.getPassword().setText("");
        });

    }

    private class RegisterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = frame.getUserName().getText();
            String surname = frame.getSurname().getText();
            String phone = frame.getPhone().getText();
            String email = frame.getEmail().getText();
            String password = frame.getPassword().getText();
            try {
                User user = new User(name, surname, phone, email, password);
                boolean result = dao.saveUser(user);
                if(!result){
                    JOptionPane.showMessageDialog(frame,
                            "User has already been register",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "User register successfully",
                            "Information",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IncorrectNameSurnameException | IncorrectPhoneException
                    | IncorrectEmailException | IncorrectNPasswordException e1) {
                JOptionPane.showMessageDialog(frame,
                        e1.getMessage(),
                        e1.toString(),
                        JOptionPane.ERROR_MESSAGE);
            }


        }
    }

    public void run(){
        frame.setVisible(true);
    }
}
