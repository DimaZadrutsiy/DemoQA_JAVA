package tests.InteractionTests;

import base.BaseTest;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
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

    @Test
    public void testResizableBox() {
        ResizablePage resizablePage = openBaseURL()
                .clickInteractionsMenu()
                .clickResizablePage();

        Point pointStart = resizablePage.getResizableBox().getLocation();

        Actions resize = new Actions(getDriver());

        resize.dragAndDropBy(resizablePage.getResizableBox(), 300, 100).perform();
        Point pointMiddle = resizablePage.getResizableBox().getLocation();
        resize.dragAndDropBy(resizablePage.getResizableBox(), -300, -100).perform();
        Point pointFinish = resizablePage.getResizableBox().getLocation();

        Assert.assertNotEquals(pointFinish, pointMiddle);
        Assert.assertEquals(pointFinish, pointStart);
        Assert.assertEquals(resizablePage.getCurrentURL(), RESIZABLE_URL);
    }

    @Ignore
    @Test
    public void testResizablePlain() {
        ResizablePage resizablePage = openBaseURL()
                .clickInteractionsMenu()
                .clickResizablePage();

        Point pointStart = resizablePage.getResizablePlain().getLocation();

        Actions resize = new Actions(getDriver());

        resize.dragAndDropBy(resizablePage.getResizablePlain(), 500, 0)
                .dragAndDropBy(resizablePage.getResizablePlain(), 0, 200)
                .dragAndDropBy(resizablePage.getResizablePlain(), -500, 0)
                .dragAndDropBy(resizablePage.getResizablePlain(), 0, -200).perform();

        Point pointFinish = resizablePage.getResizablePlain().getLocation();

        Assert.assertEquals(pointFinish, pointStart);
        Assert.assertEquals(resizablePage.getCurrentURL(), RESIZABLE_URL);
    }
}
