package com.shiftedtech.qa.scripts;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by ShiftTeacher on 2/3/2018.
 */
public class SpreeLoginFunctionality {

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

    @Test
    public void validLoginTest(){
        WebElement loginLink = driver.findElement(By.xpath("//*[@id='link-to-login']/a"));
        //WebElement element = driver.findElement(By.linkText("Login"));
        loginLink.click();

        WebElement emailTextbox = driver.findElement(By.id("spree_user_email"));
        emailTextbox.sendKeys("shiftqa01@gmail.com");

        WebElement passwordTextbox = driver.findElement(By.id("spree_user_password"));
        passwordTextbox.sendKeys("shiftedtech");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();


        WebElement successText = driver.findElement(By.cssSelector(".alert-success"));
        String text = successText.getText();
        Assert.assertEquals("Logged in successfully",text);
    }

    @Test
    public void invalidLoginTest(){
        WebElement loginLink = driver.findElement(By.xpath("//*[@id='link-to-login']/a"));
        //WebElement element = driver.findElement(By.linkText("Login"));
        loginLink.click();

        WebElement emailTextbox = driver.findElement(By.id("spree_user_email"));
        emailTextbox.sendKeys("shiftqa01@gmail.com");

        WebElement passwordTextbox = driver.findElement(By.id("spree_user_password"));
        passwordTextbox.sendKeys("invalidpassword");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();


        WebElement successText = driver.findElement(By.cssSelector(".alert-error"));
        String text = successText.getText();
        Assert.assertEquals("Invalid email or password.",text);
    }
    @Test
    public void invalidEmailTest(){
        WebElement loginLink = driver.findElement(By.xpath("//*[@id='link-to-login']/a"));
        //WebElement element = driver.findElement(By.linkText("Login"));
        loginLink.click();

        WebElement emailTextbox = driver.findElement(By.id("spree_user_email"));
        emailTextbox.sendKeys("shiftqa01_invalid@gmail.com");

        WebElement passwordTextbox = driver.findElement(By.id("spree_user_password"));
        passwordTextbox.sendKeys("shiftedtech");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();


        WebElement successText = driver.findElement(By.cssSelector(".alert-error"));
        String text = successText.getText();
        Assert.assertEquals("Invalid email or password.",text);
    }


    @After
    public void teamDown(){
        driver.close();
        driver.quit();
    }
}
