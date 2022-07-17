package learn.fastSlow;

public class CircleCheck {

    private static final class LinkItem {
        LinkItem next;
        int val;

        public LinkItem(int val) {
            this.val = val;
        }
    }

    boolean hasCircle(LinkItem head) {
        LinkItem slowPtr, fastPtr;

        slowPtr = fastPtr = head;

        while (slowPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

//            System.out.println("slowPtr: " + slowPtr.val);
//            System.out.println("fastPtr: : " + fastPtr.val + "\n");

            if(slowPtr == fastPtr) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LinkItem l1 = new LinkItem(2);
        LinkItem l2 = new LinkItem(3);
        LinkItem l3 = new LinkItem(1);
        LinkItem l4 = new LinkItem(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        CircleCheck circleCheck = new CircleCheck();
        boolean hasCircle = circleCheck.hasCircle(l1);

        System.out.println("Has Circle: " + hasCircle);
    }

}
