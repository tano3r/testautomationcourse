package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.util.List;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    //This method will run before every testclass
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.firefox.driver", "resources/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/");

        homePage = new HomePage(driver);
    }

    //This method will run after every testclass
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
