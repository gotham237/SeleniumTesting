package seleniumE2E;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCart_Checkout extends BaseTest{

    By myAccountMenu = By.xpath("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a/div/span");
    By email = By.id("input-email");
    By password = By.id("input-password");
    By loginButton = By.xpath("//input[@type='submit' and @value='Login']");
    By searchField = By.xpath("//div[@id='entry_217822']//input[@aria-label='Search For Products']");
    By searchButton = By.xpath("//div[@id='search']//button[text()='Search']");
    By iPhone = By.xpath("//div[@id='entry_212469']//a[text()='iPhone']");
    By addToCartButton = By.xpath("//div[@id='entry_216842']//button[text()='Add to Cart']");
    By checkoutButton = By.xpath("//div[@id='notification-box-top']//a[contains(text(),'Checkout')]");


    @Test
    public void test2_AddToCart_Checkout() {
        click(myAccountMenu);
        type(email, "szymon@gmail.com");
        type(password, "Test1234");
        click(loginButton);
        type(searchField, "iPhone");
        click(searchButton);
        click(iPhone);
        click(addToCartButton);

        // wait max 5 sec for the checkoutButton to show up
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton));
        click(checkoutButton);
    }
}
