package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class BaseTests {

    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.firefox.driver", "resources/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement inputsLink =  driver.findElement(By.linkText("Shifting Content"));
        inputsLink.click();

        WebElement exampleOne = driver.findElement(By.partialLinkText("Example 1"));
        exampleOne.click();

        List<WebElement> buttonMenuList = driver.findElements(By.tagName("li"));
        System.out.println(buttonMenuList.size());

        driver.quit();
    }

    public static void main(String[] args){
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
