class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }

}

class LinkedListProblems{
    //https://leetcode.com/problems/add-two-numbers/description/ 
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int i,j,num1,num2, sum;
        i = j = num1 = num2 = 0;
        ListNode p,q, result;
        p = l1;
        while(p!=null){
            num1 += Math.pow(10, i) * p.val;
            p = p.next;
            i++;
        }
        p = l2;
        while(p!=null){
            num2 += Math.pow(10, j) * p.val;
            p = p.next;
            j++;
        }
        sum = num1 + num2;
        if(sum == 0) return new ListNode(0);
        result = p = q = null;
        int remainder = 0;
        i = 1;
        while(sum != 0){
            remainder = (int)(sum % 10);
            p = new ListNode(remainder);
            if(i == 1) 
                result = p;
            if(q != null) 
                q.next = p;
            q = p;
            sum = (int)(sum / 10);
            i++;
        }
        return result;
    }

    public static void displayNodes(ListNode head){
        ListNode p = head;
        while(p != null){
            System.out.print(p.val + "->");
        }
        System.out.print("\n");
    }

}