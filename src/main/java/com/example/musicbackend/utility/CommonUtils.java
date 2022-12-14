package com.example.musicbackend.utility;

public class CommonUtils {

    private CommonUtils() {
        throw new IllegalStateException("CommonUtils class");
    }

    public static Long convertLong(Object temp){
        return Long.parseLong(temp == null ? "0l" : String.valueOf(temp));
    }

    public static String convertString(Object temp){
        return temp == null ? null : String.valueOf(temp);
    }

    public static Integer convertInteger(Object temp){
        return Integer.parseInt(temp == null ? "0" : String.valueOf(temp));
    }

    public static String convertValueSearch(String s){
        return VNCharacterUtils.deAccent(s);
    }
}
