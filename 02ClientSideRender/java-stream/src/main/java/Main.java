import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    //fetch data
    public static List<Person> init() throws FileNotFoundException {
        String JSON_PATH = "person-list.json";
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader(JSON_PATH));
        Type type = new TypeToken<List<Person>>(){}.getType();
        List<Person> myList = gson.fromJson(br, type);
        return myList;
    }

    public static void main(String[] args) throws FileNotFoundException {

        List<Person> list = init();
        //20-30 age
        List<Person> filterAge = list.stream()
                .filter(person -> person.getAge() >= 20 && person.getAge() <= 30)
                .collect(Collectors.toList());
        System.out.println(filterAge);

        //average age
        double avg = list.stream().mapToInt(Person::getAge).average().getAsDouble();
        System.out.printf("Average age all countries: %.2f \n", avg);

        //average age for each nationality
        //break to list of each nationality
        //get avg with in loop
        System.out.println("Average age by Country: ");
        Set<String> countries = list.stream().map(Person::getNationality).collect(Collectors.toSet());
        for (String country : countries) {
            double avgByCountry = list.stream()
                    .filter(person -> person.getNationality().equals(country))
                    .mapToInt(Person::getAge)
                    .average()
                    .getAsDouble();
            System.out.printf("%s = %.1f \n", country, avgByCountry);
        }
    }

}
