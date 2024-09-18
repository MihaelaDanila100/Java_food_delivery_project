package services;
import io.exceptions.FileWritingException;
import products.Drink;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Audit {
    private static Audit instance;

    private List<Drink> drinks = new ArrayList<>();

    private Audit(){
        getCSV();
    }

    public static Audit getInstance(){
        if(instance == null){
            instance = new Audit();
        }
        return instance;
    }

    public List<String> getCSV(){
        List<String> lines = new ArrayList<>();
        List<Drink> myDrinks = new ArrayList<>();
        try(var f = new BufferedReader(new FileReader("files/" + "audit.csv"))) {
            String line;
            line = f.readLine();
            while (line != null) {
                lines.add(line);

                String[] fields = line.split(",");

                for(int i = 0; i < fields.length; i += 2){
                    Drink d = new Drink(fields[i], Integer.parseInt(fields[i+1]));
                    myDrinks.add(d);
                }

                line = f.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("problema la citire");
        } catch (IOException e) {
            System.out.println("problema la citire");
        }

        this.drinks = myDrinks;

        return lines;
    }

    public void writeCSV(){
        Stream<Drink> streamDrinks = this.drinks.stream().filter(d -> d.getQuantity() > 10);
        try{
            var writer = new FileWriter("files/audit.csv");
            Consumer<Drink> consumer = action -> {
                try{
                    writer.write(String.valueOf(action));
                    writer.write("\n");
                } catch (IOException e){
                    System.out.println("problema la scriere");
                }
            };
            streamDrinks.forEach(consumer);
        } catch(IOException e){
            System.out.println("problema la scriere");
        }
    }
}
