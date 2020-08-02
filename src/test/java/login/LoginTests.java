package login;

import base.BaseTests;
import dataProvider.ConfigFileReader;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
        ConfigFileReader configFileReader = new ConfigFileReader();
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername(configFileReader.getUsername());
        loginPage.setPassword(configFileReader.getPassword());
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText()
                 .contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }

    @Test
    public void testInvalidUsernameLogin(){
        ConfigFileReader configFileReader = new ConfigFileReader();
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername(configFileReader.getUsername() + "123");
        loginPage.setPassword(configFileReader.getPassword());
        loginPage.clickLoginButton();
        assertTrue(loginPage.getAlertText()
                        .contains("Your username is invalid!"),
                "Alert text is incorrect");
    }

    @Test
    public void testInvalidPasswordLogin(){
        ConfigFileReader configFileReader = new ConfigFileReader();
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername(configFileReader.getUsername());
        loginPage.setPassword(configFileReader.getPassword() + "123");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getAlertText()
                        .contains("Your password is invalid!"),
                "Alert text is incorrect");
    }
}

