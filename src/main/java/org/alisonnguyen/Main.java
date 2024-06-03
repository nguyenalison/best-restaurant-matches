package org.alisonnguyen;

import org.alisonnguyen.model.Restaurant;
import org.alisonnguyen.repository.CuisineRepo;
import org.alisonnguyen.repository.RestaurantRepo;
import org.alisonnguyen.service.MatchingService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String FILE = "src/main/resources/data/restaurants.csv";

        RestaurantRepo restaurantRepo = new RestaurantRepo(FILE);
        MatchingService matchingService = new MatchingService(restaurantRepo);

        Scanner scanner = new Scanner(System.in);
        String userInputRestaurant, userInputCuisine;
        int userInputRating, userInputDistance, userInputPrice;

        System.out.println("Enter the name of the restaurant (Leave blank if none): ");
        userInputRestaurant = scanner.nextLine();

        userInputRating = validNumericInput(scanner, "rating", Integer::parseInt,0);

        userInputDistance = validNumericInput(scanner, "distance", Integer::parseInt,0);

        userInputPrice = validNumericInput(scanner, "max budget", Integer::parseInt,0);

        System.out.println("Enter the preferred cuisine (Leave blank if none): ");
        userInputCuisine = scanner.nextLine();

        System.out.println( ((Object)userInputRating).getClass().getSimpleName());
        System.out.println("Name: " + userInputRestaurant + "\nrating: " + userInputRating
                + "\nDistance: " + userInputDistance + "\nPrice: " + userInputPrice + "\nCuisine: " + userInputCuisine);
//        System.out.println(matchingService.matchByCriteria(userInputRestaurant,
//                userInputRating,
//                userInputDistance,
//                userInputPrice,
//                userInputCuisine));
        System.out.println(matchingService.matchByCuisine("m"));


    }

    private static <T extends Number> T validNumericInput(Scanner scan, String prompt,
                                                          java.util.function.Function<String, T> parser, T defaultValue){
        T input = null;
        while (input == null || input.doubleValue() < 0) {
            System.out.println("Enter your preferred " + prompt + " (Leave blank if none): ");
            String userInput = scan.nextLine();
            if (userInput.isEmpty()) {
                return defaultValue;
            }
            try {
                input = parser.apply(userInput);
                if (input.doubleValue() < 0) {
                    System.out.println("Value cannot be negative. Please enter a non-negative value.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return input;
    }
}