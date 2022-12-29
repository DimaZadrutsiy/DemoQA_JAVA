package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

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
    public void testLoginInvalidData() {
        String userName = "abcde";
        String password = "adcde";

        String expectedErrorMessage = "Invalid username or password!";

         openBaseURL()
                .clickBookStoreApplicationMenu()
                .clickLoginButtonBookStorePage()
                .inputUserName(userName)
                .inputPassword(password)
                .clickLoginButton();

        String actualErrorMessage = getLoginPage().getErrorMessage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test
    public void testLoginValidData() {
        String userName = "TesterUserName";
        String password = "Tester_1234!";

        String expectedUserNameValue = "TesterUserName";

        openBaseURL()
                .clickBookStoreApplicationMenu()
                .clickLoginButtonBookStorePage()
                .inputUserName(userName)
                .inputPassword(password)
                .clickLoginButton();

        String actualUserNameValue = getProfilePage()
                .getUserNameValue();

        Assert.assertEquals(actualUserNameValue, expectedUserNameValue);
    }

    @Ignore //не понимаю, как побороть капчу
    @Test
    public void testLoginValidData_WithCaptcha() {
        String name = "TesterName";
        String lastName = "TesterLastName";
        String userName = "TesterUserName";
        String password = "Tester_1234!";

        String expectedCaptchaMessage = "Please verify reCaptcha to register!";

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
