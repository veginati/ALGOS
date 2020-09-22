package com.codechef.suggested.approach;

import java.util.*;
        import java.io.*;
        import java.text.*;
public class PerCapita
{
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    public static void dfs(ArrayList<Integer> adl[], int i, double max, ArrayList<Integer> temp, boolean marked[], double income[])
    {
        marked[i]=true;
        int count=0;
        for(int x:adl[i])
        {
            if(marked[x])
                continue;
            else
            {
                if(income[x]==max)
                {
                    temp.add(x);
                    marked[x]=true;
                    dfs(adl,x,max,temp,marked,income);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Reader sc=new Reader();
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));

        int t=sc.nextInt();
        int hh=0;

        while(hh++<t)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a[]=new int[n+1];
            int b[]=new int[n+1];
            int i;
            for(i=1; i<=n; i++)
                a[i]=sc.nextInt();
            for(i=1; i<=n; i++)
                b[i]=sc.nextInt();
            double income[]=new double[n+1];
            for(i=1; i<=n; i++)
            {
                income[i]=(double)a[i]/b[i];
            }
            double max=-1;
            int ind=-1;

            for(i=1; i<=n; i++)
            {
                if(income[i]>max)
                {
                    max=income[i];
                    ind=i;
                }
            }
            ArrayList<Integer> adl[]=new ArrayList[n+1];
            for(i=0; i<m; i++)
            {
                int u=sc.nextInt();
                int v=sc.nextInt();
                if(adl[u]==null)
                    adl[u]=new ArrayList<>();
                if(adl[v]==null)
                    adl[v]=new ArrayList<>();
                adl[u].add(v);
                adl[v].add(u);
            }
            int max_count=0;

            int gg=ind;
            ArrayList<Integer> res=new ArrayList<>();
            boolean marked[]=new boolean[n+1];
            for(i=1; i<=n; i++)
            {
                if(marked[i])
                    continue;
                if(income[i]==max)
                {
                    int count=1;
                    ArrayList<Integer> temp=new ArrayList<>();
                    dfs(adl, i, max, temp, marked, income);
                    count+=temp.size();
                    if(count>max_count)
                    {
                        max_count=count;
                        res=temp;
                        gg=i;
                    }
                }
            }
            out.println(max_count);
            out.print(gg+" ");
            for(int x:res)
            {
                out.println(x+" ");
            }
            out.println();
        }
        out.flush();
    }
}