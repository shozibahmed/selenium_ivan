package com.shiftedtech.qa.framework.scriptbase;

import com.paxovision.execution.reporter.listener.ReporterTestListener;
import com.paxovision.execution.reporter.service.ReporterService;
import com.shiftedtech.qa.framework.SpreeFunctions;
import com.shiftedtech.qa.framework.SpreeLoginPage;
import com.shiftedtech.qa.framework.pages.HomePage;
import com.shiftedtech.qa.framework.utils.DriverFactory;
import com.shiftedtech.qa.framework.utils.ExcelReader;
import com.shiftedtech.qa.framework.utils.ExtentManager;
import com.shiftedtech.qa.framework.utils.ExtentTestNGITestListener;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import com.paxovision.execution.reporter.interceptor.ProxyGenerator;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by ShiftTeacher on 2/3/2018.
 */
//@Listeners({ReporterTestListener.class, ExtentTestNGITestListener.class})
@Listeners({ReporterTestListener.class})
public class ScriptBaseTestNG {

    //ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //private WebDriver driver;
    protected ReporterService reporter = ReporterService.reporter();
    //protected ExtentManager extentManager = null;

    private ThreadLocal<HomePage> homePagelocal = new ThreadLocal<>();
    private ThreadLocal<SpreeLoginPage> loginPagelocal = new ThreadLocal<>();
    //protected HomePage homePage;
    //protected SpreeLoginPage loginPage;

    @BeforeClass
    public void beforeClass() throws Exception {
        reporter.setReportPath(System.getProperty("user.dir") + "/testoutput/htmlReport/");
        reporter.setReportName("PaxoReport");
        reporter.setReportTitle("Paxo Functional Test");
        reporter.setCreateUniqueFileName(true);

        //extentManager = ExtentManager.getInstance();
    }

    @BeforeMethod
    @Parameters({"browserName"})
    public void setUp(@Optional(value = "grid_chrome_16") String browserName) throws Exception {
        WebDriver driver = DriverFactory.getInstance(browserName).getDriver();;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);

        homePagelocal.set(new HomePage(driver));
        loginPagelocal.set(new SpreeLoginPage(driver));

        driver.navigate().to("http://spree.shiftedtech.com");

    }

    public HomePage homePage(){
        return homePagelocal.get();
    }
    public SpreeLoginPage loginPage(){
        return loginPagelocal.get();
    }


    @AfterMethod
    public void teamDown(){
        try {
            DriverFactory.getInstance().removeDriver();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        homePagelocal.remove();
        loginPagelocal.remove();
    }

}
