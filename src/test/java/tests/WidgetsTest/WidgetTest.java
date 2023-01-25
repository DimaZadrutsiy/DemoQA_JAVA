package tests.WidgetsTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Widgets.WidgetsPage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class WidgetTest extends BaseTest {

    @Test
    public void testURL_WidgetsPage() {
        final String expectedURL = "https://demoqa.com/widgets";

        String actualURL = openBaseURL()
                .clickWidgetsMenu()
                .getCurrentURL();

        Assert.assertEquals(expectedURL, actualURL);
    }

    @Test
    public void testWidgetsList() {
        final List<String> expectedSubMenuHeaders = Arrays.asList(
                "Accordian", "Auto Complete", "Date Picker", "Slider", "Progress Bar", "Tabs", "Tool Tips", "Menu",
                "Select Menu"
        );
        final int expectedSubMenus = 9;

        WidgetsPage widgetsPage = openBaseURL()
                .clickWidgetsMenu();

        Assert.assertEquals(widgetsPage.getWidgetsSubMenuHeaders(), expectedSubMenuHeaders);
        Assert.assertEquals(widgetsPage.getWidgetsSubMenuAmount(), expectedSubMenus);
    }
}
