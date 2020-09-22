package com.learnings;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author rishus23
 */
public class SubTreeSumEqualtoK {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        CountingOnTree solver = new CountingOnTree();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class CountingOnTree {
        static int[] a;
        static int[] s;
        static int K;
        static long[][] dp;
        static boolean[] vis;
        static int mod = 1000000007;
        static ArrayList<Integer>[] adj;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            K = in.nextInt();
            a = new int[n];
            s = new int[n];
            dp = new long[n][105];
            adj = new ArrayList[n];
            vis = new boolean[n];
            for (int i = 0; i < n; i++)
                adj[i] = new ArrayList<Integer>();
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();
            for (int i = 0; i < n - 1; i++) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                adj[a].add(b);
                adj[b].add(a);
            }
            //dfs1(0,-1);
            //dfs(0,-1);
            dfs(0);
            long ans = 0L;
            for (int i = 0; i < n; i++)
                ans = (ans + dp[i][K]) % mod;
//        if(K==0)
//            ans -= n;
            out.println(ans);
        }

        void dfs(int v) {
            for (int i = 0; i <= K; i++)
                dp[v][i] = 0;
            vis[v] = true;
            dp[v][a[v]] = 1;
            s[v] = a[v];
            for (int i : adj[v]) {
                if (vis[i])
                    continue;
                dfs(i);
                long[] b = new long[K + 1];
                for (int j = 0; j <= K; j++)
                    b[j] = dp[v][j];
                for (int j = 0; j <= K && j <= s[v]; j++)
                    for (int k = 0; k <= K && k <= s[i]; k++) {
                        if (j + k <= K)
                            b[j + k] = (b[j + k] + (dp[v][j] * dp[i][k]) % mod) % mod;
                    }
                for (int j = 0; j <= K; j++)
                    dp[v][j] = b[j];
                s[v] += s[i];
            }
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public void println(long i) {
            writer.println(i);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return nextString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}