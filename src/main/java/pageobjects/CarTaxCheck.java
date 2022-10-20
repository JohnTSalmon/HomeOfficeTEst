package pageobjects;

import car.Car;

import java.util.List;

import static pageobjects.CommonPageObject.*;

public class CarTaxCheck implements CarCheck {

    // Element Locators
    private static final String SEARCH_BOX ="vrm-input";
    private static final String FULL_CHECK_BUTTON_TEXT ="Get a Full Check";
    private static final String CHECK_VEHICLE_BUTTON_TEXT ="Check Vehicle";

    private static final String URL = "https://cartaxcheck.co.uk/";

    // Results page locators.  These are text label elements, the siblings of which
    // contain the variable text
    private static final String REGISTRATION = "Registration";
    private static final String VEHICLE = "Vehicle";
    private static final String YEAR = "Year";
    private static final String COLOUR = "Colour";


    public void open() {

        CommonPageObject.open(URL);
    }
    public void check( List<Car> cars) {
        for(Car car : cars) {
            enter(car.getRegistration());
            findElementByVisibleText(REGISTRATION);
            traverse();
            textMatches(car.getRegistration());
            findElementByVisibleText(VEHICLE);
            traverse();
            textContains(car.getMake());
            textContains(car.getModel());
            findElementByVisibleText(YEAR);
            traverse();
            textMatches(car.getYear());
            findElementByVisibleText(COLOUR);
            traverse();
            textMatches(car.getColour());
            open();
        }
    }

    public void enter( String registration ) {
        findElementByLinkText(FULL_CHECK_BUTTON_TEXT);
        click();
        findElementById(SEARCH_BOX);
        enterText(registration);
        findElementByVisibleText(CHECK_VEHICLE_BUTTON_TEXT);
        click();
    }
}
