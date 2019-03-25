package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.framework.Browser;
import com.shiftedtech.qa.framework.scriptbase.ObjectRepo;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by ShiftTeacher on 2/3/2018.
 */
public class SpreeLoginFunctionalityEx {

    private Browser browser;

    @Before
    public void setUp(){
        ChromeDriverManager.getInstance().setup();
        browser = new Browser(new ChromeDriver());
        browser.navigate("http://spree.shiftedtech.com");
    }

    @Test
    public void validLoginTest1(){
        browser.click(ObjectRepo.HOME_LOGIN_LINK);
        browser.typeText(By.id("spree_user_email"),"shiftqa01@gmail.com");
        browser.typeText(By.id("spree_user_password"),"shiftedtech");
        browser.click(By.xpath("//input[@value='Login']"));
        browser.verifyText(By.cssSelector(".alert-success"),"Logged in successfully");
    }
    @Test
    public void validLoginTest2(){
        browser.click(ObjectRepo.HOME_LOGIN_LINK);
        browser.typeText(By.id("spree_user_email"),"shiftqa01@gmail.com");
        browser.typeText(By.id("spree_user_password"),"shiftedtech");
        browser.click(By.xpath("//input[@value='Login']"));
        browser.verifyText(By.cssSelector(".alert-success"),"Logged in successfully");
    }


    @After
    public void teamDown(){
        browser.close();
    }
}
