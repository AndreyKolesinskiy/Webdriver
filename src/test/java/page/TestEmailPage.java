package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestEmailPage {

    private WebDriver driver;
    private JavascriptExecutor executor;
    private static final String HOMEPAGE_URL = "https://10minutemail.com/";

    @FindBy(xpath = "//input[@id='mail_address']")
    private WebElement generatedEmailField;
    @FindBy(xpath = "//*[@class='small_message_icon_box']")
    private WebElement emailIcon;

    @FindBy(xpath = "//*[contains(text(),'USD 1,082.77')]")
    private WebElement costInEmail;



    public TestEmailPage(WebDriver driver){
        this.driver = driver;
        this.executor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public TestEmailPage openTestEmailPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(generatedEmailField));
        return this;
    }

    public String getGeneratedEmail(){

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeToBeNotEmpty(generatedEmailField, "value"));
        return generatedEmailField.getAttribute("value");
    }

    public boolean checkCostInEmail(){
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(emailIcon));
        emailIcon.click();
        return costInEmail.isDisplayed();
    }


}
