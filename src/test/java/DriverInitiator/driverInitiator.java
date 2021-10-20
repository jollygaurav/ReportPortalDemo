package DriverInitiator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverInitiator {

    WebDriver driver;

    public WebDriver driverInit()
    {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
        driver = new ChromeDriver();
        return driver;
    }


}
