package base.liskov;

public class Liskov {

    static class Window {
        public void show(View child) {
            child.onDraw();
        }

    }

    static abstract class View {
        public abstract void onMeasure();
        public abstract void onDraw();
        public abstract void onLayout();
    }

    static class TextView extends View {
        @Override
        public void onMeasure() {
        }

        public void onDraw() {
            System.out.println("TextView");
        }

        @Override
        public void onLayout() {
        }
    }

    static class ImageView extends View {
        @Override
        public void onMeasure() {
        }

        public void onDraw() {
            System.out.println("ImageView");
        }

        @Override
        public void onLayout() {
        }
    }
}
