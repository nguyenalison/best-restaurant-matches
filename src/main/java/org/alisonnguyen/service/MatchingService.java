package org.alisonnguyen.service;
import org.alisonnguyen.model.Restaurant;
import org.alisonnguyen.repository.RestaurantRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MatchingService {
    private RestaurantRepo restaurantRepo;
    private Map<String, Restaurant> restaurantData;

    public MatchingService(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
        restaurantData = restaurantRepo.getAllData();
    }

    private List<Restaurant> filterRestaurants(Predicate<Restaurant> predicate) {
        List<Restaurant> matches = new ArrayList<>();
        restaurantData.forEach((k, v) -> {
            if (predicate.test(v)) {
                matches.add(v);
            }
        });
        return matches;
    }

    public List<Restaurant> matchByName(String inputRestaurant) {
        List<Restaurant> filteredRestaurants = filterRestaurants(r -> r.getCuisine().toLowerCase().contains(inputRestaurant.toLowerCase()));
        return sortRestaurants(filteredRestaurants, Restaurant:: getName, inputRestaurant);
    }

    public List<Restaurant> matchByRating(int preferredRating) {
        return filterRestaurants(r -> r.getCustomerRating() >= preferredRating);
    }

    public List<Restaurant> matchByDistance(double distance) {
        return filterRestaurants(r -> r.getDistance() <= distance);
    }

    public List<Restaurant> matchByBudget(double price) {
        return filterRestaurants(r -> r.getPrice() <= price);
    }

    public List<Restaurant> matchByCuisine(String inputCuisine) {
        List<Restaurant> filteredRestaurants = filterRestaurants(r -> r.getCuisine().toLowerCase().contains(inputCuisine.toLowerCase()));
        return sortRestaurants(filteredRestaurants, Restaurant:: getCuisine, inputCuisine);
    }

    private List<Restaurant> sortRestaurants(List<Restaurant> restaurants, Function<Restaurant, String> keyExtractor, String input) {
        String inputLower = input.toLowerCase();

        return restaurants.stream()
                .sorted((r1, r2) -> {
                    String value1 = keyExtractor.apply(r1).toLowerCase();
                    String value2 = keyExtractor.apply(r2).toLowerCase();

                    boolean startsWith1 = value1.startsWith(inputLower);
                    boolean startsWith2 = value2.startsWith(inputLower);

                    if (startsWith1 && !startsWith2) {
                        return -1; // r1 comes before r2
                    } else if (!startsWith1 && startsWith2) {
                        return 1; // r2 comes before r1
                    } else {
                        return value1.compareTo(value2); // lexicographical order
                    }
                })
                .collect(Collectors.toList());
    }

    public List<Restaurant> matchByCriteria(String name, Integer rating, Integer distance, Integer price, String cuisine) {
        List<Predicate<Restaurant>> predicates = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            predicates.add(r -> r.getName().toLowerCase().contains(name.toLowerCase()));
        }
        if (rating != null) {
            predicates.add(r -> r.getCustomerRating() >= rating);
        }
        if (distance != null) {
            predicates.add(r -> r.getDistance() <= distance);
        }
        if (price != null) {
            predicates.add(r -> r.getPrice() <= price);
        }
        if (cuisine != null && !cuisine.isEmpty()) {
            predicates.add(r -> r.getCuisine().toLowerCase().contains(cuisine.toLowerCase()));
        }

        Predicate<Restaurant> combinedPredicate = predicates.stream()
                .reduce(x -> true, Predicate::and);


        return filterRestaurants(combinedPredicate);
    }
}
