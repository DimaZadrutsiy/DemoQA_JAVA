package pages.BookStoreApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class BookStoreApplicationPage extends BasePage {

    @FindBy(xpath = "//div/button[@id='login']")
    private WebElement loginButton;

    public BookStoreApplicationPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginButton() {
        click(loginButton);

        return new LoginPage(getDriver());
    }
}
