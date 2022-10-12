package standard.recursion;

public class FindMax {

    public int findMax(int[] mixArray) {
        return _findMax(mixArray, 0, mixArray.length - 1);
    }

    public int times;
    private int _findMax(int[] mixArray, int start, int end) {
        System.out.println("Start: " + start + ", end: " + end);
        if(start == end) {
            times++;
            return mixArray[start];
        }

        int mid = (start + end) / 2;

        int left = _findMax(mixArray, start, mid);
        int right = _findMax(mixArray, mid + 1, end);

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        FindMax findMax = new FindMax();

        int result = findMax.findMax(new int[] {
                1, 3, 5, 2, 1, 9, 7,
        });

        System.out.println("Max Result: " + result);
        System.out.println("Times: " + findMax.times);
    }

}
