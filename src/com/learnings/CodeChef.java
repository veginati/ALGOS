package com.learnings;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class CodeChef {

        public static void main(String[] args) throws java.lang.Exception {
            Scanner scan = new Scanner(System.in);
            int testCount = Integer.parseInt(scan.next());
            for (int i = 1; i <= testCount; i++) {
                solve(scan);
            }
        }

            public static void solve(Scanner in) {

                int n = in.nextInt();
                int b = in.nextInt();
                int m = in.nextInt();
                int[] mInputs = new int[m];

                for (int i = 0; i < m; i++) {
                    mInputs[i] = in.nextInt();
                }

                int currentBlock = -1;
                int total = 0;

                for (int i = 0; i < m; i++) {

                    if (currentBlock != (mInputs[i]/b)) {
                        total++;
                        currentBlock = mInputs[i]/b;
                    }
                }
                System.out.println(total);
            }
}
