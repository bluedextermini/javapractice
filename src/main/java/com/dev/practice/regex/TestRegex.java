package com.dev.practice.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {

        String str="ssdjfklsdjfldsf@sjdlfjdlf@dsjlkjsf^sdfdf$";
        Pattern p=Pattern.compile("[@^$]");
        Matcher matcher=p.matcher(str);
        int count = 0;
        int i = 0;
        while (matcher.find(i)) {
            count++;
            i = matcher.start() + 1;
        }

        System.out.println(count);



    }
}
