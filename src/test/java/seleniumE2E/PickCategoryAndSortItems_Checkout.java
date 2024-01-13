package seleniumE2E;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class PickCategoryAndSortItems_Checkout extends BaseTest{

    By shopByCategoryButton = By.xpath("//div[@id='entry_217832']//a[@aria-label='Shop by Category']");
    By camerasCategory = By.xpath("//*[@id=\"widget-navbar-217841\"]/ul/li[2]/a");
    By sortField = By.id("input-sort-212403");
    By HTCTouchHD = By.xpath("//div[@id='entry_212408']//a[text()='HTC Touch HD']");
    By addToCartButton = By.xpath("//div[@id='entry_216842']//button[text()='Add to Cart']");
    By checkoutButton = By.xpath("//div[@id='notification-box-top']//a[contains(text(),'Checkout')]");

    @Test
    public void test3_PickCategoryAndSortItems_Checkout() {
        click(shopByCategoryButton);
        click(camerasCategory);
        WebElement selectElement = find(sortField);

        // Create a Select object to interact with the dropdown and choose Popular option
        Select dropdown = new Select(selectElement);
        dropdown.selectByVisibleText("Popular");
        click(HTCTouchHD);

        click(addToCartButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton));
        click(checkoutButton);
    }


}
