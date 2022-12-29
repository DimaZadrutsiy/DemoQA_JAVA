package pages.BookStoreApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BookStorePage {

    @FindBy(xpath = "//label[@id='userName-value']")
    private WebElement userName;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getUserNameValue() {

        return getText(userName);
    }
}
