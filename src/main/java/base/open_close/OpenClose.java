package base.open_close;

import java.util.LinkedList;
import java.util.List;

public class OpenClose {
    public static void main(String[] args) {
        LoaderControl c = new LoaderControl();

        c.setLoader(new BookLoader());
        c.downLoad("5G 世界");
        c.downLoad("平行世界");
        c.downLoad("奇異點");
        c.downLoad("量子力學");
        c.downLoad("粒子加速器");
        for(int i = 0; i < c.getSize(); i++) {
            System.out.println(i+1 + ": " + c.read(i));
        }


        c.setLoader(new MovieLoader());
        c.downLoad("大亨小傳");
        c.downLoad("雞不可失");
        c.downLoad("葉問4");
        c.downLoad("白頭山");
        for(int i = 0; i < c.getSize(); i++) {
            System.out.println(i+1 + ": " + c.read(i));
        }


        c.setLoader(new MusicLoader());
        c.downLoad("The Greatest Showman");
        c.downLoad("頑童");
        c.downLoad("Marz23");
        c.downLoad("BIGBANG");
        c.downLoad("周杰倫");
        for(int i = 0; i < c.getSize(); i++) {
            System.out.println(i+1 + ": " + c.read(i));
        }
    }

    static abstract class BaseLoader {
        LibraryCache l = new LibraryCache();

        abstract int getDiskSize();
        abstract void downLoad(String item);
        abstract String read(int index);
    }


    static class LoaderControl {
        BaseLoader loader;

        public void setLoader(BaseLoader loader) {
            this.loader = loader;
        }

        int getSize() {
            return loader.getDiskSize();
        }

        void downLoad(String str) {
            loader.downLoad(str);
        }

        String read(int i) {
            return loader.read(i);
        }
    }

    static class BookLoader extends BaseLoader {
        LibraryCache l = new LibraryCache();
        @Override
        int getDiskSize() {
            return l.LibSize();
        }

        @Override
        void downLoad(String name) {
            System.out.println("booking");
            l.setBook(name);
        }

        @Override
        String read(int tag) {
            System.out.println("reading");
            return l.getBookByTag(tag);
        }
    }

    static class MovieLoader extends BaseLoader {

        @Override
        int getDiskSize() {
            return l.LibSize();
        }

        @Override
        void downLoad(String name) {
            System.out.println("booking");
            l.setBook(name);
        }

        @Override
        String read(int tag) {
            System.out.println("reading");
            return l.getBookByTag(tag);
        }
    }

    static class MusicLoader extends BaseLoader{

        @Override
        int getDiskSize() {
            return l.LibSize();
        }

        @Override
        void downLoad(String name) {
            System.out.println("booking");
            l.setBook(name);
        }

        @Override
        String read(int tag) {
            System.out.println("reading");
            return l.getBookByTag(tag);
        }
    }


    static class LibraryCache {
        private final List<String> list = new LinkedList<>();

        void setBook(String book) {
            if(!list.contains(book)) {
                list.add(book);
            }
        }

        String getBookByTag(int tag) {
            return list.get(tag);
        }

        int LibSize() {
            return list.size();
        }
    }
}
