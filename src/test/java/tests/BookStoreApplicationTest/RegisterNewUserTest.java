package tests.BookStoreApplicationTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterNewUserTest extends BaseTest {

    @Test
    public void testLoginValidData_WithoutCaptcha() {
        String name = "TesterName";
        String lastName = "TesterLastName";
        String userName = "TesterUserName";
        String password = "Tester_1234!";

        final String expectedCaptchaMessage = "Please verify reCaptcha to register!";

        String actualCaptchaMessage = openBaseURL()
                .clickBookStoreApplicationMenu()
                .clickLoginButtonBookStorePage()
                .clickNewUserButton()
                .inputFirstName(name)
                .inputLastName(lastName)
                .inputUserName(userName)
                .inputPassword(password)
                .clickRegisterButton()
                .getTextFromCaptchaBlock();

        Assert.assertEquals(actualCaptchaMessage, expectedCaptchaMessage);
    }

    @Test
    public void testLoginValidData_WithCaptcha() {
        String name = "TesterName";
        String lastName = "TesterLastName";
        String userName = "TesterUserName";
        String password = "Tester_1234!";

        final String expectedCaptchaMessage = "Please verify reCaptcha to register!";

        String actualCaptchaMessage = openBaseURL()
                .clickBookStoreApplicationMenu()
                .clickLoginButtonBookStorePage()
                .clickNewUserButton()
                .inputFirstName(name)
                .inputLastName(lastName)
                .inputUserName(userName)
                .inputPassword(password)
                .clickCaptcha()
                .clickRegisterButton()
                .getTextFromCaptchaBlock();

        Assert.assertEquals(actualCaptchaMessage, expectedCaptchaMessage);
    }
}
