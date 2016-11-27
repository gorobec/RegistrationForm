package ua.artcode.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ua.artcode.model.User;
import ua.artcode.utils.FileSaver;

import java.util.List;

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
            return true;
        } else {
            return false;
        }
    }
}
