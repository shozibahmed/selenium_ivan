package com.shiftedtech.qa.framework;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ShiftTeacher on 2/3/2018.
 */
public class SpreeFunctions {
    private WebDriver driver;

    public SpreeFunctions(WebDriver driver){
        this.driver = driver;
    }

    public void navigetToLoginPage(){
        WebElement loginLink = driver.findElement(By.xpath("//*[@id='link-to-login']/a"));
        //WebElement element = driver.findElement(By.linkText("Login"));
        loginLink.click();
    }
    public void Login(String email, String password) {
        navigetToLoginPage();

        WebElement emailTextbox = driver.findElement(By.id("spree_user_email"));
        emailTextbox.sendKeys(email);

        WebElement passwordTextbox = driver.findElement(By.id("spree_user_password"));
        passwordTextbox.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
    }

    public void verifyLoginSuccess(){
        WebElement successText = driver.findElement(By.cssSelector(".alert-error"));
        String text = successText.getText();
        Assert.assertEquals("Invalid email or password.",text);
    }

    public void verifyLoginNotSuccess(){
        WebElement successText = driver.findElement(By.cssSelector(".alert-error"));
        String text = successText.getText();
        Assert.assertEquals("Invalid email or password.",text);
    }
}
