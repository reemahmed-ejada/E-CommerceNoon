package TestCases;

import base.BasePage;
import Pages.SearchPage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static utils.ExtentReportManager.extent;

public class SearchTest extends BasePage {

    @BeforeMethod
    public void initTest(){
      //  setUp();
    }
    @Test(groups = {"Sanity"})
    public void testSearchFunctionality() {
        SearchPage searchPage = new SearchPage(driver);

        // Step 1: Enter a search term
        searchPage.enterSearchKeyword("laptop");

        // Step 2: Click on the Enter button
        // searchPage.clickEnterButton();

        // Step 3: Verify if the search results are correct
        String pageTitle = searchPage.getSearchResult();
        Assert.assertTrue(pageTitle.contains("laptop"), "Search results are not correct");
    }

    @Test
    public void testSearchWithFilterBrand() {
        SearchPage searchPage = new SearchPage(driver);
        // call the function will apply search and then filter the brand
        searchPage.selectBrand("laptop");

        //  Verify if the search results have the filter applied
        String pageTitle = searchPage.getSearchResult();
        Assert.assertTrue(pageTitle.contains("HP"), "Search results are not correct after applying filter");
    }

    @Test
    public void testSearchWithprice() {

       // extentTest = extent.createTest("Login Test");
        //extentTest.log(Status.INFO, "Starting login test");
        //try {
            SearchPage searchPage = new SearchPage(driver);
            // call the function will apply search and then filter the brand
            searchPage.FilterwithPrices("laptop");

            //  Verify if the search results have the filter applied
            String pageTitle = searchPage.getSearchResult();
            Assert.assertTrue(pageTitle.contains("laptop"), "Search results are not correct after applying filter");
            extentTest.log(Status.PASS, "Login successful");
        //} catch (Exception e) {
          //  extentTest.log(Status.FAIL, "Login failed");
            //throw e;
        //}
    }
}
