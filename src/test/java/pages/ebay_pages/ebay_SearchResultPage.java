package pages.ebay_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ebay_SearchResultPage {
    WebDriver driver;
    WebDriverWait wait;

    public ebay_SearchResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver,20);
    }

    /** Capture web elements in Search Result Page of Ebay */
    @FindBy(how = How.CLASS_NAME, using = "srp-controls__count-heading")
    WebElement NUMBER_OF_RESULT_LABEL;
    @FindBy(how = How.XPATH, using = "//h1[@class='srp-controls__count-heading']/span[2]")
    WebElement SEARCH_PRODUCT_LABEL;
    @FindBy(how = How.XPATH, using = "//div[@id='srp-river-results']/ul/li[1]//h3[@class='s-item__title']")
    WebElement FIRST_ITEM_TITLE;

    /** Actions on Search Result Page of Ebay */
    public void verifySearchPageDisplaysCorrectly(String searchText) {
        wait.until(ExpectedConditions.titleIs(searchText + " | eBay"));
        Assert.assertEquals(driver.getTitle(), (searchText + " | eBay"));

        wait.until(ExpectedConditions.textToBePresentInElement(NUMBER_OF_RESULT_LABEL, "results for"));
        Assert.assertEquals(SEARCH_PRODUCT_LABEL.getText(), searchText);
    }

    public void verifyProductIsDisplayed(String productTitle) {
        wait.until(ExpectedConditions.visibilityOf(FIRST_ITEM_TITLE));
        Assert.assertEquals(FIRST_ITEM_TITLE.getText(), productTitle);
    }
}
