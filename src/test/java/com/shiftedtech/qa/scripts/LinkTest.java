package com.shiftedtech.qa.scripts;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by ShiftTeacher on 2/11/2018.
 */
public class LinkTest {


    private WebDriver driver;

    @Before
    public void setUp(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.navigate().to("http://heatclinic.shiftedtech.com/");
    }

    @Test
    public void allLinkTest() throws IOException {
        //List<WebElement> links = driver.findElements(By.xpath("//nav/ul/li/a"));
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(WebElement item:links){
            String href = item.getAttribute("href");
            System.out.println("Link:" + href);
            if((href.startsWith("http"))) {
                URL url = new URL(href);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                int code = urlConnection.getResponseCode();

                System.out.println("Code: " + code);
            }
           // Assert.assertEquals(200,code);
        }

    }

    @After
    public void teamDown(){
        driver.close();
        driver.quit();
    }
}
