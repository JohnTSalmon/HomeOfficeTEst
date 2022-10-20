package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class CommonPageObject {

    private static ChromeDriver driver = null;
    private static WebElement currentElement;

    static {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    static void open(String url ) {
        driver.get(url);
        driver.manage().window().maximize();
    }
    static void findElementById(String id) {
        currentElement = driver.findElement(By.id(id));
    }
    static void findElementByName(String name) {
        currentElement = driver.findElement(By.name(name));
    }

    public static void enterText(String text) {
        currentElement.sendKeys(text);
    }
    static void findElementByClassName(String className) {
        currentElement = driver.findElement(By.className(className));
    }

    static void findElementByVisibleText(String visibleText) {
        currentElement = driver.findElement(By.xpath("//*[text()='"+visibleText+"']"));
    }
    static void findElementByLinkText(String linkText) {
        currentElement = driver.findElement(By.linkText(linkText));
    }
    static void click() {
        currentElement.click();
    }

    // Select following sibling regardless of type
    static void traverse() {
        currentElement = currentElement.findElement(By.xpath("following-sibling::*[1]"));
    }

    static void textMatches(String expectedText) {
        String actualText = currentElement.getText();
        assertThat(expectedText, equalTo(actualText));
    }
    static void textContains(String expectedText) {
        String actualText = currentElement.getText();
        assertThat(actualText, containsString(expectedText));
    }
}
