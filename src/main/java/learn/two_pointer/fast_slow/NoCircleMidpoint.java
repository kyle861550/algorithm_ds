package learn.two_pointer.fast_slow;

public class NoCircleMidpoint {

    private static final class LinkItem {
        LinkItem next;
    }

    public LinkItem getMidpoint_normal(LinkItem head) {
        int size = 0;

        LinkItem tmp = head;
        while(tmp != null) {
            tmp = tmp.next;
            size++;
        }

        LinkItem result = head;
        int index = 0;
        while (index < size / 2) {
            index++;
            result = result.next;
        }

        return result;
    }


    public LinkItem getMidpoint_fastSlow(LinkItem head) {
        LinkItem fast, slow;

        fast = slow = head;
        while(slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
