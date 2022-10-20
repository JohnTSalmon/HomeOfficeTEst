package pageobjects;

import car.Car;
import org.openqa.selenium.Keys;

import static pageobjects.CommonPageObject.*;

public class Cazoo implements CarCheck {

    private static final String URL = "https://www.cazoo.co.uk/sell-my-car/";
    private static boolean cookiesAccepted = false;

    // Element Locators
    private static final String COOKIE_BUTTON_TEXT = "Accept All";
    private static final String SEARCH_BOX_ID = "vrm";
    private static final String RESULTS_CONTAINER_ID = "main-content";

    public void open() {

        CommonPageObject.open(URL);
        // Close cookies screen
        if (!cookiesAccepted) {
            findElementByVisibleText(COOKIE_BUTTON_TEXT);
            click();
            cookiesAccepted = true;
        }
    }

    @Override
    public void enter( String registration ) {
        findElementById(SEARCH_BOX_ID);
        enterText(registration);
        enterText(String.valueOf(Keys.RETURN));
    }
    public void check(Car car) {
        enter(car.getRegistration());
        findElementById(RESULTS_CONTAINER_ID);
        textContains(car.getRegistration());
        textContains(car.getMake());
    }
}

