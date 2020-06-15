package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private WebDriver driver;

    @FindBy(xpath = "//*[@name='paste_code']")
    private WebElement pasteCodeArea;
    @FindBy(xpath = "//*[contains(@id, 'select2-paste_expire_date')]")
    private WebElement expirationDropdown;
    @FindBy(xpath = "//*[contains(@id, 'select2-paste_expire_date')]//*[text()='10 Minutes']")
    private WebElement tenMititesItem;
    @FindBy(xpath = "//*[@name='paste_name']")
    private WebElement pasteNameTitleFieled;
    @FindBy(xpath = "//*[contains(@id, 'select2-paste_format')]")
    private WebElement syntaxHighlightingDropdown;
    @FindBy(xpath = "//*[contains(@id, 'select2-paste_format')]//*[text()='Bash']")
    private WebElement bashItem;
    @FindBy(xpath = "//input[@id='submit']")
    private WebElement submitButton;

    public PasteBinPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteBinPage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(pasteCodeArea));
        return this;
    }

    public PasteBinPage typeCode(String code){
        pasteCodeArea.sendKeys(code);
        return this;
    }

    public PasteBinPage selectTenMinExpiration(){
        expirationDropdown.click();
        tenMititesItem.click();
        return this;
    }

    public PasteBinPage typeNameTitle(String name){
        pasteNameTitleFieled.sendKeys(name);
        return this;
    }

    public PasteBinPage selectSyntaxBash(){
        syntaxHighlightingDropdown.click();
        bashItem.click();
        return this;
    }

    public BashPage clickSubmitButton(){
        submitButton.click();
        return new BashPage(driver);
    }
}
