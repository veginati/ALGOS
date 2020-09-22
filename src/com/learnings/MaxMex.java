package com.learnings;

import java.util.*;
import java.lang.*;
import java.io.*;

public class MaxMex {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);
        int testCount = Integer.parseInt(scan.next());
        for (int i = 1; i <= testCount; i++) {
            int x = solve(scan);
            System.out.println(x);
        }
    }

    public static int solve (Scanner in){
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nInputs = new int[n];

        //Arrays.sort(nInputs);
        for (int i = 0; i < n; i++) {
            nInputs[i] = in.nextInt();
        }

        int s = 0;
        int e = n - 1;

        while (s <= e) {
            int mid = s + (e -s+1) / 2;
            if (nInputs[mid] == m) {
                return -1;
            } else if (nInputs[mid] < m) {
                s = mid + 1;
            } else {
                e = mid-1;
            }
        }

        return (s+1);
    }
}
