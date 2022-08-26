package com.familyshop.microservice.balancecheck.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class BalanceCheckUtil {
    public static String getCurrentTimeStamp(){
        ZonedDateTime date = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        String text = date.format(formatter);
        return text;
    }
}
