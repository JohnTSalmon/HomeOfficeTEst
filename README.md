# HomeOfficeTest

I have completed the test with the registration configuration file supplied.
This has been implemented as a Maven project with Cucumber feature files :
1 ) cartaxcheck.feature which reads the comma-separated registration file
2 ) cazoo.feature which reads the registration details from a Cucumber data table
The RegistrationFileReader.readCarDetails() method will read multiple data files as per the request for extensibility
I have not included any Java Design Patterns although I have used Builder and Singleton extensively.
I did however include an interface to demonstrate understanding.
Note that CommonPageObject abstracts the Selenium / WebDriver details away from the Page Objects - this I have found useful for expediting automation coding.
