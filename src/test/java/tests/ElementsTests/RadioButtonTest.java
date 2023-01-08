package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Elements.ElementsPage;

public class RadioButtonTest extends BaseTest {

    @Test
    public void testImpressiveRadioButtonsSelected()  {

        String expectedResultText = "Impressive";

        ElementsPage radioButtonPage = openBaseURL()
                .clickElementsMenu()
                .openRadioButtonPage()
                .clickOnImpressibeRadioButton();

       Assert.assertTrue(radioButtonPage.openRadioButtonPage().isRadioButtonImpressiveSelected());
       Assert.assertTrue(radioButtonPage.openRadioButtonPage().impressiveButtonText(expectedResultText));

    }

    @Test
    public void testYesRadioButtonsSelected()  {

        String expectedResultText = "Yes";

        ElementsPage radioButtonPage = openBaseURL()
                .clickElementsMenu()
                .openRadioButtonPage()
                .clickOnYesRadioButton();

        Assert.assertTrue(radioButtonPage.openRadioButtonPage().isRadioButtonYesSelected());
        Assert.assertTrue(radioButtonPage.openRadioButtonPage().yesButtonText(expectedResultText));

    }
}
