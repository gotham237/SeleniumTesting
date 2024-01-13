package seleniumE2E;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CompareTwoComponents_AddToCart extends BaseTest{

    By shopByCategoryButton = By.xpath("//div[@id='entry_217832']//a[@aria-label='Shop by Category']");
    By componentsCategory = By.xpath("//*[@id=\"widget-navbar-217841\"]/ul/li[2]/a");
    ////div[@id='entry_212408']//button[@title='Compare this Product']
    By CanonImage = By.xpath("//*[@id=\"mz-product-grid-image-30-212408\"]/div/div[1]/img");
    By iMacImage = By.xpath("//*[@id=\"mz-product-grid-image-41-212408\"]/div/div[1]/img");
    By CanonEOS5DCompareButton = By.xpath("//*[@id=\"entry_212408\"]/div/div[3]/div/div[1]/div[2]/button[4]");
    By iMacCompareButton = By.xpath("//*[@id=\"entry_212408\"]/div/div[10]/div/div[1]/div[2]/button[4]");
    By compareButton = By.xpath("//*[@id=\"notification-box-top\"]/div/div[2]/a");
    By addToCartButton = By.xpath("//*[@id=\"content\"]/table/tbody[2]/tr/td[3]/input");
    By viewCartButton = By.xpath("//*[@id=\"notification-box-top\"]/div/div[2]/div[2]/div[1]/a");
    By checkoutButton = By.xpath("//*[@id=\"content\"]/div[2]/a[2]");

    @Test
    public void test4_CompareTwoComponents_AddToCart() {
        click(shopByCategoryButton);
        click(componentsCategory);

        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        action.moveToElement(find(CanonImage)).perform();
        click(CanonEOS5DCompareButton);

        action.moveToElement(find(iMacImage)).perform();
        click(iMacCompareButton);

        click(compareButton);
        click(addToCartButton);

        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartButton));
        click(viewCartButton);
        click(checkoutButton);
    }
}
