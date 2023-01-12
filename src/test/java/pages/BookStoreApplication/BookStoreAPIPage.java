package pages.BookStoreApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStoreAPIPage extends BookStorePage {

    @FindBy (css = "#see-book-Designing\\ Evolvable\\ Web\\ APIs\\ with\\ ASP\\.NET > a")
    WebElement bookDesigning_Evolvable_Web_APIs_With_ASP_NET;

    @FindBy (css = "#userName-value")
    WebElement isbnNumber_BookDesigning_Evolvable_Web_APIs_With_ASP_NET;

    public BookStoreAPIPage(WebDriver driver) {
        super(driver);
    }

    public BookStoreAPIPage clickBookDesigning_Evolvable_Web_APIs_With_ASP_NET() {
        scrollByVisibleElement(bookDesigning_Evolvable_Web_APIs_With_ASP_NET);
        click(bookDesigning_Evolvable_Web_APIs_With_ASP_NET);

        return new BookStoreAPIPage(getDriver());
    }

    public String getIsbnNumber() {

        return getText(isbnNumber_BookDesigning_Evolvable_Web_APIs_With_ASP_NET);
    }
}
