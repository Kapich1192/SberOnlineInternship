package city;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class City implements Comparable<City>{
    /*fields*/
    private Long id;
    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;
    /*constructors*/
    public City(){}
    /*setters*/
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }
    /*getters*/
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getRegion() {
        return region;
    }
    public String getDistrict() {
        return district;
    }
    public int getPopulation() {
        return population;
    }
    public String getFoundation() {
        return foundation;
    }
    /*methods*/
    /*toString*/
    @Override
    public String toString() {
        return "City{name='" + name + "',region='" + region +
                "',district='" + district + "',population=" + population +
                ",foundation='" + foundation + "'}";
    }
    /*compareTo*/
    @Override
    public int compareTo(City o) {
        return this.getName().charAt(0) - o.getName().charAt(0);
    }
    /*static methods*/
    public static void printCites (ArrayList<City> cites) {
        for (City i : cites)    {
            System.out.printf("%s",i.toString());
            System.out.println("");
        }
    }

    public static ArrayList<City> putListCities(File file) throws IOException {
        String temp;
        Long tempId;
        String tempName;
        String tempRegion;
        String tempDistrict;
        int tempPopulation;
        String tempFoundation;
        Scanner console;
        Scanner stringScanner;
        console = new Scanner(file);
        ArrayList<City> cites = new ArrayList<>();
        do {
            City tempCity = new City();
            temp = console.nextLine();
            /*id*/
            tempId = Long.parseLong(putPart(temp));
            tempCity.setId(tempId);
            /*name*/
            temp = temp.substring(("" + tempId).length() + 1);
            tempName = putPart(temp);
            tempCity.setName(tempName);
            /*region*/
            temp = temp.substring(tempName.length() + 1);
            tempRegion = putPart(temp);
            tempCity.setRegion(tempRegion);
            /*district*/
            temp = temp.substring(tempRegion.length()+1);
            tempDistrict = putPart(temp);
            tempCity.setDistrict(tempDistrict);
            /*population*/
            temp = temp.substring(tempDistrict.length() + 1);
            tempPopulation = Integer.parseInt(putPart(temp));
            tempCity.setPopulation(tempPopulation);
            /*foundation*/
            temp = temp.substring((""+tempPopulation).length() + 1);
            tempFoundation = temp;
            tempCity.setFoundation(tempFoundation);
            cites.add(tempCity);
        } while (console.hasNextLine());
        return cites;
    }

    public static String putPart(String str) {
        String s = "";
        char temp = ' ';
        int i = 0;
        while (temp != ';'){
            temp = str.charAt(i);
            if (temp != ';')
                s = s + temp;
            i++;
        }
        return s;
    }

    public static void districtSort(ArrayList<City> cites) {
        Comparator districtComparator = new DistrictCityComparator();
        Collections.sort(cites, districtComparator);
    }

    public static City searchCityMaxPopulation(ArrayList<City> cities) {
        City temp = cities.get(0);
        for (City c:
             cities) {
            if (temp.getPopulation() < c.getPopulation())
                temp = c;
        }
        return temp;
    }

    public static void printCountCitiesInDistricts(ArrayList<City> cities) {
        HashMap<String,Integer> result = new HashMap<>();
        for (City c : cities) {
            if (result.keySet().contains(c.getRegion())) {
                result.put(c.getRegion(),result.get(c.getRegion()) + 1);
            } else {
                result.put(c.getRegion(),1);
            }
        }
        for (String s : result.keySet())
            System.out.println(s + " - " + result.get(s));
    }
}
