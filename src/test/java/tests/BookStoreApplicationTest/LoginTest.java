package tests.BookStoreApplicationTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.BasePage;

public class LoginTest extends BaseTest {

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
        String actualURL = getLoginPage().getCurrentURL();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Assert.assertEquals(actualURL, expectedURL);
    }

    /*
     при логине юзера с валидными даными мы через раз попадаем на
     разные страницы или books или profile
      */
    @Ignore
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
}
