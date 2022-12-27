package pages.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class FormsPage extends BasePage {

    @FindBy(xpath = "//div[@class='element-list collapse show']")
    private WebElement practiceForm;

    @FindBy(xpath = "//div[@class='main-header']")
    private WebElement h2LogoHeader;

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public PracticeFormPage clickPracticeForm() {
        scrollByVisibleElement(practiceForm);
        click(practiceForm);

        return new PracticeFormPage(getDriver());
    }

    public String getH2LogoHeaderText() {

        return getText(h2LogoHeader);
    }
}
