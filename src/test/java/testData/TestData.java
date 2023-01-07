package testData;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "FormsRegistrationData")
    public static Object[][] mainDataProvider() {

        return new Object[][]{
                {"Vasily", "Peremoga", "peremoga@google.com", "Male", "0123456789"}
        };
    }

    @DataProvider(name = "PracticeFormsAttribute")
    public static Object[][] attributeDataProvider() {

        return new Object[][]{
                {"https://demoqa.com/automation-practice-form", "ToolsQA", "Practice Form"}
        };
    }

    @DataProvider(name = "DifferentBooksSearching")
    public static Object[][] differentBooksSearching() {
        return new Object[][]{
                {0, "Java", "Learning JavaScript Design Patterns", 4},
                {1, "Git", "Git Pocket Guide", 1},
                {2, "API", "Designing Evolvable Web APIs with ASP.NET", 1},
                {3, "JS", "You Don't Know JS", 1}
        };
    }

    @DataProvider(name = "InteractionsSubmenu")
    public static Object[][] interactionsSubmenuDataProvider() {

        return new Object[][]{
                {0, "https://demoqa.com/sortable", "ToolsQA", "Sortable"},
                {1, "https://demoqa.com/selectable", "ToolsQA", "Selectable"},
                {2, "https://demoqa.com/resizable", "ToolsQA", "Resizable"},
                {3, "https://demoqa.com/droppable", "ToolsQA", "Droppable"},
                {4, "https://demoqa.com/dragabble", "ToolsQA", "Dragabble"}
        };
    }
}