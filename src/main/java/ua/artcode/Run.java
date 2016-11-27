package ua.artcode;

import ua.artcode.config.ApplicationContext;

/**
 * Created by gorobec on 27.11.16.
 */
public class Run {
    public static void main(String[] args) {
        ApplicationContext context = ApplicationContext.getInstance();
        context.getController().run();
    }
}
