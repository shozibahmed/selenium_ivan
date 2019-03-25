package com.shiftedtech.qa.scripts;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by ShiftTeacher on 2/3/2018.
 */
public class SpreeLoginFunctionalityWithFunction {

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
        Login("shiftqa01@gmail.com", "shiftedtech");
        verifyLoginSuccess();
    }

    @Test
    public void invalidLoginTest(){
        Login("shiftqa01@gmail.com", "invalidpassword");
        verifyLoginNotSuccess();
    }

    @Test
    public void invalidEmailTest(){
        Login("shiftqa01_invalid@gmail.com", "shiftedtech");
        verifyLoginNotSuccess();
    }


    @After
    public void teamDown(){
        driver.close();
        driver.quit();
    }

    private void navigetToLoginPage(){
        WebElement loginLink = driver.findElement(By.xpath("//*[@id='link-to-login']/a"));
        //WebElement element = driver.findElement(By.linkText("Login"));
        loginLink.click();
    }
    private void Login(String email, String password) {
        navigetToLoginPage();

        WebElement emailTextbox = driver.findElement(By.id("spree_user_email"));
        emailTextbox.sendKeys(email);

        WebElement passwordTextbox = driver.findElement(By.id("spree_user_password"));
        passwordTextbox.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
    }

    private void verifyLoginSuccess(){
        WebElement successText = driver.findElement(By.cssSelector(".alert-error"));
        String text = successText.getText();
        Assert.assertEquals("Invalid email or password.",text);
    }

    private void verifyLoginNotSuccess(){
        WebElement successText = driver.findElement(By.cssSelector(".alert-error"));
        String text = successText.getText();
        Assert.assertEquals("Invalid email or password.",text);
    }
}
