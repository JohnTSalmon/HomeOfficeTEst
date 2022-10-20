package stepdefs;

import car.Car;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageobjects.CarTaxCheck;
import pageobjects.Cazoo;
import utils.RegistrationFileReader;

import java.io.FileNotFoundException;
import java.util.List;

public class StepDefs {
    private List<Car> cars;
    private Car car;
    private CarTaxCheck carTaxCheck;
    private Cazoo cazoo;
    @Given("^I have a file of car registrations$")
    public void getRegistrations() throws FileNotFoundException {
        cars = RegistrationFileReader.readCarDetails();
    }

    // CAR TAX CHECK

    @Given("^I access the Car Tax Check Website$")
    public void accessCarTaxCheckWebsite() {
        carTaxCheck = new CarTaxCheck();
        carTaxCheck.open();
    }

    @Given("^Car Tax Check displays the correct details$")
    public void correctCarTaxCheckDetailsDisplayed() {
        carTaxCheck.check(cars);
    }

    // CAZOO

    @Given("The car {string} and {string} and {string} and {string} and {string}")
    public void theRegistrationRegistrationAndMakeAndModelAndYear(String registration, String make, String model, String colour, String year ) {
        car = new Car(registration, make,model,colour,year );
        cazoo = new Cazoo();
    }
    @When("I access the Cazoo Website")
    public void accessTheCazooWebsite() {
        cazoo.open();
    }

    @Given("^Cazoo displays the correct details$")
    public void correctCazooDetailsDisplayed() {
        cazoo.check(car);
    }
}
