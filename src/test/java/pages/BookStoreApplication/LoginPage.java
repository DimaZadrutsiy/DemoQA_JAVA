package pages.BookStoreApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BookStoreApplicationPage {

    @FindBy (xpath = "//div/button[@id='newUser']")
    private WebElement newUserButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage clickNewUserButton() {
        click(newUserButton);

        return new RegisterPage(getDriver());
    }


}
