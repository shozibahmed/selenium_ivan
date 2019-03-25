package com.shiftedtech.qa.framework;

import com.shiftedtech.qa.framework.pages.PageBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ShiftTeacher on 2/4/2018.
 */
public class Browser extends PageBase {

    public Browser(WebDriver driver) {
        super(driver);
    }

    public void navigate(String url){
            driver.navigate().to(url);
    }
    public void typeText(By by, String text){

        WebElement element = waitForElementDisplayed(by, DEFAULT_WAIT_TIME);
        element.clear();
        element.sendKeys(text);
    }

    public void click(By by){
        WebElement element = waitForElementDisplayed(by,DEFAULT_WAIT_TIME);
        element.click();
    }

    public void verifyText(By by, String textToVerify){
        WebElement successText = driver.findElement(by);
        String text = successText.getText();
        Assert.assertEquals(textToVerify,text);
    }

    public void close(){
        driver.close();
        driver.quit();
    }
}
