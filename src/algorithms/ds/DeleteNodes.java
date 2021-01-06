package algorithms.ds;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class DeleteNodes {

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode tempHeader = null;
        ListNode prev = null;
        ListNode pointer = null;

        if(null == head || head.next == null){
            return head;
        }

        while(head!= null){
            boolean duplicateFound =false;

            while(null!=prev && null!=head && prev.val == head.val){
                duplicateFound =true;
                head =head.next;
            }

            if(duplicateFound){
                prev = null;
            }

            if(null!=prev && prev.val!=head.val){

                if(null==pointer){
                    tempHeader =prev;
                    pointer =prev;
                }else{
                    pointer.next =prev;
                    pointer = pointer.next;
                }
            }
            prev =head;
            if(null!=head)
                head = head.next;
        }

        if(null!=pointer){
            pointer.next =prev;
        }else if(null ==pointer){
            return prev;
        }

        return tempHeader;
    }

    public static void main(String[] args) {

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(4);

        first.next=second;
        second.next=third;
        third.next=fourth;

        ListNode result = deleteDuplicates(first);

        while(null!=result){
            System.out.print(result.val+" ");
            result=result.next;
        }

    }
}
