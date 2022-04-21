package stepDefinitions;

import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pageObjects.ProductDetailsPage;
import utils.TestContextSetup;

public class ProductDetailsPageStepDefinition {
    private final TestContextSetup testContextSetup;
    private static final Logger logger = LogManager.getLogger(HomePageStepDefinition.class.getName());

    public ProductDetailsPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Then("open first one from the product list and get the price")
    public void open_first_one_from_the_product_list_and_get_the_price() {
        testContextSetup.getGenericUtils().switchWindow();
        ProductDetailsPage productDetailsPage = testContextSetup.getPageObjectManager().getProductDetailsPage();
        try {
            productDetailsPage.getPrice();
            logger.debug("Price of the product is displayed");
        }catch (Throwable t){
            logger.error("Couldn't retrieve product price");
            Assert.fail("Couldn't retrieve product price");
        }
    }
}
