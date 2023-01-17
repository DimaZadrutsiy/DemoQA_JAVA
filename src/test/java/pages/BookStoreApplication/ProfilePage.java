package pages.BookStoreApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProfilePage extends BookStorePage {

    @FindBy(xpath = "//label[@id='userName-value']")
    private WebElement userName;

    @FindBy(xpath = "//a[contains(@href,'/login')]")
    private WebElement loginLink;

    @FindBy(xpath = "//button[@id='gotoStore']")
    private WebElement goToStoreButton;

    @FindBy(xpath = "//div[@class='text-right button di']/button[@id='submit' and contains(text(),'Delete All Books')]")
    private WebElement deleteAllBooksButton;

    @FindBy(xpath = "//button[@id='closeSmallModal-ok']")
    private WebElement okModalWindowButton;

    @FindBy(xpath = "//span[@class='mr-2']/a")
    private List<WebElement> booksListInUserCollection;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getUserNameValue() {

        return getText(userName);
    }

    public LoginPage clickLoginLink() {
        click(loginLink);

        return new LoginPage(getDriver());
    }

    public BookStorePage clickGoToStoreButton() {
        wait20ElementToBeClickable(goToStoreButton);
        click(goToStoreButton);

        return new BookStorePage(getDriver());
    }

    public int getBooksListInUserCollectionSize() {

        return booksListInUserCollection.size();
    }

    public ProfilePage clickDeleteAllBooksButtonIfCollectionIsNotEmpty() {
        scrollByVisibleElement(deleteAllBooksButton);

        if(getBooksListInUserCollectionSize() == 0) {

            return new ProfilePage(getDriver());
        } else {
            click(deleteAllBooksButton);
            wait20ElementToBeVisible(okModalWindowButton);
            click(okModalWindowButton);
            acceptAlert();

            return new ProfilePage(getDriver());
        }
    }
}
