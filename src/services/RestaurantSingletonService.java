package services;

import io.exceptions.FileReadingException;
import io.exceptions.FileWritingException;
import logistics.Driver;
import products.Dish;
import pubs.Restaurant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantSingletonService {
    public static RestaurantSingletonService instance;
    private MyGenericList<Restaurant> restaurants;

    private RestaurantSingletonService() throws FileReadingException {
        readData();
    }

    public static RestaurantSingletonService getInstance() throws FileReadingException {
        if(instance == null){
            instance = new RestaurantSingletonService();
        }
        return instance;
    }

    private void readData() throws FileReadingException {
        try(BufferedReader in = new BufferedReader(new FileReader("files/restaurant.csv"))) {
            MyGenericList<Restaurant> myRestaurants = new MyGenericList<>();
            String line = in.readLine();
            while (line!=null) {
                String[] fields = line.split(",");
                for(int i = 0; i < fields.length;){
                    String name = fields[i];
                    i += 1;
                    String city = fields[i];
                    i += 1;
                    String address = fields[i];
                    i += 1;
                    int nrOfDishes = Integer.parseInt(fields[i]);
                    i += 1;

                    MyGenericList<Dish> dishes = new MyGenericList<>();
                    int j;
                    for(j = i; j < i + nrOfDishes; j++){
                        String nameDish = fields[j];
                        int quantity = Integer.parseInt(fields[j+1]);
                        System.out.println(fields[j]);
                        int numberOfIngredients = Integer.parseInt(fields[j + 2]);
                        List<String> ingredients = new ArrayList<>();
                        int k;
                        for(k = 0; k < numberOfIngredients; k++){
                            String ingredient = fields[j+3+k];
                            ingredients.add(ingredient);
                        }
                        i = i + k;
                        Dish d = new Dish(nameDish, quantity, ingredients);
                        dishes.add(d);
                    }
                    i = i + j;
                    Restaurant r = new Restaurant(name, city, address, dishes);
                    myRestaurants.add(r);
                }
                line = in.readLine();
            }
            this.restaurants = myRestaurants;

            System.out.println(this.restaurants.toString());
        } catch (IOException e) {
            throw new FileReadingException("Something went wrong in readUsingBufferedReader method", e);
        }
    }

    public void writeData() throws FileWritingException {
        try(DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("files/restaurant.txt", true))) {
            outputStream.writeBytes(this.restaurants.toString());
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingFileWriter", e);
        }
    }
}
