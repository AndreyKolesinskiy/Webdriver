package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.CloudPage;
import page.SearchResultsPage;
import page.TestEmailPage;

import java.util.ArrayList;

public class CalculatorTests {
    private WebDriver driver;
    private CloudPage cloudPage;
    private SearchResultsPage searchResultsPage;
    private CalculatorPage calculatorPage;
    private TestEmailPage testEmailPage;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test(description = "Hurt Me Plenty")
    public void checkCalculatorResultsOnPage(){
        calculatorPage = new CalculatorPage(driver);
        cloudPage = new CloudPage(driver);
        cloudPage.openCloudPage()
                .clickSearchIcon()
                .enterSearchText("Google Cloud Platform Pricing Calculator")
                .pressEnterInSearchField()
                .clickCalculatorLink()
                .selectComputeEngineSection()
                .setNumberOfInstances("4")
                .selectFreeOperatingSystem()
                .selectRegularMachineClass()
                .selectMachineType()
                .selectGpu1NvidiaTeslaV100()
                .selectSsd2x375Gb()
                .selectDatacenterLocationFrankfurt()
                .selectCommittedUsage1Year()
                .clickAddToEstimateButton();
        Assert.assertTrue(calculatorPage.checkCartVmClass());
        Assert.assertTrue(calculatorPage.checkCartInstanceType());
        Assert.assertTrue(calculatorPage.checkCartRegion());
        Assert.assertTrue(calculatorPage.checkCartLocalSsd());
        Assert.assertTrue(calculatorPage.checkCartCommitmentTerm());
        Assert.assertTrue(calculatorPage.checkCartCost());

    }

    @Test(description = "Hurt Me Plenty")
    public void checkCalculatorResultsInEmail(){
        calculatorPage = new CalculatorPage(driver);
        cloudPage = new CloudPage(driver);
        cloudPage.openCloudPage()
                .clickSearchIcon()
                .enterSearchText("Google Cloud Platform Pricing Calculator")
                .pressEnterInSearchField()
                .clickCalculatorLink()
                .selectComputeEngineSection()
                .setNumberOfInstances("4")
                .selectFreeOperatingSystem()
                .selectRegularMachineClass()
                .selectMachineType()
                .selectGpu1NvidiaTeslaV100()
                .selectSsd2x375Gb()
                .selectDatacenterLocationFrankfurt()
                .selectCommittedUsage1Year()
                .clickAddToEstimateButton();

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        testEmailPage = new TestEmailPage(driver);
        testEmailPage.openTestEmailPage();
        String testEmail = testEmailPage.getGeneratedEmail();
        driver.switchTo().window(tabs.get(0));
        new WebDriverWait(driver,10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        driver.switchTo().frame("myFrame");
        calculatorPage.clickAddEmailEstimateButton();
        calculatorPage.enterEmailAndClickSend(testEmail);
        driver.switchTo().window(tabs.get(1));
        Assert.assertTrue(testEmailPage.checkCostInEmail());

    }


//    @AfterMethod(alwaysRun = true)
//    public void browserTearDown(){
//        driver.quit();
//        driver = null;
//    }
}
