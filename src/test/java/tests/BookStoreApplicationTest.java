package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class BookStoreApplicationTest extends BaseTest {

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
    public void testLoginInvalidData() {
        String userName = "abcde";
        String password = "adcde";

        final String expectedErrorMessage = "Invalid username or password!";
        final String expectedURL = "https://demoqa.com/login";

         openBaseURL()
                .clickBookStoreApplicationMenu()
                .clickLoginButtonBookStorePage()
                .inputUserName(userName)
                .inputPassword(password)
                .clickLoginButton();

        String actualErrorMessage = getLoginPage().getErrorMessage();
        String actualURL = getCurrentURL();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Assert.assertEquals(actualURL, expectedURL);
    }

    /*
    при логине юзера с валидными даными мы через раз попадаем на
    разные страницы или books или profile
     */
    @Test
    public void testLoginValidData() {
        String userName = "TesterUserName";
        String password = "Tester_1234!";

        final String expectedUserNameValue = "TesterUserName";

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

    @Test
    public void testBookStorePageSubMenuList() {
        final List<String> expectedSubMenuHeaders = Arrays.asList(
                "Login", "Book Store", "Profile", "Book Store API"
        );
        final int expectedSubMenusSize = 4  ;

        List <String> actualSubMenuHeaders = openBaseURL()
                .clickBookStoreApplicationMenu()
                .clickBookStoreApplicationSubMenu()
                .getBookStorePageSubMenuHeaders();

        int actualSubMenusSize = actualSubMenuHeaders.size();

        Assert.assertEquals(actualSubMenuHeaders, expectedSubMenuHeaders);
        Assert.assertEquals(actualSubMenusSize, expectedSubMenusSize);
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
