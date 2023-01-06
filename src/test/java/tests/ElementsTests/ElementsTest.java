package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.Elements.ElementsPage;

import java.util.Arrays;
import java.util.List;

public class ElementsTest extends BaseTest {

    @Test
    public void testURL_ElementsPage() {
        final String expectedURL = "https://demoqa.com/elements";

        String actualURL = openBaseURL()
                .clickElementsMenu()
                .getCurrentURL();

        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void testElementsList() {
        final List<String> expectedSubMenuHeaders = Arrays.asList(
                "Text Box", "Check Box", "Radio Button", "Web Tables", "Buttons", "Links", "Broken Links - Images",
                "Upload and Download", "Dynamic Properties"
        );
        final int expectedSubMenus = 9;

        ElementsPage elementsPage = openBaseURL()
                .clickElementsMenu();

        Assert.assertEquals(elementsPage.getElementsSubMenuHeaders(), expectedSubMenuHeaders);
        Assert.assertEquals(elementsPage.getElementsSubMenuAmount(), expectedSubMenus);
    }
}

