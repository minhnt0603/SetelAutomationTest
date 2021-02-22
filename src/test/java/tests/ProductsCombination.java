package tests;

import base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.amazon_pages.*;
import pages.ebay_pages.*;
import utils.GlobalVariables;

public class ProductsCombination extends TestBase {

    private static String PRODUCT_IPHONE_11 = "iPhone 11";
    private static String EBAY_PRODUCT_TITLE = "NEW SEALED Apple iPhone 11 64GB " +
            "Black (AT&T/Cricket/Straight Talk) 1yr warranty";
    private static String AMAZON_PRODUCT_TITLE = "Apple iPhone 11 Pro, 64GB, Gold - for Verizon (Renewed)";

    @Test(priority = 1)
    public void verifyProductOnEbay() {
        // init ebay pages
        ebay_HomePage ebay_homePage = PageFactory.initElements(driver, ebay_HomePage.class);
        ebay_SearchResultPage ebay_searchResutlPage = PageFactory.initElements(driver, ebay_SearchResultPage.class);

        // Open ebay
        driver.navigate().to(GlobalVariables.EBAY_URL);

        // Search for "iPhone 11"
        ebay_homePage.searchProduct(PRODUCT_IPHONE_11);

        // verify the search page is displayed correctly
        ebay_searchResutlPage.verifySearchPageDisplaysCorrectly(PRODUCT_IPHONE_11);
        ebay_searchResutlPage.verifyProductIsDisplayed(EBAY_PRODUCT_TITLE);
    }

    @Test(priority = 2)
    public void verifyProductOnAmazon() {
        // init amazon pages
        amazon_HomePage amazon_homePage = PageFactory.initElements(driver, amazon_HomePage.class);
        amazon_SearchResultPage amazon_searchResultPage = PageFactory.initElements(driver, amazon_SearchResultPage.class);

        // Open amazon
        driver.navigate().to(GlobalVariables.AMAZON_URL);

        // Search for "iPhone 11"
        amazon_homePage.searchProduct(PRODUCT_IPHONE_11);

        // verify the search page is displayed correctly
        amazon_searchResultPage.verifySearchPageDisplaysCorrectly(PRODUCT_IPHONE_11);
        amazon_searchResultPage.verifyProductIsDisplayed(AMAZON_PRODUCT_TITLE);
    }
}
