package tests.BookStoreApplicationTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class RegisterNewUserTest extends BaseTest {

    @Test
    public void testRegisterNewUserValidData_WithoutCaptcha() {
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

    @Ignore
    @Test
    public void testRegisterNewUserValidData_WithCaptcha() {
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
