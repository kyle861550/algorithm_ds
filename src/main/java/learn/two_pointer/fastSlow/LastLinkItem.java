package learn.two_pointer.fastSlow;

public class LastLinkItem {

    private static final class LinkItem {
        LinkItem next;
        int val;

        public LinkItem(int val) {
            this.val = val;
        }
    }

    public LinkItem getLastItemByIndex(LinkItem head, int lastIndex) {
        LinkItem fastPtr, slowPtr;

        fastPtr = slowPtr = head;

        while (lastIndex-- > 0) {
            fastPtr = fastPtr.next;
        }

        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
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

        LastLinkItem lastLinkItem = new LastLinkItem();

        System.out.println("last 2: " + lastLinkItem.getLastItemByIndex(l1, 2).val);
    }
}
