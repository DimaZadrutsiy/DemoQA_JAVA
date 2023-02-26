package pages.BookStoreApplication;

import api.model.Book;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.Date;
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

    @FindBy(xpath = "//div[@class='action-buttons']")
    private List<WebElement> booksList;

    @FindBy(xpath = "//ul[@class='menu-list']/li[@class='btn btn-light active']/../li")
    private List<WebElement> subMenuList;

    @FindBy(xpath = "//div[text()='Book Store Application']")
    private WebElement bookStoreApplicationSubMenu;

    @FindBy(xpath = "//button[@id='addNewRecordButton' and contains(text(),'Add To Your Collection')]")
    private WebElement addToYourCollectionButton;

    @FindBy(xpath = "//span[contains(text(),'Profile')]")
    private WebElement profileSubMenu;

    @FindBy(xpath = "//a[contains(@href,'/books?book=9781449325862')]")
    private WebElement gitPocketGuideBook;

    @FindBy(css = "[id='ISBN-wrapper']")
    private WebElement isbnValue;

    @FindBy(xpath = "//div[@id='title-wrapper']//label[@id ='userName-value']")
    private WebElement titleValue;

    @FindBy(xpath = "//div[@id='author-wrapper']//label[@id ='userName-value']")
    private WebElement authorValue;

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

    public BookStorePage inputBookName(String bookName) {
        input(bookName, searchField);

        return new BookStorePage(getDriver());
    }

    public String getPlaceholderText() {

        return getText(placeholderSearchField);
    }

    public int getBooksListSize() {

        return getBooksList().size();
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

    public String getFirstBookInList() {

        return getBooksList().get(0);
    }

    public BookStorePage selectGitPocketGuideBook() {
        wait20ElementToBeClickable(gitPocketGuideBook);
        click(gitPocketGuideBook);

        return new BookStorePage(getDriver());
    }

    public BookStorePage clickAddToYourCollectionButton() {
        scrollByVisibleElement(addToYourCollectionButton);
        wait20ElementToBeVisible(addToYourCollectionButton);
        click(addToYourCollectionButton);
        acceptAlert();

        return new BookStorePage(getDriver());
    }

    public ProfilePage clickProfileSubMenu() {
        scrollByVisibleElement(profileSubMenu);
        click(profileSubMenu);

        return new ProfilePage(getDriver());
    }

    public BookStorePage selectBook(int bookIndexInList) {
        WebElement element = booksList.get(bookIndexInList);
        wait20ElementToBeClickable(element);
        click(element);

        return new BookStorePage(getDriver());
    }

    public Book getPartialBookInfo() {
        String isbn = isbnValue.getText();
        String title = titleValue.getText();
        String author = authorValue.getText();

        return new Book(isbn, title, author);
    }
}
