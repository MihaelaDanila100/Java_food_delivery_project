package io.write;

import io.exceptions.FileWritingException;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteService {
    private static WriteService instance;

    private WriteService() throws FileWritingException {
        System.out.println("Facem scrierea");
        writeData("bla bla bla");
    }

    public static WriteService getInstance() throws FileWritingException {
        if(instance == null){
            instance = new WriteService();
        }
        return instance;
    }

    private void writeData(String text) throws FileWritingException {
        try(DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("files/restaurant.txt", true))) {
            outputStream.writeBytes(text);
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingFileWriter", e);
        }
    }
}
