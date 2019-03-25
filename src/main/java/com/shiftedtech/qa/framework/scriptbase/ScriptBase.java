package com.shiftedtech.qa.framework.scriptbase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by ShiftTeacher on 2/3/2018.
 */
public class ScriptBase {
    private WebDriver driver;

    @BeforeClass
    public static void beforeClass(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
        //ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
        //ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();

        driver.navigate().to("http://spree.shiftedtech.com");
    }

    @After
    public void teamDown(){
        driver.close();
        driver.quit();
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
