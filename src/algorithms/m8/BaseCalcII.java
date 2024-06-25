package algorithms.m8;

import java.util.ArrayDeque;
import java.util.Deque;

public class BaseCalcII {
    
    public int calculate(String s) {
        if(s.length()==0){
            return 0;
        }
        Deque<Integer> stackNums = new ArrayDeque<>();
        Deque<Character> stackChrs = new ArrayDeque<>();
        String temp = s+"+0+";
        StringBuffer tmpBuf = new StringBuffer();

        for(int i=0;i<temp.length();i++){
            Character ch = temp.charAt(i);
            if(ch == ' '){
                continue;
            }
            if(ch=='+' || ch=='-' || ch =='*' || ch=='/'){
                Integer currValue = Integer.valueOf(tmpBuf.toString().trim());
                if(!stackChrs.isEmpty()){
                    Character prevOpr = stackChrs.peekLast();
                    if(prevOpr == '*' || prevOpr == '/'){
                        stackChrs.pollLast();
                        Integer prevValue = stackNums.pollLast();
                        if(prevOpr == '*'){
                            currValue*=prevValue;
                        }else{
                            currValue = prevValue/currValue;
                        }
                    }
                }
                stackNums.offerLast(currValue);
                stackChrs.offerLast(ch);
                tmpBuf.setLength(0);
            }else{
                tmpBuf.append(ch);
            }
        }

        Integer output = stackNums.pollFirst();

        while(!stackChrs.isEmpty()&&!stackNums.isEmpty()){
            Character x1 = stackChrs.pollFirst();
            Integer i2 = stackNums.pollFirst();
            if(x1 == '+'){
                output+=i2;
            }else{
                output-=i2;
            }
        }
    return output;
    }
}