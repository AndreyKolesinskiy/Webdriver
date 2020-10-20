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

    @FindBy(xpath = "//*[@name='PostForm[text]']")
    private WebElement pasteCodeArea;
    @FindBy(xpath = "//*[@id='select2-postform-expiration-container']")
    private WebElement expirationDropdown;
    @FindBy(xpath = "//*[@id='select2-postform-expiration-results']/*[text()='10 Minutes']")
    private WebElement tenMititesItem;
    @FindBy(xpath = "//*[@id='postform-name']")
    private WebElement pasteNameTitleFieled;
    @FindBy(xpath = "//*[@id='select2-postform-format-container']")
    private WebElement syntaxHighlightingDropdown;
    @FindBy(xpath = "//*[contains(text(),'POPULAR LANGUAGES')]/..//*[text()='Bash']")
    private WebElement bashItem;
    @FindBy(xpath = "//*[text()='Create New Paste']")
    private WebElement createNewPasteButton;

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
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(tenMititesItem));
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

    public BashPage clickCrateNewPaste(){
        createNewPasteButton.click();
        return new BashPage(driver);
    }
}
