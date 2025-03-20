package services;

import io.exceptions.FileReadingException;
import io.exceptions.FileWritingException;
import logistics.Driver;

import java.io.*;

public class DriverSingletonService {
    public static DriverSingletonService instance;
    private MyGenericList<Driver> drivers;

    private DriverSingletonService() throws FileReadingException {
        readData();
    }

    public static DriverSingletonService getInstance() throws FileReadingException {
        if(instance == null){
            instance = new DriverSingletonService();
        }
        return instance;
    }

    private void readData() throws FileReadingException {
        try(BufferedReader in = new BufferedReader(new FileReader("files/driver.csv"))) {
            MyGenericList<Driver> myDrivers = new MyGenericList<Driver>();
            String line = in.readLine();
            while (line!=null) {
                String[] fields = line.split(",");
                for(int i = 0; i < fields.length; i += 5){
                    Driver d = new Driver(fields[i], Integer.parseInt(fields[i+1]), fields[i+2], Integer.parseInt(fields[i+3]));
                    myDrivers.add(d);
                }
                line = in.readLine();
            }
            this.drivers = myDrivers;

            System.out.println(this.drivers.toString());
        } catch (IOException e) {
            throw new FileReadingException("Something went wrong in readUsingBufferedReader method", e);
        }
    }

    public void writeData() throws FileWritingException {
        try(DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("files/driver.txt", true))) {
            outputStream.writeBytes(this.drivers.toString());
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingFileWriter", e);
        }
    }
}
