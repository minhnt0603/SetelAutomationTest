package pages.amazon_pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amazon_HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public amazon_HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver,20);
    }

    /** Capture web elements in Home Page of Amazon */
    @FindBy(how = How.ID, using = "twotabsearchtextbox")
    WebElement SEARCH_TEXTBOX;

    /** Actions on Home Page of Amazon */
    public void searchProduct(String productName) {
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_TEXTBOX));
        SEARCH_TEXTBOX.sendKeys(productName);
        SEARCH_TEXTBOX.sendKeys(Keys.ENTER);
    }
}
