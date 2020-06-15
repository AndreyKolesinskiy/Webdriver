package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

    private WebDriver driver;

    @FindBy(xpath = "//b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement calculatorLink;

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

  public CalculatorPage clickCalculatorLink(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(calculatorLink));
        calculatorLink.click();
        return new CalculatorPage(driver);
  }
}
