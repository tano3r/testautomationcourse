package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTests {

    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.firefox.driver", "resources/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        driver.quit();
    }

    public static void main(String[] args){
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
