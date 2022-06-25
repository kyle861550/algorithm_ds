package base.single_responsibility;

import java.util.LinkedList;
import java.util.List;

public class MixResponsibility {
    public static void main(String[] args) {
        BookLoader book = new BookLoader();
        book.downLoadBook("5G 世界");
        book.downLoadBook("平行世界");
        book.downLoadBook("奇異點");
        book.downLoadBook("量子力學");
        book.downLoadBook("粒子加速器");

        for(int i = 0; i < book.getDiskSize(); i++) {
            System.out.println(i+1 + ": " + book.readBook(i));
        }
    }

    static class BookLoader {
        private final List<String> list = new LinkedList<>();

        int getDiskSize() {
            return list.size();
        }

        void downLoadBook(String name) {
            System.out.println("booking");
            if(!list.contains(name)) {
                list.add(name);
            }
        }

        String readBook(int tag) {
            System.out.println("reading");
            return list.get(tag);
        }
    }
}
