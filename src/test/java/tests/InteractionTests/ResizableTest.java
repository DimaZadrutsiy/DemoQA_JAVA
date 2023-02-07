package tests.InteractionTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Interactions.ResizablePage;

import static utils.ProjectConstants.*;

public class ResizableTest extends BaseTest {

    @Test
    public void testNavigationResizablePage() {
        ResizablePage resizablePage = openBaseURL()
                .clickInteractionsMenu()
                .clickResizablePage();

        Assert.assertNotEquals(resizablePage.getCurrentURL(), BASE_URL);
        Assert.assertEquals(resizablePage.getCurrentURL(), RESIZABLE_URL);
        Assert.assertEquals(resizablePage.getTitle(), TITLE);
        Assert.assertEquals(resizablePage.getH2Header(), RESIZABLE_HEADER);
    }
}
