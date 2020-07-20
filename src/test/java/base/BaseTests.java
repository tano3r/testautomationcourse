package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;

import java.util.List;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    public void setUp(){
        System.setProperty("webdriver.firefox.driver", "resources/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/");

        homePage = new HomePage(driver);

        driver.quit();
    }

    public static void main(String[] args){
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
