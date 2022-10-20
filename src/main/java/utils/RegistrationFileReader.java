package utils;

import car.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RegistrationFileReader {

    // Read all files in the registrations directory to allow
    // for multiple input files. Single Car object list returned.

    public static List<Car> readCarDetails() throws FileNotFoundException {
        List<Car> cars = new ArrayList<>();
        List <String> carEntry;
        File dir = new File("src/main/resources/cars");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File file : directoryListing) {
                Scanner sc = new Scanner(new File(file.getAbsolutePath()));
                while (sc.hasNext())
                {
                    carEntry = new ArrayList<>();
                    Collections.addAll(carEntry, sc.nextLine().split(","));
                    cars.add(new Car(carEntry));
                }
                sc.close();
            }
        }
        return cars;
    }
}
