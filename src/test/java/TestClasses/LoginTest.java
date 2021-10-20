package TestClasses;

import DriverInitiator.driverInitiator;
import PageClasses.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class LoginTest  {
    driverInitiator testDriverInitiatior;
    WebDriver driver;
    LoginPage loginPageObject;
    @BeforeClass
    public void LoginTest() {
        testDriverInitiatior = new driverInitiator();
        driver = testDriverInitiatior.driverInit();
//        loginPageObject = new LoginPage(driver);
    }
    @Test
    public void Login() {
        driver.get("https://www.amazon.in");
    }
    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

}
