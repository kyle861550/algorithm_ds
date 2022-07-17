package learn.fastSlow;

public class Problem {

    private static final class LinkItem {
        LinkItem next;
    }

    public boolean hasCircle(LinkItem item) {
        LinkItem tmp = item;
        while (tmp != null) {
            tmp = tmp.next;
        }
        return false;
    }

}
