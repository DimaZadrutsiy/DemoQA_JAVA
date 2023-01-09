package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookStoreApplication.BookStorePage;
import pages.Elements.ElementsPage;
import pages.Elements.RadioButtonPage;

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

    @Test
    public void testNoRadioButtonsSelected()  {

        ElementsPage radioButtonPage = openBaseURL()
                .clickElementsMenu()
                .openRadioButtonPage()
                .clickOnNoRadioButton();

        Assert.assertFalse(radioButtonPage.openRadioButtonPage().isRadioButtonNoSelected());
    }

    @Test
    public void testRadioButtonsURL()  {

        String expectedResult = "https://demoqa.com/radio-button";

        RadioButtonPage radioButtonPage = openBaseURL()
                .clickElementsMenu()
                .openRadioButtonPage();

        String actualResult = radioButtonPage.getCurrentURL();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
