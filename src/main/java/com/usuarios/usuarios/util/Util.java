package com.usuarios.usuarios.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static Boolean validaEmail (String email, String patternString) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
