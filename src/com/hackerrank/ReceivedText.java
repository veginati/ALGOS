package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReceivedText {

    static class Node{
        char data;
        Node next;
        Node prev;

        Node(char data){
            this.data =data;
        }
    }

    public static void main(String[] args) {
        System.out.println(receivedText("caser<<<<<<<***ABC***<<<<<<<"));
    }

    public static String receivedText(String S) {
            boolean numberEnabled = true;
            char[] data = S.toCharArray();
            Node node = null;
            Node last = null;
            Node first = null;
            Node actualFirst = null;
            Node actualLast = null;
            boolean left =true;

            for(int i=0;i<=data.length;i++){
                char character = (i == data.length)?'<':data[i];
                if(character=='<' || character=='>'){
                    if(left){
                        if(null!=node){
                            node.next =actualFirst;
                            if(null!=actualFirst)
                                actualFirst.prev = node;
                            actualFirst = first;
                            node = null;
                        }

                        if(null == actualLast){
                            actualLast =last;
                            last = null;
                        }
                    }else {
                        if ( null != node) {
                            actualLast.next=first;
                            first.prev =actualLast;
                            actualLast =last;
                            node = null;
                        }
                    }

                    if(null!=actualLast){
                        if(character == '<'){
                            left =true;
                        }else{
                            left =false;
                        }
                    }
                }else if(character == '*'){
                    if(null!=node){
                        node= node.prev;
                        last = node;
                        if(null!=node)
                        node.next = null;
                    }else if(!left&& null!=actualLast){
                        actualLast= actualLast.prev;
                        if(null!=actualLast)
                            actualLast.next = null;
                        else
                            actualFirst = null;
                    }
                }else if(character =='#'){
                    numberEnabled = !numberEnabled;
                }else {
                    boolean isDigit = character-'A'<0;
                    if ((isDigit && numberEnabled) || !isDigit) {

                        if(null == node){
                            node = new Node(character);
                            last = node;
                            first = node;
                        }else{
                            node.next = new Node(character);
                            node.next.prev = node;
                            node = node.next;
                            last = node;
                        }
                    }
                }
            }
            StringBuffer outputData = new StringBuffer(S.length());
            while(null!=actualFirst){
                outputData.append(actualFirst.data);
                actualFirst = actualFirst.next;
            }
            return outputData.toString();
        }

}