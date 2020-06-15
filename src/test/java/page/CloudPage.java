package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Search']") ////div[@class='devsite-search-container'] //*[contains(@class, 'devsite-search-image')]
    private WebElement searchButton;
    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    public CloudPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CloudPage openCloudPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(searchButton));
        return this;
    }

    public CloudPage clickSearchIcon(){
        searchButton.click();
        return this;
    }

    public CloudPage enterSearchText(String searchText){
        searchField.sendKeys("Google Cloud Platform Pricing Calculator");
        return this;
    }

    public SearchResultsPage pressEnterInSearchField(){
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

}
