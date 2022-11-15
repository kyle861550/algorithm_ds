package impl.medium;

public class RemoveNthFromEnd {

    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd_2(ListNode head, int n) {

        ListNode slow = head;
        while (n > 0) {
            slow = slow.next;
            n--;
        }

        if(slow == null) {
            return new ListNode();
        }

        ListNode right = slow.next;

        if(right != null) {
            slow.next = right.next;
        }

        return head;
    }

    public ListNode removeNthFromEnd_3(ListNode head, int n) {

        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = slow.next;
        while (n > 0 && fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            n--;
        }

        if(n != 0) {
            return null;
        }

        if(fast == null) {
            pre.next = null;
            return head;
        } else {
            slow.next = fast.next;
        }

        return head;
    }

    public ListNode removeNthFromEnd_4(ListNode head, int n) {
        ListNode target = head;

        while (n > 0) {
            target = target.next;
            if (target == null) {
                target = head;
            }
            n--;
        }

        ListNode pre = head;
        ListNode tmp = head;
        while (tmp != null) {
            if(tmp.val == target.val) {
                if(pre == tmp && tmp.next == null) {
                    return null;
                } else if (pre == tmp) {
                    return tmp.next;
                } else if(tmp.next != null) {
                    tmp.next = tmp.next.next;
                } else {
                    pre.next = null;
                }
                break;
            }

            pre = tmp;
            tmp = tmp.next;
        }

        return head;
    }

    public static void main(String[] args) {
//        RemoveNthFromEnd end = new RemoveNthFromEnd();
//
//        ListNode listNode = end.removeNthFromEnd_4(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
//        test(listNode);
//
//        listNode = end.removeNthFromEnd_4(new ListNode(1), 1);
//        test(listNode);
//
//        listNode = end.removeNthFromEnd_4(new ListNode(1, new ListNode(2)), 1);
//        test(listNode);
//
//        listNode = end.removeNthFromEnd_4(new ListNode(1, new ListNode(2)), 2);
//        test(listNode);

        Solution solution = new Solution();
        test(solution.removeNthFromEnd_ans2(new ListNode(1), 1));
    }

    private static void test(ListNode listNode) {
        if(listNode == null) {
            System.out.println();
            return;
        }

        System.out.print(listNode.val + ", ");
        test(listNode.next);
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode newHead = new ListNode(0);
            newHead.next = head;
            ListNode p = newHead;
            ListNode runner = newHead;
            while(n>0){
                runner = runner.next;
                n--;
            }
            while(runner.next!=null){
                runner = runner.next;
                p=p.next;
            }
            p.next = p.next.next;
            return newHead.next;
        }


        public ListNode removeNthFromEnd_ans2(ListNode head, int n) {
            ListNode start = new ListNode(0);
            ListNode slow = start, fast = start;
            slow.next = head;

            //Move fast in front so that the gap between slow and fast becomes n
            for(int i=1; i<=n+1; i++)   {
                fast = fast.next;
            }
            //Move fast to the end, maintaining the gap
            while(fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            //Skip the desired node
            slow.next = slow.next.next;
            return start.next;
        }
    }
}
