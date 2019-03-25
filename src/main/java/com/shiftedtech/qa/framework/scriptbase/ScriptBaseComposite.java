package com.shiftedtech.qa.framework.scriptbase;

import com.shiftedtech.qa.framework.SpreeFunctions;
import com.shiftedtech.qa.framework.SpreeHomePage;
import com.shiftedtech.qa.framework.SpreeLoginPage;
import com.shiftedtech.qa.framework.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by ShiftTeacher on 2/3/2018.
 */
public class ScriptBaseComposite {
    private WebDriver driver;

    protected SpreeFunctions spree;
    //protected SpreeHomePage homePage;
    protected HomePage homePage;
    protected SpreeLoginPage loginPage;

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

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);


        spree = new SpreeFunctions(driver);
        //homePage = new SpreeHomePage(driver);
        homePage = new HomePage(driver);
        loginPage = new SpreeLoginPage(driver);

        driver.navigate().to("http://spree.shiftedtech.com");
    }

    @After
    public void teamDown(){
        driver.close();
        driver.quit();
        spree = null;
        homePage = null;
        loginPage = null;
    }

}
