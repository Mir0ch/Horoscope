package com.hallberg;

public class Horoscope {

    public static void main(String[] args) {

        String signInput;
        String sign = "";

        if(!(args.length == 0))
        {
            signInput = args[0].toUpperCase();

            SignPicker signPicker = new SignPicker();
            sign = signPicker.select(signInput);
        }

        if(!sign.equals("error") && args.length == 1)
            System.out.println("https://www.sunsigns.org/" + sign + "-november-2019-horoscope/");
        else
            System.out.println("Usage: \"Horoscope your-sign\" i. e. \"Horoscope Leo\"");
        // https://www.sunsigns.org/sagittarius-november-2019-horoscope/
    }
}
