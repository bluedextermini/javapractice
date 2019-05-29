package com.dev.practice.xml;


import java.io.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        FileReader f= null;
        try {
            f = new FileReader("c:\\temp\\payerdata.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(f);
        String str=br.lines().collect(Collectors.joining());
        Date d = new Date();
        System.out.println(extractChild("payeraccountnumber", str));



    }

    public static String extractChild(String name, String content){



        Pattern p= Pattern.compile("<" + name + ">[\\W\\w.]*<\\/" + name + ">");
        Matcher m=p.matcher(content);
        //System.out.println(m.group());
        String out="";
        while (m.find()) {
            out= m.group();
            // s now contains "BAR"
        }

        return  out;

    }
}