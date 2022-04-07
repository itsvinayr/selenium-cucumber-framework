package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utils.TestContextSetup;

public class HomePageStepDefinition {

    private final TestContextSetup testContextSetup;

    public HomePageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Given("user lands on home page")
    public void user_lands_on_home_page() {
        testContextSetup.getTestBase().webDriverManager();
        testContextSetup.getPageObjectManager().getHomePage();
    }

    @When("^user search for (.+)$")
    public void user_search_for(String value) {
        HomePage homePage = testContextSetup.getPageObjectManager().getHomePage();
        homePage.searchProduct(value);
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnFirstProduct();
    }
}
