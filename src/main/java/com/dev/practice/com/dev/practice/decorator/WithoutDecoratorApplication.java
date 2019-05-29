package com.dev.practice.com.dev.practice.decorator;

import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm;

class WithoutDecoratorApplication {
    public static void main(String[] args) {
        String message="Chhitthi Aayi hia";
        /*Notifier notifier= new Notifier();
        notifier.send(message);*/
        FacebookNotifier facebookNotifier= new FacebookNotifier();
        facebookNotifier.send(message);
        TwitterNotifier twitterNotifier= new TwitterNotifier();
        twitterNotifier.send(message);
        FacebookTwitterNotifier facebookTwitterNotifier= new FacebookTwitterNotifier();
        facebookTwitterNotifier.send(message);
    }
}


class Notifier  {
    void send(String Message){
        System.out.println("message:"+Message);
        System.out.print(" mode:Email");
    }
}


class FacebookNotifier  {
    void send(String Message){
        System.out.println("message:"+Message);
        System.out.print(" mode:Facebook");
    }
}

class TwitterNotifier  {
    void send(String Message){
        System.out.println("message:"+Message +" mode:twitter");
        System.out.println();
    }
}

class FacebookTwitterNotifier  {
    void send(String Message){
        (new FacebookNotifier()).send(Message);
        (new TwitterNotifier()).send(Message);
    }
}





