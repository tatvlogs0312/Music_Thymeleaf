package com.example.musicbackend.utility;

public class StringUtils {

    private StringUtils() {
        throw new IllegalStateException("StringUtils class");
    }

    public static boolean isNullOrEmpty(String val) {
        return val == null || val.trim().isEmpty();
    }
}
