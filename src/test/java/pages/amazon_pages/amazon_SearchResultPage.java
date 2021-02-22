package pages.amazon_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class amazon_SearchResultPage {
    WebDriver driver;
    WebDriverWait wait;

    public amazon_SearchResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver,20);
    }

    /** Capture web elements in Search Result Page of Ebay */
    @FindBy(how = How.XPATH, using = "//div[@class='a-section a-spacing-small a-spacing-top-small']/span[3]")
    WebElement SEARCH_PRODUCT_LABEL;
    @FindBy(how = How.XPATH, using = "//span[@cel_widget_id='MAIN-SEARCH_RESULTS-1']" +
            "//div[@class='sg-row'][2]//span[@class='a-size-medium a-color-base a-text-normal']")
    WebElement FIRST_ITEM_TITLE;

    /** Actions on Search Result Page of Ebay */
    public void verifySearchPageDisplaysCorrectly(String searchText) {
        wait.until(ExpectedConditions.titleIs("Amazon.com : " + searchText));
        Assert.assertEquals(driver.getTitle(), ("Amazon.com : " + searchText));
        Assert.assertEquals(SEARCH_PRODUCT_LABEL.getText(), '"' + searchText + '"');
    }

    public void verifyProductIsDisplayed(String productTitle) {
        wait.until(ExpectedConditions.visibilityOf(FIRST_ITEM_TITLE));
        Assert.assertEquals(FIRST_ITEM_TITLE.getText(), productTitle);
    }
}
