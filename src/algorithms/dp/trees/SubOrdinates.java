package algorithms.dp.trees;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * https://cses.fi/problemset/task/1674/
 */
public class SubOrdinates {

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
            }  while ((c = read()) >= '0' && c <= '9');

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

    public static void main(String[] args) throws IOException {

        //Enter data using BufferReader
            Reader reader=new Reader();
            int n = reader.nextInt();
            int[] output = new int[n+1];

            List[] neighbours = new ArrayList[n+1];
            for(int i=2;i<=n ;i++){
                int parent = reader.nextInt();
                if(null!= neighbours[parent])
                    neighbours[parent].add(i);
                else{
                    int value =i;
                    neighbours[parent] = new ArrayList<Integer>(){{add(value);}};
                }
            }
            reader.close();
            getSubOrdinates(1,output,neighbours);
            for(int i=1;i<output.length;i++){
                System.out.print(output[i]);
                System.out.print(" ");
            }
    }


    public static void getSubOrdinates( int index, int[] output, List[] neighbours ){
        List<Integer> subOrdinates = neighbours[index];
        int total =0;
        if(null==subOrdinates){
            output[index] =total;
            return;
        }
        if(output[0]>0)
            return;
        for(int i=0;i<subOrdinates.size();i++){
            getSubOrdinates(subOrdinates.get(i), output, neighbours);
            total+= 1+ output[subOrdinates.get(i)];
        }
        output[index] =total;
    }
}
