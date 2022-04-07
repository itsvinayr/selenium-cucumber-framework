package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

    private final WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By priceToPay =  By.xpath("//*[@data-a-color='price' and @class='a-price a-text-price a-size-medium apexPriceToPay']");

    public void getPrice(){
        String price = driver.findElement(priceToPay).getText().trim();
        System.out.println("Price of the product is "+price);
    }

}
