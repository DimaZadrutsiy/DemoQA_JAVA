package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Elements.ElementsPage;

public class RadioButtonTest extends BaseTest {

    @Test
    public void testYesRadioButtonsSelected() {
        ElementsPage radioButtonPage = openBaseURL()
                .clickElementsMenu()
                .openRadioButtonPage()
                .clickOnYesRadioButton();





       Assert.assertTrue(radioButtonPage.openRadioButtonPage().isRadioButtonSelected());
    }
}
