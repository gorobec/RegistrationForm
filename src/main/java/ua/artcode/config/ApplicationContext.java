package ua.artcode.config;

import ua.artcode.controller.RegistrationController;
import ua.artcode.dao.IUserJsonDao;
import ua.artcode.dao.UserJsonDao;
import ua.artcode.utils.FileSaver;
import ua.artcode.view.RegistrationFrame;

/**
 * Created by gorobec on 27.11.16.
 */
public class ApplicationContext {

    private String dbPath = "/home/gorobec/java/development/Teaching/Registration/src/main/resources/users.txt";
    private FileSaver fileSaver;
    private IUserJsonDao dao;
    private RegistrationFrame frame;
    private RegistrationController controller;

    private static final ApplicationContext INSTANCE = new ApplicationContext();

    public static ApplicationContext getInstance(){
        return INSTANCE;
    }

    public ApplicationContext() {
        this.fileSaver = new FileSaver(dbPath);
        this.dao = new UserJsonDao(fileSaver);
        frame = new RegistrationFrame();
        controller = new RegistrationController(frame, dao);
    }

    public RegistrationController getController() {
        return controller;
    }
}
