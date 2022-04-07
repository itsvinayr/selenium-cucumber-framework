package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final By searchBox = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
    private final By firstProductLink = By.xpath("//*[@data-index=3]");

    public void searchProduct(String productName){
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
    }

    public void clickOnFirstProduct(){
        driver.findElement(firstProductLink).click();
    }

}
