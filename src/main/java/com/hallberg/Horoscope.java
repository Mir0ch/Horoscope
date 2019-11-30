package com.hallberg;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Horoscope {

    public static void main(String[] args) {

        String signInput;
        String sign = "";
        String nextmonthInput;
        String nextmonth = "";

        int monthInput;
        String month;
        int year;

        if(!(args.length == 0)) {
            signInput = args[0].toUpperCase();

            SignPicker signPicker = new SignPicker();
            sign = signPicker.select(signInput);
        }

        if(args.length > 1) {
            nextmonthInput = args[1].toUpperCase();

            MonthPicker monthPicker = new MonthPicker();
            nextmonth = monthPicker.next(nextmonthInput);
        }

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        monthInput = localDate.getMonthValue();
        year = localDate.getYear();

        if(args.length > 1 && nextmonth.equals("nextmonth")) {

            monthInput++;

            if(monthInput == 13) {
                monthInput = 1;
                year++;
            }
        }

        MonthPicker monthPicker = new MonthPicker();
        month = monthPicker.select(monthInput);

        if(!sign.equals("")) {

            try {

                String url = "https://www.sunsigns.org/" + sign + "-" + month + "-" + year + "-horoscope/";

                Document doc = Jsoup.connect(url).get();
                Element p = doc.select("p[style]").first();
                String rawText = p.text();

                String text = rawText.replaceAll("((?:\\S+\\s){6}\\S+)(\\s)", "$1\n");

                String pipeDelimitedTitle = doc.title();
                String[] titleArray = pipeDelimitedTitle.split("\\|");
                String title = titleArray[0];

                System.out.println();
                System.out.println(title);
                System.out.println();
                System.out.println(text);

            } catch (IOException e) {
                System.out.println();
                System.out.printf("Can't connect to %s.\nCheck your internet connection.\n", e.getMessage());
            }
        }
        else {
            System.out.println("Usage: \"Horoscope your-sign\" i. e. \"Horoscope Leo\"\n" +
                    "Add parameter \"nextmonth\" to get next month's reading.");
            // https://www.sunsigns.org/sagittarius-november-2019-horoscope/
        }
    }
}
