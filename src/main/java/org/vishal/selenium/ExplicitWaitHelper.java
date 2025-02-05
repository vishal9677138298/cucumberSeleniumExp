package org.vishal.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ExplicitWaitHelper {

    private Driver driver;

    private WebDriverWait wait;

    public ExplicitWaitHelper(Driver driver, long seconds){
        this.driver = driver;
        wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(seconds));
    }

    public void waitTillVisibility(WebElement element){
        wait.until(visibilityOf(element));
    }

    public void waitTillVisibility(WebElement... elements){
        wait.until(visibilityOfAllElements(elements));
    }

    public void waitTillVisibility(By locator){
        wait.until(visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitTillVisibility(List<WebElement> allElements){
        wait.until(visibilityOfAllElements(allElements));
    }

    public void waitTillPageIsLoaded(){
        wait.until(webDriver -> (
                (JavascriptExecutor) driver.getDriver()).executeScript("return document.readyState").equals("complete")
        );
    }
}
