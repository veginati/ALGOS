
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
public class DoubleNumber {
    public ListNode doubleIt(ListNode head) {
        
        StringBuffer numberInput = new StringBuffer();
        StringBuffer calculatedNum = new StringBuffer();
        ListNode temp = head;
        ListNode output = null;
        ListNode tempTraversal = null;

        while(temp!=null){
            numberInput.append(temp.val);
            temp=temp.next;
        }

        numberInput = numberInput.reverse();
        //System.out.println(numberInput);
        int carry_forward=0;
        for(int i=0;i<numberInput.length();i++){
            int value = Character.getNumericValue(numberInput.charAt(i))*2;
            //System.out.println(numberInput);
            value+=carry_forward;
            calculatedNum.append(value%10);
            carry_forward=value/10;
        }

        if(carry_forward>0){
            calculatedNum.append(carry_forward);
        }

        calculatedNum = calculatedNum.reverse(); 
        //System.out.println(calculatedNum);
        for(int i=0;i<calculatedNum.length();i++){
            if(i==0){
                output = new ListNode(Character.getNumericValue(calculatedNum.charAt(i)));
                tempTraversal =output;
            }else{
                tempTraversal.next = new ListNode(Character.getNumericValue(calculatedNum.charAt(i)));
                tempTraversal =tempTraversal.next;
            }
        }
        return output;
    }
}
