package com.shiftedtech.qa.framework;

import com.shiftedtech.qa.framework.pages.PageBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ShiftTeacher on 2/3/2018.
 */
public class SpreeHomePage extends PageBase {

    public SpreeHomePage(WebDriver driver){
        super(driver);
    }

    public void navigetToLoginPage(){
        //WebElement element = driver.findElement(By.linkText("Login"));
        //WebElement loginLink = driver.findElement(By.xpath("//*[@id='link-to-login']/a"));

        By by  = By.xpath("//*[@id='link-to-login']/a");
        WebElement loginLink = waitForElement(by,30);

        loginLink.click();
    }

    public void verifyLoginSuccess(){
        WebElement successText = waitForElementDisplayed(By.cssSelector(".alert-success"),30);
        String text = successText.getText();
        Assert.assertEquals("Logged in successfully",text);
    }
}
