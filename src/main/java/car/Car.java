package car;

import java.util.List;

public class Car {

    public enum index {
        REGISTRATION,
        MAKE,
        MODEL,
        COLOUR,
        YEAR;
    }

    private String registration;
    private String make;
    private String model;
    private String colour;
    private String year;

    public Car(String registration, String make, String model, String colour, String year) {
        this.registration = registration;
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.year = year;
    }

    public Car(List<String> car) {
        try {
            this.registration = car.get(index.REGISTRATION.ordinal());
            this.make = car.get(index.MAKE.ordinal());
            this.model = car.get(index.MODEL.ordinal());
            this.colour = car.get(index.COLOUR.ordinal());
            this.year = car.get(index.YEAR.ordinal());
        }
        catch( IndexOutOfBoundsException ioobe) {
            throw new IllegalArgumentException("Car : Invalid parameters. Should be : registration,make,model,colour,year. Was : "+car.toString());
        }
    }

    public String getRegistration() {
        return registration;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public String getYear() {
        return year;
    }
}
