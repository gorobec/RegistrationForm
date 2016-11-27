package ua.artcode.dao;

import ua.artcode.model.User;

/**
 * Created by gorobec on 27.11.16.
 */
public interface IUserJsonDao {

    boolean saveUser(User user);
}
