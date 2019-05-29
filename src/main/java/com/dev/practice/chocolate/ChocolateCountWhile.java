package com.dev.practice.chocolate;

public class ChocolateCountWhile {
    public static void main(String[] args) {
        int orig = 15, remaining = 0, count = orig;
        while (orig / 3 != 0  || remaining>0) {
            remaining += orig % 3;
            count += (orig / 3) + (remaining / 3);
            orig = orig / 3;
            remaining %= 3;

        }
        System.out.println(count);

    }
}
