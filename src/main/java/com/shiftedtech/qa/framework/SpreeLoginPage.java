package com.shiftedtech.qa.framework;

import com.paxovision.execution.annotations.LogReport;
import com.shiftedtech.qa.framework.pages.PageBase;
import com.shiftedtech.qa.framework.utils.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ShiftTeacher on 2/3/2018.
 */
public class SpreeLoginPage extends PageBase {

    public SpreeLoginPage(WebDriver driver){
       super(driver);
    }
    public SpreeLoginPage(){
        driver = DriverFactory.getInstance().getDriver();
    }


    @LogReport(description = "Login to to the application")
    public void Login(String email, String password) {
        WebElement emailTextbox = waitForElementDisplayed(By.id("spree_user_email"),30);
        emailTextbox.sendKeys(email);

        WebElement passwordTextbox = driver.findElement(By.id("spree_user_password"));
        highlight(passwordTextbox);
        passwordTextbox.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        highlight(loginButton);
        loginButton.click();
    }

    public void verifyLoginNotSuccess(){
        WebElement successText = driver.findElement(By.cssSelector(".alert-error"));
        highlight(successText);
        String text = successText.getText();
        Assert.assertEquals("Invalid email or password.",text);
    }
}
