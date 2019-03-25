package com.shiftedtech.qa.framework.pages;

import com.paxovision.execution.annotations.LogReport;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ShiftTeacher on 2/4/2018.
 */
public class HomePage extends PageBase{
    //@FindBy(xpath = "//*[@id='link-to-login']/a")
    @FindBy(linkText = "Login")
    private WebElement loginLink;
    @FindBy( how  = How.CSS,  using = ".alert-success")
    private  WebElement successText;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public HomePage() {
        super();
        PageFactory.initElements(driver,this);
    }

    public void navigetToLoginPage(){
        reporter.logInfo("NavigateToLoginPage","Navigation to login page by clicking login link");
        loginLink.click();
    }

    @LogReport(description = "To verify the success message after login")
    public void verifyLoginSuccess(){
        //successText = waitForElementDisplayed(By.cssSelector(".alert-success"),10);
        if(driver instanceof InternetExplorerDriver){
            delayFor(6000);
        }
        String text = successText.getText();
        Assert.assertEquals("Logged in successfully",text);
    }
}
