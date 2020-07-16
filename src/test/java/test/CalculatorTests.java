package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.CloudPage;
import page.SearchResultsPage;

public class CalculatorTests {
    private WebDriver driver;
    private CloudPage cloudPage;
    private SearchResultsPage searchResultsPage;
    private CalculatorPage calculatorPage;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test(description = "Hurt Me Plenty")
    public void checkCalculatorResults(){
        driver.get("https://cloud.google.com/products/calculator");
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectComputeEngineSection()
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




//        cloudPage = new CloudPage(driver);
//        cloudPage.openCloudPage()
//                .clickSearchIcon()
//                .enterSearchText("Google Cloud Platform Pricing Calculator")
//                .pressEnterInSearchField()
//                .clickCalculatorLink()
//                .setNumberOfInstances("4")
//                .selectFreeOperatingSystem()
//                .selectRegularMachineClass();

    }

//    @AfterMethod(alwaysRun = true)
//    public void browserTearDown(){
//        driver.quit();
//        driver = null;
//    }
}
