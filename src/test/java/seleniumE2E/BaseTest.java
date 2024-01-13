package seleniumE2E;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    //setup to run tests locally
    protected WebDriver driver;

    @Parameters(value={"Browser"})
    @BeforeMethod
    public void setUp(String browser) {
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }


        driver.manage().window().maximize();
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }

    //setup to run tests with selenium grid and lambdaTest
//    protected WebDriver driver;
//    private String username = "";
//    private String accessKey = "";
//    private String hub = "@hub.lambdatest.com/wd/hub";
//    DesiredCapabilities caps = new DesiredCapabilities();
//
//    @Parameters(value = {"Browser", "Version", "Platform"})
//    @BeforeMethod
//    public void setUp(String browser, String version, String platform) {
//        caps.setCapability("build", "1.0");
//        caps.setCapability("name", "Selenium E2E");
//        caps.setCapability("platform", platform);
//        caps.setCapability("browserName", browser);
//        caps.setCapability("network", true);
//        caps.setCapability("console", true);
//        caps.setCapability("visual", true);
//        caps.setCapability("video", true);
//
//        try {
//            driver = new RemoteWebDriver(
//                    new URL("https://" + username + ":" +
//                            accessKey + hub), caps);
//
//        } catch(MalformedURLException exception) {
//            exception.printStackTrace();
//        }
//        driver.get("https://ecommerce-playground.lambdatest.io/");
//    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void type(By locator, String text) {
        find(locator).sendKeys(text);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
