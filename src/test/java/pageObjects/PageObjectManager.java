package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public ProductDetailsPage getProductDetailsPage() {
        return new ProductDetailsPage(driver);
    }
}
