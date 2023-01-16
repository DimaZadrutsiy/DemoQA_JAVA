package api;


import java.util.List;

public class ApiHelpers {

    public static String getFormattedResult(List<String> list) {
        return list
                .toString()
                .replaceAll(".$", "")
                .replaceAll("^.", "");
    }
}
