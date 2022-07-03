package impl.medium;

public class AddTwoNumber {

    public static void main(String[] args) {
        AddTwoNumber t = new AddTwoNumber();

        ListNode t1 = new ListNode(2, new ListNode(4, new ListNode(3)));

        ListNode t2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode tt = t.addTwoNumbers(t1, t2);

//        System.out.println(Arrays.toString(tt));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int getLength(ListNode l) {
        int length = 0;
        while (l != null) {
            length++;
            l = l.next;
        }
        return length;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int l1Len = getLength(l1);
        int l2Len = getLength(l2);

        ListNode mv = l1Len > l2Len ? l1 : l2;
        ListNode result = mv;

        while (mv != null) {
            int tmp = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);

            int tmp2 = tmp / 10;

            if(tmp2 != 0) {

                if(mv.next == null) {
                    mv.next = new ListNode(tmp2);
                } else {
                    mv.next.val += tmp2;
                }
            }

            mv.val = tmp % 10;

            if(l2 != null) {
                l2 = l2.next;
            }
            if(l1 != null) {
                l1 = l1.next;
            }
            mv = mv.next;
        }

        return result;
    }

}
