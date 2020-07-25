package password;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ForogotPasswordTests extends BaseTests {

    @Test
    public void testForgotPassword(){
        var forgotPasswordPage = homePage.clickForgotPassword();
        var emailSentPage = forgotPasswordPage.retreievePassword("email@domain.com");
        assertEquals(emailSentPage.getContentMessage(), "Your e-mail's been sent!", "Message is incorrect");
    }
}
