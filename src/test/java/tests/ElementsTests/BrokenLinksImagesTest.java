package tests.ElementsTests;

import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrokenLinksImagesTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BrokenLinksImagesTest.class);

    @Test
    public void testURLAndHeaderOfBrokenLinks_ImagesPage() {
        final String expectedURL = "https://demoqa.com/broken";
        final String expectedHeader = "Broken Links - Images";

        String actualURL = openBaseURL()
                .clickElementsMenu()
                .navigateToBrokenLinksImagesPage()
                .getCurrentURL();

        logger.info("Actual URL = " + actualURL);

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertTrue(getBrokenLinks_ImagesPage().isHeaderContainText(expectedHeader));
    }
}
