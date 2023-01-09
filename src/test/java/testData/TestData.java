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

    @DataProvider(name = "SelectableTabListData")
    public static Object[][] selectableTabListDataProvider() {

        return new Object[][]{
                {0, "mt-2 list-group-item list-group-item-action", "ToolsQA", "Cras justo odio"},
                {1, "mt-2 list-group-item list-group-item-action", "ToolsQA", "Dapibus ac facilisis in"},
                {2, "mt-2 list-group-item list-group-item-action", "ToolsQA", "Morbi leo risus"},
                {3, "mt-2 list-group-item list-group-item-action", "ToolsQA", "Porta ac consectetur ac"}
        };
    }
                
    @DataProvider(name = "CheckBoxTitle")
    public static Object[][] checkBoxDataProvider() {

        return new Object[][]{
                {0, "Home"},
                {1, "Desktop"},
                {2, "Notes"},
                {3, "Commands"},
                {4, "Documents"},
                {5, "WorkSpace"},
                {6, "React"},
                {7, "Angular"},
                {8, "Veu"},
                {9, "Office"},
                {10, "Public"},
                {11, "Private"},
                {12, "Classified"},
                {13, "General"},
                {14, "Downloads"},
                {15, "Word File"},
                {16, "Excel File"}
        };
    }
}