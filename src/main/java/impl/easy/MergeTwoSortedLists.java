package impl.easy;

public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tmp = new ListNode();
        ListNode res = tmp;

        ListNode left = list1;
        ListNode right = list2;
        while (left != null || right != null) {

            if(left == null) {
                tmp.next = right;
                tmp = tmp.next;
                right = right.next;
            } else if (right == null) {
                tmp.next = left;
                tmp = tmp.next;
                left = left.next;
            } else if (left.val < right.val) {
                tmp.next = left;
                tmp = tmp.next;
                left = left.next;
            } else if (left.val >= right.val) {
                tmp.next = right;
                tmp = tmp.next;
                right = right.next;
            }
        }

        return res.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
    private void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
        System.out.println("\n-------------------");
    }

    public static void main(String[] args) {
        MergeTwoSortedLists lists = new MergeTwoSortedLists();

        ListNode t1 = new ListNode();
        ListNode t2 = new ListNode();

        lists.print(lists.mergeTwoLists(t1, t2));

        ListNode t3 = new ListNode();
        ListNode t4 = new ListNode(0);

        lists.print(lists.mergeTwoLists(t3, t4));

        ListNode t5 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode t6 = new ListNode(1, new ListNode(3, new ListNode(4)));

        lists.print(lists.mergeTwoLists(t5, t6));

        ListNode t7 = new ListNode(-9, new ListNode(3));
        ListNode t8 = new ListNode(5, new ListNode(7));

        lists.print(lists.mergeTwoLists2(t7, t8));
    }
}
