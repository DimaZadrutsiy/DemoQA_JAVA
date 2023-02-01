package tests.InteractionTests;

import base.BaseTest;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Interactions.DroppablePage;

import static utils.ProjectConstants.*;

public class DroppableTest extends BaseTest {

    @Test
    public void testNavigationDroppablePage() {
        DroppablePage droppablePage = openBaseURL()
                .clickInteractionsMenu()
                .clickDroppablePage();

        Assert.assertFalse(droppablePage.getCurrentURL().contentEquals(BASE_URL));
        Assert.assertTrue(droppablePage.getCurrentURL().contentEquals(DROPPABLE_URL));
        Assert.assertTrue(droppablePage.getTitle().contentEquals(TITLE));
        Assert.assertTrue(droppablePage.getH2Header().contentEquals(DROPPABLE_HEADER));
    }

    @Test
    public void testSimpleDrop() {
        DroppablePage droppablePage = openBaseURL()
                .clickInteractionsMenu()
                .clickDroppablePage();

        Point pointStart = droppablePage.getSimpleFromElement().getLocation();

        droppablePage.dragAndDrop(droppablePage.clickSimpleTab().getSimpleFromElement());

        Point pointFinish = droppablePage.getSimpleFromElement().getLocation();

        Assert.assertNotEquals(pointFinish, pointStart);
        Assert.assertTrue(droppablePage.getCurrentURL().contentEquals(DROPPABLE_URL));
    }
}