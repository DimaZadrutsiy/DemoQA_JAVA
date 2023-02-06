package tests.InteractionTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Interactions.SelectablePage;
import pages.Interactions.SortablePage;

import java.util.ArrayList;
import java.util.List;

public class SortableTest extends BaseTest {

    @Test
    public void testReversWebElements() {
        final List<String> expectedReversedList = new ArrayList<>();
        expectedReversedList.add("One");
        expectedReversedList.add("Two");
        expectedReversedList.add("Three");
        expectedReversedList.add("Four");
        expectedReversedList.add("Five");
        expectedReversedList.add("Six");

        List<String> actualReversedList = openBaseURL()
                .clickInteractionsMenu()
                .clickSortablePage()
                .getReversedList();

        Assert.assertNotEquals(actualReversedList, expectedReversedList);
    }

    @Test
    public void testRandomElementGrid_ElementsCanBeSwapped() {
        final List<String> expectedList = new ArrayList<>();
        expectedList.add("One");
        expectedList.add("Two");
        expectedList.add("Three");
        expectedList.add("Four");
        expectedList.add("Five");
        expectedList.add("Six");
        expectedList.add("Seven");
        expectedList.add("Eight");
        expectedList.add("Nine");

        List<String> actualRandomList = openBaseURL()
                .clickInteractionsMenu()
                .clickSortablePage()
                .clickBookmarkGrid()
                .getRandomList();

        Assert.assertNotEquals(actualRandomList, expectedList);
    }

    @Test
    public void testNavigationAndHeaderSortablePage() {
        final String expectedUrl = "https://demoqa.com/sortable";
        final String expectedHeader = "Sortable";

        SortablePage sortablePage = openBaseURL()
                .clickInteractionsMenu()
                .clickSortablePage();

        String actualUrl = sortablePage.getCurrentURL();
        String actualHeader = sortablePage.getH2Header();

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(actualHeader, expectedHeader);
    }
}
