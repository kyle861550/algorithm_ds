package learn;

public class Control_Array {

    public static void main(String[] args) {
    }

    public void forTraverse(int[] array) {
        for(int item : array) {
            System.out.println("Item: " + item);
        }
    }

    public void whileTraverse(int[] array) {
        int index = 0;
        // close
        while (index++ < array.length) {
            System.out.println("Item: " + array[index]);
        }
    }
}
