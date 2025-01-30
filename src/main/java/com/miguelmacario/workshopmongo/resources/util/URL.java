package com.miguelmacario.workshopmongo.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {

    public static String decodeParam(String str) {
        return URLDecoder.decode(str, StandardCharsets.UTF_8);
    }

    public static LocalDate convertDate(String textDate, LocalDate defaultDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            return LocalDate.parse(textDate, formatter);
        } catch (DateTimeParseException e){
            return defaultDate;
        }
    }

}
