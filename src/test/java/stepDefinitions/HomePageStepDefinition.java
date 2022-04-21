package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.HomePage;
import utils.TestContextSetup;

public class HomePageStepDefinition {

    private final TestContextSetup testContextSetup;
    private static final Logger logger = LogManager.getLogger(HomePageStepDefinition.class.getName());

    public HomePageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Given("user lands on home page")
    public void user_lands_on_home_page() {
        testContextSetup.getTestBase().webDriverManager();
        logger.info("Driver initialized successfully");
        testContextSetup.getPageObjectManager().getHomePage();
        logger.info("Landed on Home Page");
    }

    @When("^user search for (.+)$")
    public void user_search_for(String value) {
        HomePage homePage = testContextSetup.getPageObjectManager().getHomePage();
        homePage.searchProduct(value);
        logger.debug("Searched for product with value : "+value);
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnFirstProduct();
        logger.info("Clicked on First Product Link");
    }
}
