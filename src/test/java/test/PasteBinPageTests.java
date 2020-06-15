package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BashPage;
import page.PasteBinPage;

public class PasteBinPageTests {
    private WebDriver driver;
    private PasteBinPage pasteBinPage;
    private BashPage bashPage;


    @BeforeMethod(alwaysRun = true)
    public void setupBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "I Can Win")
    public void selectFields(){
        pasteBinPage = new PasteBinPage(driver);
        pasteBinPage.openPage()
                .typeCode("Hello from WebDriver")
                .selectTenMinExpiration()
                .typeNameTitle("helloweb");

    }

    @Test(description = "Bring It On")
    public void checkHeaderSyntaxAndCode(){
        pasteBinPage = new PasteBinPage(driver);
        pasteBinPage.openPage()
                .typeCode("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force")
                .selectSyntaxBash()
                .selectTenMinExpiration()
                .typeNameTitle("how to gain dominance among developers")
                .clickSubmitButton();
        bashPage = new BashPage(driver);
        Assert.assertEquals(bashPage.getTitleOfPage(), "[Bash] how to gain dominance among developers - Pastebin.com");
        Assert.assertEquals(bashPage.getColorOfCode(),"rgba(194, 12, 185, 1)");
        Assert.assertEquals(bashPage.getDisplayedCode(), "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTerDown(){
        driver.quit();
        driver = null;
    }
}
