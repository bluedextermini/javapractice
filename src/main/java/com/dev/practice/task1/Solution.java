package com.dev.practice.task1;

class Solution {
    static public int solution(int[] S) {
        int max_sum = 0;
        int current_sum = 0;
        boolean positive = false;
        int n = S.length;
        for (int i = 0; i < n; ++i) {
            int item = S[i];
            if (item < 0) {
                if (max_sum < current_sum) {
                    max_sum = current_sum;
                    current_sum = 0;
                }
            } else {
                positive = true;
                current_sum += item;
                if(((i+1)<n && S[i]>S[i+1]) && max_sum<current_sum){
                    max_sum = current_sum;current_sum = 0;
                }
            }
        }
        if (current_sum > max_sum) {
            max_sum = current_sum;
        }
        if (positive) {
            return max_sum;
        }
        return -1;
    }

    public static void main(String[] args) {
        //int s[]={1,-2,-3,-4,-5,-6};
        int s[]={1,-2,-3,-4,8,9};
        System.out.println(solution(s));
    }
}