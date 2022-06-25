package base.dependence_inversion;

import java.util.LinkedList;
import java.util.List;

public class DependenceInversion {

    static class BookLoader {
        private final ICache l = new LibraryCache();

        int getDiskSize() {
            return l.libSize();
        }

        void downLoadBook(String name) {
            System.out.println("booking");
            l.setBook(name);
        }

        String readBook(int tag) {
            System.out.println("reading");
            return l.getBookByTag(tag);
        }
    }

    interface ICache {
        void setBook(String name);
        String getBookByTag(int tag);
        int libSize();
    }

    static class LibraryCache implements ICache {
        private final List<String> list = new LinkedList<>();

        @Override
        public void setBook(String book) {
            if(!list.contains(book)) {
                list.add(book);
            }
        }

        @Override
        public String getBookByTag(int tag) {
            return list.get(tag);
        }

        @Override
        public int libSize() {
            return list.size();
        }
    }

}
