package com.hallberg;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Horoscope {

    public static void main(String[] args) throws IOException {

        String signInput;
        String sign = "";

        int monthInput;
        String month;
        int year;

        if(!(args.length == 0))
        {
            signInput = args[0].toUpperCase();

            SignPicker signPicker = new SignPicker();
            sign = signPicker.select(signInput);
        }

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        monthInput = localDate.getMonthValue();

        MonthPicker monthPicker = new MonthPicker();
        month = monthPicker.select(monthInput);

        year = localDate.getYear();

        if(!sign.equals("")) {

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
        }
        else {
            System.out.println("Usage: \"Horoscope your-sign\" i. e. \"Horoscope Leo\"");
            // https://www.sunsigns.org/sagittarius-november-2019-horoscope/
        }
    }
}
