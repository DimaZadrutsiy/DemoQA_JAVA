package tests.WidgetsTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Widgets.AutoCompletePage;

public class AutoCompleteTest extends BaseTest {

    @Test
    private void testCheckTheInputFieldsOfContainers() {
        final String expectedColor1 = "Blue";
        final String expectedColor2 = "Yellow";
        final String expectedColor3 = "White";

        AutoCompletePage autoCompletePage = openBaseURL()
                .clickWidgetsMenu()
                .clickAutoCompletePages()
                .clickMultipleContainer()
                .inputColorMultipleContainer(expectedColor1, expectedColor2, expectedColor3)
                .clickSingleContainer()
                .inputColorSingleContainer(expectedColor2);

        Assert.assertTrue(autoCompletePage.checkInputColorsMultipleContainer().contains(expectedColor1));
        Assert.assertTrue(autoCompletePage.checkInputColorsMultipleContainer().contains(expectedColor2));
        Assert.assertTrue(autoCompletePage.checkInputColorsMultipleContainer().contains(expectedColor3));
        Assert.assertTrue(autoCompletePage.checkInputColorSingleContainer().contains(expectedColor2));



    }
}
