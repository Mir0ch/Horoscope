package com.hallberg;

public class MonthPicker {

    String select(String monthPicker) {

        String month;

        switch(monthPicker) {
            case "JANUARY":
                month = "january";
                break;
            case "FEBRUARY":
                month = "february";
                break;
            case "MARCH":
                month = "march";
                break;
            case "APRIL":
                month = "april";
                break;
            case "MAY":
                month = "may";
                break;
            case "JUNE":
                month = "june";
                break;
            case "JULY":
                month = "july";
                break;
            case "AUGUST":
                month = "august";
                break;
            case "SEPTEMBER":
                month = "september";
                break;
            case "OCTOBER":
                month = "october";
                break;
            case "NOVEMBER":
                month = "november";
                break;
            case "DECEMBER":
                month = "december";
                break;
            default:
                month = "error";
                break;
        }

        return month;
    }
}
