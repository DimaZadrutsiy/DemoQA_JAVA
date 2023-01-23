package tests.InteractionTests;

import base.BaseTest;
import org.openqa.selenium.Point;
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

    @Test
    public void testSimpleDrop() {
        final String expectedUrl = "https://demoqa.com/droppable";

        DroppablePage droppablePage = openBaseURL()
                .clickInteractionsMenu()
                .clickDroppablePage()
                .clickSimpleTab();

        Point pointStart = droppablePage.getFromElementSimple().getLocation();

        Assert.assertTrue(droppablePage.getCurrentURL().contentEquals(expectedUrl));

        droppablePage.dragAndDrop(droppablePage.getFromElementSimple(), droppablePage.getToElementSimple());

        Point pointFinish = droppablePage.getFromElementSimple().getLocation();

        Assert.assertNotEquals(pointFinish, pointStart);
        Assert.assertEquals(pointFinish.getX(), 844);
        Assert.assertTrue(pointFinish.getX() > 400);
    }
}