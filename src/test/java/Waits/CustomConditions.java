package Waits;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {

    public static ExpectedCondition<Boolean> angularIsFinished(){
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver).executeScript("return (window.angular !== undefined) && (angular.element(document.body).injector() !== undefined) && (angular.element(document.body).injector().get('$http').pendingRequests.length === 0)");
            }
        };
    }
}
