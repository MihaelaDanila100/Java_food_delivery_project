package services;

import io.exceptions.FileReadingException;
import io.exceptions.FileWritingException;
import users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserSingletonService {
    public static UserSingletonService instance;
    private MyGenericList<User> users;

    private UserSingletonService() throws FileReadingException {
        readData();
    }

    public static UserSingletonService getInstance() throws FileReadingException {
        if(instance == null){
            instance = new UserSingletonService();
        }
        return instance;
    }

    private void readData() throws FileReadingException {
        try(BufferedReader in = new BufferedReader(new FileReader("files/user.csv"))) {
            String line = in.readLine();
            MyGenericList<User> myUsers = new MyGenericList<>();
            while (line!=null) {
                String[] fields = line.split(",");
                for(int i = 0; i < fields.length; i += 4){
                    User u = new User(fields[i], fields[i+1], fields[i+2], fields[i+3]);
                    myUsers.add(u);
                }
                line = in.readLine();
            }
            this.users = myUsers;
        } catch (IOException e) {
            throw new FileReadingException("Something went wrong in readUsingBufferedReader method", e);
        }
    }

    public void writeData() throws FileWritingException {
        try(DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("files/user.txt", true))) {
            outputStream.writeBytes(this.users.toString());
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingFileWriter", e);
        }
    }
}
