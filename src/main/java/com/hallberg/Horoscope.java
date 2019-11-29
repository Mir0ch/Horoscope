package com.hallberg;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Horoscope {

    public static void main(String[] args) throws IOException {

        String signInput;
        String sign = "";

        String monthInput;
        String month = "";

        if((args.length == 2))
        {
            signInput = args[0].toUpperCase();

            SignPicker signPicker = new SignPicker();
            sign = signPicker.select(signInput);

            monthInput = args[1].toUpperCase();

            MonthPicker monthPicker = new MonthPicker();
            month = monthPicker.select(monthInput);
        }

        if(!sign.equals("error") || !month.equals("error")) {
            String url = "https://www.sunsigns.org/" + sign + "-" + month + "-2019-horoscope/";
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            System.out.println(title);
        }
        else {
            System.out.println("Usage: \"Horoscope your-sign month year\" i. e. \"Horoscope Leo November 2019\"");
            // https://www.sunsigns.org/sagittarius-november-2019-horoscope/
        }
    }
}
