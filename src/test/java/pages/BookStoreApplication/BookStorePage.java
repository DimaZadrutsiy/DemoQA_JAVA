package pages.BookStoreApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class BookStorePage extends BasePage {

    @FindBy(xpath = "//div/button[@id='login']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='searchBox']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='main-header']")
    private WebElement h2MainHeader;

    @FindBy(xpath = "//input[@placeholder='Type to search']")
    private WebElement placeholderSearchField;

    @FindBy(xpath = "//span[@class='mr-2']")
    private List<WebElement> booksList;

    @FindBy(xpath = "//ul[@class='menu-list']/li[@class='btn btn-light active']/../li")
    private List<WebElement> subMenuList;

    @FindBy(xpath = "//div[text()='Book Store Application']")
    private WebElement bookStoreApplicationSubMenu;

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginButtonBookStorePage() {
        click(loginButton);

        return new LoginPage(getDriver());
    }

    public String getH2MainHeaderText() {

        return getText(h2MainHeader);
    }

    public LoginPage inputBookName(String bookName) {
        input(bookName, searchField);

        return new LoginPage(getDriver());
    }

    public String getPlaceholderText() {

        return getText(placeholderSearchField);
    }

    public int getBooksListSize() {

        return getListSize(booksList);
    }

    public BookStorePage clickBookStoreApplicationSubMenu() {
        scrollByVisibleElement(bookStoreApplicationSubMenu);
        click(bookStoreApplicationSubMenu);

        return new BookStorePage(getDriver());
    }

    public List<String> getBookStorePageSubMenuHeaders() {
        scrollByVisibleElement(bookStoreApplicationSubMenu);
        click(bookStoreApplicationSubMenu);

        return getTexts(subMenuList);
    }

    public int getBookStorePageSubMenuAmount() {
        scrollByVisibleElement(bookStoreApplicationSubMenu);
        click(bookStoreApplicationSubMenu);

        return getListSize(subMenuList);
    }

    public List<String> getBooksList() {

        return getTexts(booksList);
    }
}
