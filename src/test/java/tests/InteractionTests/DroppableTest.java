package tests.InteractionTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Interactions.DroppablePage;

public class DroppableTest extends BaseTest {

    @Test
    public void testNavigationDroppablePage() {
        final String expectedUrl = "https://demoqa.com/droppable";
        final String expectedTitle = "ToolsQA";
        final String expectedHeader = "Droppable";
        final String expectedBasedURL = "https://demoqa.com/";

        DroppablePage droppablePage = openBaseURL()
                .clickInteractionsMenu()
                .clickDroppablePage();

        Assert.assertFalse(droppablePage.getCurrentURL().contentEquals(expectedBasedURL));
        Assert.assertTrue(droppablePage.getCurrentURL().contentEquals(expectedUrl));
        Assert.assertTrue(droppablePage.getTitle().contentEquals(expectedTitle));
        Assert.assertTrue(droppablePage.getH2Header().contentEquals(expectedHeader));
    }
}
