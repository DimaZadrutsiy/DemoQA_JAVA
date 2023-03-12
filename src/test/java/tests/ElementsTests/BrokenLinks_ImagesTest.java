package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrokenLinks_ImagesTest extends BaseTest {

    @Test
    public void testURLAndHeaderOfBrokenLinks_ImagesPage() {
        final String expectedURL = "https://demoqa.com/broken";
        final String expectedHeader = "Broken Links - Images";

        String actualURL = openBaseURL()
                .clickElementsMenu()
                .navigateToBrokenLinksImagesPage()
                .getCurrentURL();

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertTrue(getBrokenLinks_ImagesPage().isHeaderContainText(expectedHeader));
    }
}
