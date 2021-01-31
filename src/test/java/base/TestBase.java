package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void Initialize() {
        System.setProperty("webdriver.gecko.driver", "./src/test/java/drivers/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void CleanUp() {
        if (driver != null) {
            driver.close();
        }
    }
}
