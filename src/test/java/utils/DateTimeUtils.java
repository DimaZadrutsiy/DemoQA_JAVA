package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {
    public static String getCurrentDateTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd, hh:mma");

        return dateFormat.format(date);
    }

    public static String getTimeInMinSecFormat(long time) {
        int minutes = (int) ((time / 1000) / 60);
        int seconds = (int) (time / 1000) % 60;

        return "" + minutes + " min " + seconds + " sec";
    }

    public static int daysInMonth(int month, int year) {
        int numDays;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            case 2:
                if (((year % 4 == 0) &&
                        !(year % 100 == 0))
                        || (year % 400 == 0))
                    numDays = 29;
                else
                    numDays = 28;
                break;
            default:

                return 0;
        }

        return numDays;
    }

    public static String returnMonth(int number) {
        if (number > 0 && number < 13) {
            switch (number) {
                case 1:
                    return "Jan";
                case 2:
                    return "Feb";
                case 3:
                    return "Mar";
                case 4:
                    return "Apr";
                case 5:
                    return "May";
                case 6:
                    return "Jun";
                case 7:
                    return "Jul";
                case 8:
                    return "Aug";
                case 9:
                    return "Sep";
                case 10:
                    return "Oct";
                case 11:
                    return "Nov";
                case 12:
                    return "Dec";
            }
        }

        return "Error";
    }

    public static int returnMonth(String month) {
        if (month != null) {
            switch (month) {
                case "Jan":
                    return 1;
                case "Feb":
                    return 2;
                case "Mar":
                    return 3;
                case "Apr":
                    return 4;
                case "May":
                    return 5;
                case "Jun":
                    return 6;
                case "Jul":
                    return 7;
                case "Aug":
                    return 8;
                case "Sep":
                    return 9;
                case "Oct":
                    return 10;
                case "Nov":
                    return 11;
                case "Dec":
                    return 12;
            }
        }

        return 0;
    }

    public static String returnDayOfTheWeek(int number) {
        if (number > 0 && number < 8) {
            switch (number) {
                case 1:
                    return "Mon";
                case 2:
                    return "Tue";
                case 3:
                    return "Wed";
                case 4:
                    return "Thu";
                case 5:
                    return "Fri";
                case 6:
                    return "Sat";
                case 7:
                    return "Sun";
            }
        }

        return "Error";
    }

    public static int returnDayOfTheWeek(String day) {
        if (day != null) {
            switch (day) {
                case "Mon":
                    return 1;
                case "Tue":
                    return 2;
                case "Wed":
                    return 3;
                case "Thu":
                    return 4;
                case "Fri":
                    return 5;
                case "Sat":
                    return 6;
                case "Sun":
                    return 7;
            }
        }

        return 0;
    }

    public static String returnDate(int date) {
        if (date < 10) {

            return "0" + date;
        } else {

            return String.valueOf(date);
        }
    }

    public static String getEightDaysFromDate(String day, int month, int date, int year) {
        int currentYear = year;
        StringBuilder stringBuilder = new StringBuilder();

        if (day == null || returnDayOfTheWeek(day) == 0 ||
                returnMonth(month).equals("Error") ||
                month <= 0 ||
                date <= 0 ||
                date > (daysInMonth(month, year))
        ) {

            return "Please enter correct data.";

        } else {
            int currentDay = returnDayOfTheWeek(day);
            int currentMonth = month;
            int currentDate = date;

            for (int i = 0; i <= 7; i++) {
                if (currentDay != 7) {
                    stringBuilder.append(returnDayOfTheWeek(currentDay)).append(", ");
                    currentDay++;
                } else {
                    stringBuilder.append(returnDayOfTheWeek(currentDay)).append(", ");
                    currentDay = 1;
                }

                if (currentDate <= daysInMonth(currentMonth, currentYear)) {
                    stringBuilder.append(returnMonth(currentMonth)).append(" ").append(returnDate(currentDate)).append(", ");
                    currentDate++;
                } else {
                    if (currentMonth != 12) {
                        currentMonth++;
                    } else {
                        currentMonth = 1;
                        currentYear = year + 1;
                    }
                    currentDate = 1;
                    stringBuilder.append(returnMonth(currentMonth)).append(" ").append(returnDate(currentDate)).append(", ");
                    currentDate++;
                }
            }
        }

        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
}
