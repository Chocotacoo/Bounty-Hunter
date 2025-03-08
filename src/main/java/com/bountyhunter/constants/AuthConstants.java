package com.bountyhunter.constants;

import java.util.Base64;

public class AuthConstants {
    // Store encoded credentials (username: bountyhunter@dmin, password: killThem)
    public static final String USERNAME = "Ym91bnR5aHVudGVyQGRtaW4=";
    public static final String PASSWORD = "a2lsbFRoZW0=";


    // Utility method to encode credentials
    public static String encode(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes());
    }
/// //
    // Utility method to decode credentials
    public static String decode(String encodedValue) {
        return new String(Base64.getDecoder().decode(encodedValue));
    }
}
