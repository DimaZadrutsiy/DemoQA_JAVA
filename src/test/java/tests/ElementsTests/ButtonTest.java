package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Elements.ButtonsPage;

import java.util.ArrayList;
import java.util.List;

public class ButtonTest extends BaseTest {

    @Test
    public void testCheckingMessagesWhenButtonsArePressed() {
        final String expectedMessage_Button_DoubleClickMe = "You have done a double click";
        final String expectedMessage_Button_RightClickMe = "You have done a right click";
        final String expectedMessage_Button_ClickMe = "You have done a dynamic click";

        ButtonsPage buttonsPage = openBaseURL()
                .clickElementsMenu()
                .clickButtons()
                .clickButton_ClickMe()
                .clickButton_DoubleClickMe()
                .clickButton_RightClickMe();

        String actualMessage_Button_DoubleClickMe = buttonsPage
                .messageForButton_DoubleClickMe();

        String actualMessage_Button_RightClickMe = buttonsPage
                .messageForButton_RightClickMe();

        String actualMessage_Button_ClickMe = buttonsPage
                .messageForButton_ClickMe();

        Assert.assertEquals(actualMessage_Button_DoubleClickMe, expectedMessage_Button_DoubleClickMe);
        Assert.assertEquals(actualMessage_Button_RightClickMe, expectedMessage_Button_RightClickMe);
        Assert.assertEquals(actualMessage_Button_ClickMe, expectedMessage_Button_ClickMe);
    }

    @Test
    public void testCheckingNamesButtons() {
        final List<String> expectedNamesButtons = new ArrayList<>();
        expectedNamesButtons.add("Double Click Me");
        expectedNamesButtons.add("Right Click Me");
        expectedNamesButtons.add("Click Me");

        List<String> actualNamesButton = openBaseURL()
                .clickElementsMenu()
                .clickButtons()
                .getNamesAllButtons();

        Assert.assertEquals(actualNamesButton, expectedNamesButtons);
    }

    @Test
    public void testCheckingQuantityButtons() {
        final int expectedNumberOfButtons = 3;

        int actualNumberOfButtons = openBaseURL()
                .clickElementsMenu()
                .clickButtons()
                .getNumberOfButtons();

        Assert.assertEquals(actualNumberOfButtons, expectedNumberOfButtons);
    }

    @Test
    public void testCheckingMainHeader() {
        final String expectedHeader = "Buttons";

        String actualHeader = openBaseURL()
                .clickElementsMenu()
                .clickButtons()
                .getMainHeader();

        Assert.assertEquals(actualHeader, expectedHeader);
    }
}