package tests.InteractionTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
