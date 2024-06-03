package org.alisonnguyen.service;

import org.alisonnguyen.model.Restaurant;
import org.alisonnguyen.repository.RestaurantRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MatchingService {

    private RestaurantRepo restaurantRepo;
    private Map<String, Restaurant> restaurantData;

    public MatchingService(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
        restaurantData = restaurantRepo.getAllData();
    }

    public List<Restaurant> matchByName(String userInput) {
        List<Restaurant> matches = new ArrayList<>();
        restaurantData.forEach((k,v) -> {
            if (v.getName().contains(userInput.toLowerCase())){
                matches.add(v);
            }
        });
        return matches;
    }

    public List<Restaurant> matchByRating(int preferredRating) {
        List<Restaurant> matches = new ArrayList<>();
        restaurantData.forEach((k, v) -> {
            if (v.getCustomerRating() >= preferredRating) {
                matches.add(v);
            }
        });
        return matches;
    }

    public List<Restaurant> matchByDistance(double distance) {
        List<Restaurant> matches = new ArrayList<>();
        restaurantData.forEach((k, v) -> {
            if (v.getDistance() <= distance) {
                matches.add(v);
            }
        });
        return matches;

    }

    public List<Restaurant> matchByBudget(double price) {
        List<Restaurant> matches = new ArrayList<>();
        restaurantData.forEach((k, v) -> {
            if (v.getDistance() <= price) {
                matches.add(v);
            }
        });
        return matches;
    }

    public List<Restaurant> matchByCuisine(String inputCuisine){
        List<Restaurant> matches = new ArrayList<>();
        restaurantData.forEach((k,v) ->{
            if (v.getCuisine().toLowerCase().contains(inputCuisine.toLowerCase())){
                matches.add(v);
            }
        });
        return matches;
    }
}
