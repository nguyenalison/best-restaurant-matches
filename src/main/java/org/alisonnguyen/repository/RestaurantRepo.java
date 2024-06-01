package org.alisonnguyen.repository;
import org.alisonnguyen.model.Restaurant;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class RestaurantRepo extends DataLoader{
    private Map<String, Restaurant> restaurantData = new HashMap<>();
    private String CUISINE_PATH = "src/main/resources/data/cuisines.csv";
    private CuisineRepo cuisineRepo = new CuisineRepo(CUISINE_PATH);
    private Map<Integer, String> cuisineData = cuisineRepo.getAllData();

    public RestaurantRepo(String filePath) throws IOException {
        loadData(filePath);
    }

    @Override
    protected void processLine(String[]row) throws IOException {
        String name = row[0].toLowerCase();
        int customerRating = Integer.parseInt(row[1]);
        double distance = Double.parseDouble(row[2]);
        double price = Double.parseDouble(row[3]);
        String cuisineName = matchCuisinesToRestaurant(row[4]);
        Restaurant restaurant = new Restaurant(name, customerRating, distance, price, cuisineName);
        restaurantData.put(name, restaurant);
    }
    @Override
    public Map<String, Restaurant> getAllData(){
        return restaurantData;
    }

    private String matchCuisinesToRestaurant(String cuisineId) throws IOException {
        if(cuisineData.containsKey(Integer.parseInt(cuisineId) )){
//            System.out.println("!!Cuisine id: " + cuisineId + " name: " + cuisineData.get(Integer.parseInt(cuisineId)));
            return cuisineData.get(Integer.parseInt(cuisineId));
        }else {
            System.out.println("Cuisine id does NOT exist");
            return cuisineId;
        }
    }

    public Set<String> getAllRestaurantNames(){
        return restaurantData.keySet();
    }
}
