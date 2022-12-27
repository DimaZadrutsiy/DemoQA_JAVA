package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookStoreApplication.RegisterPage;

public class BookStoreApplicationTest extends BaseTest {

    @Test
    public void testLoginValidData_WithoutCaptcha() {
        String name = "TesterName";
        String lastName = "TesterLastName";
        String userName = "TesterUserName";
        String password = "Tester_1234!";

        String expectedCaptchaMessage = "Please verify reCaptcha to register!";

        String actualCaptchaMessage = openBaseURL()
                .clickBookStoreApplicationMenu()
                .clickLoginButton()
                .clickNewUserButton()
                .inputFirstName(name)
                .inputLastName(lastName)
                .inputUserName(userName)
                .inputPassword(password)
                .clickRegisterButton()
                .getTextFromCaptchaBlock();

        Assert.assertEquals(actualCaptchaMessage, expectedCaptchaMessage);
    }
}
