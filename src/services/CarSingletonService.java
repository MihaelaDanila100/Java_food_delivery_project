package services;

import io.exceptions.FileReadingException;
import io.exceptions.FileWritingException;
import logistics.Car;

import java.io.*;

public class CarSingletonService {
    public static CarSingletonService instance;
    private MyGenericList<Car> cars;

    private CarSingletonService() throws FileReadingException {
        readData();
    }

    public static CarSingletonService getInstance() throws FileReadingException {
        if(instance == null){
            instance = new CarSingletonService();
        }
        return instance;
    }

    private void readData() throws FileReadingException {
        try(BufferedReader in = new BufferedReader(new FileReader("files/car.csv"))) {
            MyGenericList<Car> myCars = new MyGenericList<Car>();
            String line = in.readLine();
            while (line!=null) {
                String[] fields = line.split(",");
                for(int i = 0; i < fields.length; i += 3){
                    Car c = new Car(fields[i], Integer.parseInt(fields[i+1]));
                    myCars.add(c);
                }
                line = in.readLine();
            }

            this.cars = myCars;

            System.out.println(this.cars.toString());
        } catch (IOException e) {
            throw new FileReadingException("Something went wrong in readUsingBufferedReader method", e);
        }
    }

    public void writeData() throws FileWritingException {
        try(DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("files/car.txt", true))) {
            outputStream.writeBytes(this.cars.toString());
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingFileWriter", e);
        }
    }
}
