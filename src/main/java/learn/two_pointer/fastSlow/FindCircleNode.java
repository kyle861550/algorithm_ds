package learn.two_pointer.fastSlow;

public class FindCircleNode {

    private static final class LinkItem {
        LinkItem next;
        int val;

        public LinkItem(int val) {
            this.val = val;
        }
    }

    LinkItem findCircleNode(LinkItem head) {
        LinkItem slowPtr, fastPtr;

        slowPtr = fastPtr = head;

        boolean hasCircle = false;

        while (slowPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr) {
                hasCircle = true;
                break;
            }
        }

        if(!hasCircle) {
            return null;
        }

        slowPtr = head;
        while (slowPtr != fastPtr) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        return slowPtr;
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

        FindCircleNode findCircleNode = new FindCircleNode();

        System.out.println("Has Circle: " + findCircleNode.findCircleNode(l1).val);
    }
}
