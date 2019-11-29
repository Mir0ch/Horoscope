package com.hallberg;

class SignPicker {

    String select(String signPicker) {

        String sign;

        switch(signPicker) {
            case "ARIES":
                sign = "aries";
                break;
            case "TAURUS":
                sign = "taurus";
                break;
            case "GEMINI":
                sign = "gemini";
                break;
            case "CANCER":
                sign = "cancer";
                break;
            case "LEO":
                sign = "leo";
                break;
            case "VIRGO":
                sign = "virgo";
                break;
            case "LIBRA":
                sign = "libra";
                break;
            case "SCORPIO":
                sign = "scorpio";
                break;
            case "SAGITTARIUS":
                sign = "sagittarius";
                break;
            case "CAPRICORN":
                sign = "capricorn";
                break;
            case "AQUARIUS":
                sign = "aquarius";
                break;
            case "PISCES":
                sign = "pisces";
                break;
            default:
                sign = "error";
                break;
        }

        return sign;
    }
}
