package algorithms.strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator {

    public static int calculate(String s) {

        Deque<String> stack =   new ArrayDeque<>();
        StringBuffer buffer = new StringBuffer("");

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);

            if(' '== ch){
                continue;
            }

            if('(' == ch || '+' == ch || '-'==ch){

                if(buffer.length()>0){
                    stack.offerFirst(buffer.toString());
                    buffer.setLength(0);
                }

                if('-'== ch)
                    buffer.append(ch);
                if('(' ==ch)
                    stack.offerFirst("(");
            }else if (')' == ch){
                // stack pop
                Long total= buffer.length()>0 ? new Long(buffer.toString()):0;
                buffer.setLength(0);
                while(!stack.isEmpty() && !"(".equals(stack.peekFirst())){
                    total += new Long(stack.pollFirst());
                }
                stack.pollFirst();

                if(!stack.isEmpty() && "-".equals(stack.peekFirst())){
                    stack.pollFirst();
                    total= -total;
                }

                if(total!=0)
                    stack.push(total.toString());
            }else{
                buffer.append(ch);
            }
        }

        Long total = (buffer.length()>0)?new Long(buffer.toString()):0L;

        while(!stack.isEmpty()){
            total+= new Long(stack.pollFirst());
        }

        return total.intValue();
    }

    public static void main(String[] args) {
       System.out.println(calculate("15+25-35-(15+30)"));
    }

}