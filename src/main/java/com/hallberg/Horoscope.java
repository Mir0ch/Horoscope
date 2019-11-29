package com.hallberg;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Horoscope {

    public static void main(String[] args) throws IOException {

        String signInput;
        String sign = "";

        if(!(args.length == 0))
        {
            signInput = args[0].toUpperCase();

            SignPicker signPicker = new SignPicker();
            sign = signPicker.select(signInput);
        }

        if(!sign.equals("error") && args.length == 1) {
            String url = "https://www.sunsigns.org/" + sign + "-november-2019-horoscope/";
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            System.out.println(title);
        }
        else {
            System.out.println("Usage: \"Horoscope your-sign\" i. e. \"Horoscope Leo\"");
            // https://www.sunsigns.org/sagittarius-november-2019-horoscope/
        }
    }
}
