package ua.artcode.dao;

import ua.artcode.model.User;
import ua.artcode.utils.FileSaver;

import java.util.List;

import static ua.artcode.utils.MailSender.sendEmail;

/**
 * Created by gorobec on 27.11.16.
 */
public class UserJsonDao implements IUserJsonDao{

    private FileSaver fileSaver;

    public UserJsonDao(FileSaver fileSaver) {
        this.fileSaver = fileSaver;
    }

    @Override
    public boolean saveUser(User user) {
        List<User> users = fileSaver.read();


        if(!users.contains(user)){
            users.add(user);
            fileSaver.save(users);
            sendEmail(user);
            return true;
        } else {
            return false;
        }
    }


}
