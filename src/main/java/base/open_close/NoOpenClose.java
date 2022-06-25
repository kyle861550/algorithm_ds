package base.open_close;

import java.util.LinkedList;
import java.util.List;

public class NoOpenClose {
    public static void main(String[] args) {
        LoaderControl c = new LoaderControl();

        c.bookDownLoad("5G 世界");
        c.bookDownLoad("平行世界");
        c.bookDownLoad("奇異點");
        c.bookDownLoad("量子力學");
        c.bookDownLoad("粒子加速器");
        for(int i = 0; i < c.getBookSize(); i++) {
            System.out.println(i+1 + ": " + c.bookRead(i));
        }

        c.movieDownLoad("大亨小傳");
        c.movieDownLoad("雞不可失");
        c.movieDownLoad("葉問4");
        c.movieDownLoad("白頭山");
        for(int i = 0; i < c.getMovieDiskSize(); i++) {
            System.out.println(i+1 + ": " + c.movieRead(i));
        }

        c.musicDownLoad("The Greatest Showman");
        c.musicDownLoad("頑童");
        c.musicDownLoad("Marz23");
        c.musicDownLoad("BIGBANG");
        c.musicDownLoad("周杰倫");
        for(int i = 0; i < c.getMusicDiskSize(); i++) {
            System.out.println(i+1 + ": " + c.musicRead(i));
        }
    }


    static class LoaderControl {
        BookLoader book = new BookLoader();
        MovieLoader movie = new MovieLoader();
        MusicLoader music = new MusicLoader();

        int getBookSize() {
            return book.getDiskSize();
        }

        void bookDownLoad(String str) {
            book.downLoad(str);
        }

        String bookRead(int i) {
            return book.read(i);
        }

        int getMovieDiskSize() {
            return movie.getDiskSize();
        }

        void movieDownLoad(String str) {
            movie.downLoad(str);
        }

        String movieRead(int i) {
            return movie.read(i);
        }

        int getMusicDiskSize() {
            return music.getDiskSize();
        }

        void musicDownLoad(String str) {
            music.downLoad(str);
        }

        String musicRead(int i) {
            return music.read(i);
        }
    }

    static class BookLoader {
        LibraryCache l = new LibraryCache();

        int getDiskSize() {
            return l.LibSize();
        }

        void downLoad(String name) {
            System.out.println("booking");
            l.setBook(name);
        }

        String read(int tag) {
            System.out.println("reading");
            return l.getBookByTag(tag);
        }
    }

    static class MovieLoader {
        LibraryCache l = new LibraryCache();

        int getDiskSize() {
            return l.LibSize();
        }

        void downLoad(String name) {
            System.out.println("booking");
            l.setBook(name);
        }

        String read(int tag) {
            System.out.println("reading");
            return l.getBookByTag(tag);
        }
    }

    static class MusicLoader {
        LibraryCache l = new LibraryCache();

        int getDiskSize() {
            return l.LibSize();
        }

        void downLoad(String name) {
            System.out.println("booking");
            l.setBook(name);
        }

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
