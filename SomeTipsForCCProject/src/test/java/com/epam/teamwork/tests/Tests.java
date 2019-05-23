package com.epam.teamwork.tests;

import com.epam.teamwork.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tests {

    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = DriverSingleton.getDriver();
    }

    @Test
    public void singletonTest(){
        driver.get("https://mail.ru/");
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(), "https://mail.ru/");
    }

    @AfterClass
    public void tearDown(){
        DriverSingleton.killDriver();
    }
}
