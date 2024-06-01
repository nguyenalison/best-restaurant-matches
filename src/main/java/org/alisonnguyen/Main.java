package org.alisonnguyen;

import org.alisonnguyen.model.Restaurant;
import org.alisonnguyen.repository.CuisineRepo;
import org.alisonnguyen.repository.RestaurantRepo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        RestaurantRepo restaurantRepo = new RestaurantRepo("src/main/resources/data/restaurants.csv");
        Map<String, Restaurant> restaurantData = restaurantRepo.getAllData();
//        restaurantData.forEach((k,v) -> System.out.println(v));

        Scanner scanner = new Scanner(System.in);
        String userInputRestaurant;
        int userInputRating, userInputDistance, userInputPrice, userInputCuisine;

        System.out.println("Enter the name of the restaurant (Leave blank if none): ");
        userInputRestaurant = scanner.nextLine();


//        System.out.println("Enter your preferred rating (Leave blank if none): ");
//        userInputRating = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println("Enter your preferred distance (Leave blank if none): ");
//        userInputDistance = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println("Enter your max budget (Leave blank if none): ");
//        userInputPrice = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println("Enter the preferred cuisine (Leave blank if none): ");
//        userInputCuisine = scanner.nextInt();
//        scanner.nextLine();

    }
}