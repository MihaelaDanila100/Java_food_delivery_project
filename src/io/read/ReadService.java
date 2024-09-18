package io.read;

import io.exceptions.FileReadingException;

import java.io.*;

public class ReadService {
    private static ReadService instance;

    private ReadService(String filename) throws FileReadingException {
        System.out.println("Facem citirea");
        readData(filename);
    }

    public static ReadService getInstance(String filename) throws FileReadingException {
        if(instance == null){
            instance = new ReadService(filename);
        }
        return instance;
    }

    private void readData(String filename) throws FileReadingException {
        System.out.println("citim");
        try(BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String line = in.readLine();
            while (line!=null) {
                System.out.println(line);
                line = in.readLine();
            }
        } catch (IOException e) {
            throw new FileReadingException("Something went wrong in readUsingBufferedReader method", e);
        }
    }
}
