package TestCases;

import base.BaseTest;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
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
        SearchPage searchPage = new SearchPage(driver);
        // call the function will apply search and then filter the brand
        searchPage.FilterwithPrices("laptop");

        //  Verify if the search results have the filter applied
        String pageTitle = searchPage.getSearchResult();
        Assert.assertTrue(pageTitle.contains("laptop"), "Search results are not correct after applying filter");
    }
}
