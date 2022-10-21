import city.City;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("Задача ВС Java Сбер.csv");
        ArrayList<City> cites = City.putListCities(file);
        String marker = "";
        Scanner console = new Scanner(System.in);
        while (!marker.equals("1")) {
            System.out.println("1. Press '1' and 'Enter' for exit;");
            System.out.println("2. Press '2' and 'Enter' for print all cites;");
            System.out.println("3. Press '3' and 'Enter' for sorting list citi2es by name;");
            System.out.println("4. Press '4' and 'Enter' for sorting list cities by districts and name;");
            System.out.println("5. Press '5' and 'Enter' for search city with the largest number of inhabitants;");
            System.out.println("6. Press '6' and 'Enter' for print the number of cities in each region;");
            marker = console.nextLine();
            if (marker.equals("1")) {
                System.out.println("Your press 1. Buy buy;");
            } else if (marker.equals("2")) {
                City.printCites(cites);
            } else if (marker.equals("3")) {
                Collections.sort(cites);
                System.out.println("Sorting list by name Ok;");
            } else if (marker.equals("4")) {
                City.districtSort(cites);
                System.out.println("Sorting list by district and name;");
            } else if (marker.equals("5")) {
              City cityWithMaxPopulation = City.searchCityMaxPopulation(cites);
                System.out.println("[" + cityWithMaxPopulation.getId() + "]=" + cityWithMaxPopulation.getPopulation());
            } else if (marker.equals("6")){
                City.printCountCitiesInDistricts(cites);
            } else {
                System.out.println("Incorrect command. Repeat input;");
            }
        }
    }
}
