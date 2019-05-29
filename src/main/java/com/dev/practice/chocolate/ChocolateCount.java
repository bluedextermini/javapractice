package com.dev.practice.chocolate;

public class ChocolateCount {

    static int chocolateCount(int orig, int remainingWrapper) {
        if (orig == 0)
            return 0 + remainingWrapper / 3;
        return orig +
                chocolateCount(orig / 3, remainingWrapper + orig % 3);
    }


    public static void main(String[] args) {
        System.out.print(chocolateCount(50, 0));

    }
}
