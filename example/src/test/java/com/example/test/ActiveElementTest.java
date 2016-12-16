package com.example.test;

import com.example.page.GooglePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by william.russell on 12/16/16.
 */
public class ActiveElementTest {

    private WebDriver driver;

    @BeforeSuite
    public void setupDriver(){
        System.out.println(this.getClass().getClassLoader().getResource("chromedriver_64_mac").getPath());
        System.setProperty("webdriver.chrome.driver", this.getClass().getClassLoader().getResource("chromedriver_64_mac").getPath());
        DesiredCapabilities capabilities = org.openqa.selenium.remote.DesiredCapabilities.chrome();

        driver = new ChromeDriver(capabilities);
        driver.get("http://google.com");

    }



    @AfterSuite
    public void killIt(){
        driver.quit();
    }

    @Test
    public void testActiveElement() throws Exception {
        GooglePage googlePage  = new GooglePage(driver);

        //This works with a normal WebElement. If we use the Element example this will always be false.
        Assert.assertTrue(googlePage.searchBox.equals(driver.switchTo().activeElement()));
    }
}
