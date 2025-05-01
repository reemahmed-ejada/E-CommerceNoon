package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    private WebDriver driver;

    // Locators
    private By searchBox = By.cssSelector("input[class='DesktopInput_searchInput__R44H1']");
    private By searchButton = By.cssSelector("button[type='submit']");

    private By filterDropdown = By.cssSelector("div.filter-dropdown");

    private By brand = By.xpath("//span[text()='Brand']");

    private By selectedBrand = By.xpath("//button[text()='HP']");

    private By price = By.xpath("//span[text()='Price (EGP)']");

    private By minPrice = By.xpath("//input[@name='min']");
    private By maxPrice = By.xpath("//input[@name='max']");
    private By goButton = By.xpath("//button[text()='Go']");

    private By filterOption = By.cssSelector("span.filter-option");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchKeyword(String keyword) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.clear();
        searchInput.sendKeys(keyword);
        searchInput.sendKeys(Keys.ENTER);

    }

    public void clickEnterButton() {
        // driver.sendKeys(Keys.ENTER);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void applyFilter(String filterName) {
        WebElement filter = driver.findElement(filterDropdown);
        filter.click();

        WebElement filterOptionElement = driver.findElement(By.xpath("//span[contains(text(), '" + filterName + "')]"));
        filterOptionElement.click();
    }

    public void selectBrand(String searchname) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.clear();
        searchInput.sendKeys(searchname);
        searchInput.sendKeys(Keys.ENTER);

        driver.findElement(brand).click();
        driver.findElement(selectedBrand).click();

    }


    public void FilterwithPrices(String searchname) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.clear();
        searchInput.sendKeys(searchname);
        searchInput.sendKeys(Keys.ENTER);
        driver.findElement(price).click();
        driver.findElement(minPrice).sendKeys("30");
        driver.findElement(maxPrice).sendKeys("3000");
        driver.findElement(goButton).click();

    }

    public String getSearchResult() {
        return driver.getTitle();
    }
}
