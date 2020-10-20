package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BashPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[text()='git config']")
    private WebElement highlightedCode;
    @FindBy(xpath = "//title")
    private WebElement titleOfPage;
    @FindBy(xpath = "//*[@class='textarea']")
    private WebElement displayedCode;

    public BashPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getColorOfCode(){
        String color = highlightedCode.getCssValue("color");
        return color;
    }

    public String getTitleOfPage(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(displayedCode));
        String title = driver.getTitle();
        return title;
    }

    public String getDisplayedCode(){
        String displayedCodeText = displayedCode.getText();
        return displayedCodeText;
    }
}
