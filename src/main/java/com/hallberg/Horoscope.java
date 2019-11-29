package com.hallberg;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

            String periodText = rawText.replaceAll("((?:\\w+\\s){8}\\w+)(\\s)", "$1\n");
            String text = periodText.replaceAll("(\\.\\s)", "$1\n");

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

    // Method that returns the count of the given
    // character in the string
    public static long count(String s, char ch)
    {

        // Use Matcher class of java.util.regex
        // to match the character
        Matcher matcher
                = Pattern.compile(String.valueOf(ch))
                .matcher(s);

        int res = 0;

        // for every presence of character ch
        // increment the counter res by 1
        while (matcher.find()) {
            res++;
        }

        return res;
    }
}
