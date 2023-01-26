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
        expectedReversedList.add("Six");
        expectedReversedList.add("Five");
        expectedReversedList.add("Four");
        expectedReversedList.add("Three");
        expectedReversedList.add("Two");
        expectedReversedList.add("One");

        List<String> actualReversedList = openBaseURL()
                .clickInteractionsMenu()
                .clickSortablePage()
                .getReversedList();

        Assert.assertEquals(actualReversedList, expectedReversedList);
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
}
