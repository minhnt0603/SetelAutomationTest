package pages.ebay_pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ebay_HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public ebay_HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver,20);
    }

    /** Capture web elements in Home Page of Ebay */
    @FindBy(how = How.ID, using = "gh-ac")
    WebElement SEARCH_TEXTBOX;

    /** Actions on Home Page of Ebay */
    public void searchProduct(String productName) {
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_TEXTBOX));
        SEARCH_TEXTBOX.sendKeys(productName);
        SEARCH_TEXTBOX.sendKeys(Keys.ENTER);
    }
}
