package com.insiderUI.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }
    public static void waitForInvisibilityOf(WebElement webElement, String job){
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, job));
    }
    public static void sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }

    }
    public static void switchWindowAndVerify(WebDriver driver, String url, String title){
        Set<String> allEWindowsHandles= driver.getWindowHandles();
        for(String each:allEWindowsHandles){
            driver.switchTo().window(each);
            System.out.println("Current Url = " + driver.getCurrentUrl());
            if(driver.getCurrentUrl().contains(url)){
                break;
            }
        }
        String actualTitle=driver.getTitle();
        try {
            Assert.assertTrue(actualTitle.contains(title));
        }catch (AssertionError e) {
            ScreenshotUtil.takeScreenshot(Driver.getDriver(), "verifyApplicationPage");
            throw e;
        }


    }
}
