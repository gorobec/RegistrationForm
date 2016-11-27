package ua.artcode.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ua.artcode.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gorobec on 27.11.16.
 */
public class FileSaver {

    private String path;
    private Gson gson;

    public FileSaver(String path) {
        this.path = path;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public List<User> read(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            List<User> users = gson.fromJson(br, new TypeToken<List<User>>(){}.getType());
            if(users == null){
                users = new ArrayList<>();
            }
            return users;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(List<User> users){
        String json = gson.toJson(users);

        try(FileWriter writer = new FileWriter(path)){
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
