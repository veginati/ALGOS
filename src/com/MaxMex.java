package com;

import java.util.*;
import java.io.*;

public class MaxMex {
        //SOLUTION BEGIN
        void pre() throws Exception{}
        void solve(int TC) throws Exception{
            int N = ni(), M = ni();
            int mex = 1;
            TreeSet<Integer> set = new TreeSet<>();
            int cnt = 0;
            for(int i = 0; i< N; i++){
                int x = ni();
                if(x == M)continue;
                cnt++;
                set.add(x);
                while(set.contains(mex))mex++;
            }
            if(mex == M)pn(cnt);
            else pn(-1);
        }
        //SOLUTION END
        void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
        static boolean multipleTC = true;
        FastReader in;PrintWriter out;
        void run() throws Exception{
            in = new FastReader();
            out = new PrintWriter(System.out);
            //Solution Credits: Taranpreet Singh
            int T = (multipleTC)?ni():1;
            pre();for(int t = 1; t<= T; t++)solve(t);
            out.flush();
            out.close();
        }
        public static void main(String[] args) throws Exception{
            new MaxMex().run();
        }
        int bit(long n){return (n==0)?0:(1+bit(n&(n-1)));}
        void p(Object o){out.print(o);}
        void pn(Object o){out.println(o);}
        void pni(Object o){out.println(o);out.flush();}
        String n()throws Exception{return in.next();}
        String nln()throws Exception{return in.nextLine();}
        int ni()throws Exception{return Integer.parseInt(in.next());}
        long nl()throws Exception{return Long.parseLong(in.next());}
        double nd()throws Exception{return Double.parseDouble(in.next());}

        class FastReader{
            BufferedReader br;
            StringTokenizer st;
            public FastReader(){
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            public FastReader(String s) throws Exception{
                br = new BufferedReader(new FileReader(s));
            }

            String next() throws Exception{
                while (st == null || !st.hasMoreElements()){
                    try{
                        st = new StringTokenizer(br.readLine());
                    }catch (IOException  e){
                        throw new Exception(e.toString());
                    }
                }
                return st.nextToken();
            }

            String nextLine() throws Exception{
                String str = "";
                try{
                    str = br.readLine();
                }catch (IOException e){
                    throw new Exception(e.toString());
                }
                return str;
            }
        }
    }