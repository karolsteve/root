package com.steve.rootexample.utils;

import com.steve.mvp.base.utils.RootUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.regex.Pattern;


public class Utils extends RootUtils {

    public static boolean isValidSimplePhone(String phone) {
        return phone != null && Pattern.compile("^6[56789]\\d{7}$").matcher(phone).matches();
    }

    public static String parseNumber(String number) {
        Pattern pattern = Pattern.compile("^((00|\\+)?237)?6[56789]\\d{7}$");
        if (pattern.matcher(number).matches()) {
            if (number.startsWith("+")) {
                return number;
            } else if (number.startsWith("00")) {
                return number.replace("00", "+");
            } else if (number.startsWith("237")) {
                return "+" + number;
            } else {
                return "+237" + number;
            }
        }
        return null;
    }

    public static String formatNumber(String number) {

        String text = number.trim().replaceAll("\\.00", "");
        int length = text.length();
        if (length > 3) {
            StringBuilder builder = new StringBuilder();
            int j = 0;
            for (int i = text.length(); i > 0; i--) {
                j++;
                builder.append(text.charAt(i - 1));
                if (j % 3 == 0 && j != length) {
                    builder.append(".");
                }
            }
            return builder.reverse().toString();
        }
        return text;
    }

    public static long convertDateToTimestamp(String date) {
        if(date == null || date.equals("null") || !date.contains("-")) return System.currentTimeMillis();
        String[] splitDate = date.replaceAll(" ", "").split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(splitDate[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(splitDate[1]) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(splitDate[2]));
        return calendar.getTimeInMillis();
    }

    public static long convertDateAndTimeToTimestamp(String date, String time) {
        if(date == null || date.equals("null") || !date.contains("-") || time == null || !time.contains(":")) return System.currentTimeMillis();
        String[] splitDate = date.replaceAll(" ", "").split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(splitDate[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(splitDate[1]) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(splitDate[2]));

        String[] splitTime = time.replaceAll(" ", "").split(":");
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(splitTime[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(splitTime[1]));
        calendar.set(Calendar.SECOND, splitTime.length > 2 ? Integer.parseInt(splitTime[2]) : 0);

        return calendar.getTimeInMillis();
    }

    public static String formatNumber(int number) {
        return formatNumber(String.valueOf(number));
    }

    public static int convertToInt(String amount) {
        try {
            return (int) Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            return 0;
        }
    }


    public static String encryptToMD5(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] digested = digest.digest(text.getBytes());
            return new String(digested);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return text;
        }
    }
}
