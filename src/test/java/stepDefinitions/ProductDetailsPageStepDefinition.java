package stepDefinitions;

import io.cucumber.java.en.Then;
import pageObjects.ProductDetailsPage;
import utils.TestContextSetup;

public class ProductDetailsPageStepDefinition {
    private final TestContextSetup testContextSetup;

    public ProductDetailsPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Then("open first one from the product list and get the price")
    public void open_first_one_from_the_product_list_and_get_the_price() {
        testContextSetup.getGenericUtils().switchWindow();
        ProductDetailsPage productDetailsPage = testContextSetup.getPageObjectManager().getProductDetailsPage();
        productDetailsPage.getPrice();
    }
}
