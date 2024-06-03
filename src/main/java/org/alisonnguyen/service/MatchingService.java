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
        Set<String> restaurantNames = restaurantData.keySet();
        String userInputLower = userInput.toLowerCase();

        return restaurantNames.stream()
                .filter(name -> name.toLowerCase().contains(userInputLower))
                .sorted((name1, name2) -> {
                    String name1Lower = name1.toLowerCase();
                    String name2Lower = name2.toLowerCase();

                    int index1 = name1Lower.indexOf(userInputLower);
                    int index2 = name2Lower.indexOf(userInputLower);

                    // compare by index of first occurrence
                    if (index1 != index2) {
                        return Integer.compare(index1, index2);
                    }

                    // compare by length of name
                    int lengthComparison = Integer.compare(name1.length(), name2.length());
                    if (lengthComparison != 0) {
                        return lengthComparison;
                    }

                    // compare by frequency of occurrence of the substring
                    long count1 = name1Lower.split(userInputLower, -1).length - 1;
                    long count2 = name2Lower.split(userInputLower, -1).length - 1;
                    int frequencyComparison = Long.compare(count2, count1);
                    if (frequencyComparison != 0) {
                        return frequencyComparison;
                    }
                    return name1Lower.compareTo(name2Lower);
                })
                .map(name -> restaurantData.get(name))
                .collect(Collectors.toList());
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
