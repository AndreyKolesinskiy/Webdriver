package page;

import Waits.CustomConditions;
import Waits.WebEventListener;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CalculatorPage {

    private WebDriver driver;
    private JavascriptExecutor executor;
    private EventFiringWebDriver eventDriver;
    private WebEventListener webEventListener;



    @FindBy(xpath = "//*[@title='Compute Engine' and @class='hexagon']/..")
    private List<WebElement> computeEngineIcon;
    @FindBy(xpath = "//*[contains(text(),'Number of instances')]/following-sibling::input")
    private WebElement numberOfInstancesField;
    @FindBy(xpath = "//*[contains(text(),'Operating System / Software')]/../descendant::md-select")
    private WebElement operatingSystemDropDown;
    @FindBy(xpath = "//*[contains(text(),'Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS')]/..")
    private List<WebElement> freeSystem;
    @FindBy(xpath = "//*[contains(text(),'Machine Class')]/following-sibling::md-select")
    private WebElement machineClassDropDown;
    @FindBy(xpath = "//*[@value='regular']")
    private List<WebElement> regularClass;
    @FindBy(xpath = "//*[contains(text(),'Machine type')]/../descendant::md-select")
    private WebElement machineTypeDropDown;
    @FindBy(xpath = "//*[contains(text(),'n1-standard-8 (vCPUs: 8, RAM: 30GB)')]/..")
    private WebElement n1Stnadard8Type;
    @FindBy(xpath = "//*[contains(text(),'Add GPUs.')]/parent::md-checkbox")
    private WebElement addGpuCheckbox;
    @FindBy(xpath = "//*[contains(text(),'Number of GPUs')]/../descendant::md-select")
    private WebElement numberOfGpusDropDown;
    @FindBy(xpath = "//*[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]' and @value='1']")
    private WebElement numberOfGpu1;
    @FindBy(xpath = "//*[contains(text(),'GPU type')]/../descendant::md-select")
    private WebElement gpuTypeDropDown;
    @FindBy(xpath = "//*[contains(text(),'NVIDIA Tesla V100')]/ancestor::md-option")
    private WebElement gpuNvidiaTeslaV100;
    @FindBy(xpath = "//*[contains(text(),'Local SSD')]/../descendant::md-select")
    private WebElement localSsdDropDown;
    @FindBy(xpath = "//*[contains(text(),'2x375 GB')]/..")
    private WebElement ssd2x375Gb;
    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocationDropDown;
    @FindBy(xpath = "//div[contains(@class,'md-active')]//*[contains(text(),'Frankfurt (europe-west3)')]/..")
    private WebElement datacenterLocationFrankfurt;
    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.cud']/../descendant::md-select")
    private WebElement committedUsageDropDown;
    @FindBy(xpath = "//div[contains(@class,'md-active')]//*[contains(text(),'1 Year')]/..")
    private WebElement committedUsage1Year;
    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimateButton;







    public CalculatorPage(WebDriver driver){
        this.driver = driver;
        this.executor = (JavascriptExecutor) driver;
//        eventDriver = new EventFiringWebDriver(driver);
//        webEventListener = new WebEventListener();
//        eventDriver.register(webEventListener);
        PageFactory.initElements(driver, this);


    }

    public CalculatorPage selectComputeEngineSection(){
        new WebDriverWait(driver,10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        driver.switchTo().frame("myFrame");
        computeEngineIcon.get(0).click();
        return this;
    }

    public CalculatorPage setNumberOfInstances(String number){
        numberOfInstancesField.sendKeys(number);
        return this;
    }

    public CalculatorPage selectFreeOperatingSystem(){
        executor.executeScript("arguments[0].click();", operatingSystemDropDown);
        executor.executeScript("arguments[0].click();", freeSystem.get(1));
        return this;
    }

    public CalculatorPage selectRegularMachineClass(){
        executor.executeScript("arguments[0].click();", machineClassDropDown);
        executor.executeScript("arguments[0].click();", regularClass.get(1));
        return this;
    }

    public CalculatorPage selectMachineType(){
        executor.executeScript("arguments[0].click();", machineTypeDropDown);
        executor.executeScript("arguments[0].click();", n1Stnadard8Type);
        return this;
    }

    public CalculatorPage selectGpu1NvidiaTeslaV100(){
        executor.executeScript("arguments[0].click();", addGpuCheckbox);
        executor.executeScript("arguments[0].click();", numberOfGpusDropDown);
        executor.executeScript("arguments[0].click();", numberOfGpu1);
        executor.executeScript("arguments[0].click();", gpuTypeDropDown);
        executor.executeScript("arguments[0].click();", gpuNvidiaTeslaV100);
        return this;
    }

    public CalculatorPage selectSsd2x375Gb(){
        executor.executeScript("arguments[0].click();", localSsdDropDown);
        executor.executeScript("arguments[0].click();", ssd2x375Gb);
        return this;
    }

    public CalculatorPage selectDatacenterLocationFrankfurt(){
        executor.executeScript("arguments[0].click();", datacenterLocationDropDown);
//        new WebDriverWait(driver,10).until(CustomConditions.angularIsFinished());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.executeScript("arguments[0].click();",datacenterLocationFrankfurt);
        return  this;
    }

    public CalculatorPage selectCommittedUsage1Year(){
//        new WebDriverWait(driver,10).until(CustomConditions.angularIsFinished());
        executor.executeScript("arguments[0].click();", committedUsageDropDown);
        new WebDriverWait(driver,10).until(CustomConditions.angularIsFinished());
//        waitForAngularLoad();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        executor.executeScript("arguments[0].click();", committedUsage1Year);

        return this;
    }

    public CalculatorPage clickAddToEstimateButton(){
        executor.executeScript("arguments[0].click();", addToEstimateButton);
//        addToEstimateButton.click();
        return this;
    }

    public void waitForAngularLoad() {
        final String angularReadyScript = "return (window.angular !== undefined) && (angular.element(document.body).injector() !== undefined) && (angular.element(document.body).injector().get('$http').pendingRequests.length === 0)";
        ExpectedCondition<Boolean> angularLoad = new ExpectedCondition<Boolean>() {
            @NullableDecl
            public Boolean apply(@NullableDecl WebDriver webDriver) {
                return Boolean.valueOf(executor.executeScript(angularReadyScript).toString());
            }
        };
        new WebDriverWait(driver,5).until(angularLoad);
    }


}
