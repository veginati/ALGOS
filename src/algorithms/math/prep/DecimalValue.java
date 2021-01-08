package algorithms.math.prep;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class DecimalValue {

    public static int getDecimalValue(ListNode head) {

        ListNode temp = head;
        int count=-1;
        while(null!=temp){
            ++count;
            temp=temp.next;
        }
        int total=0;
        while(null!=head){
            if(head.val ==1)
                total+=(1 << count);
            --count;
            head =head.next;
        }
        return total;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1,new ListNode(0,new ListNode(1, new ListNode(0))));
        System.out.println(getDecimalValue(head));
    }
}
