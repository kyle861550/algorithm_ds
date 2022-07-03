package impl.hard;

import java.util.ArrayList;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays f = new FindMedianSortedArrays();

//        int[] t1 = {1, 2};
//        int[] t2 = {3, 4};

//        int[] t1 = {1, 3};
//        int[] t2 = {2};

//        int[] t1 = {1, 3, 5, 7, 9};
//        int[] t2 = {0, 2, 7, 11};

//        int[] t1 = {0, 0};
//        int[] t2 = {0, 0};

        int[] t1 = {};
        int[] t2 = {1};

        System.out.println("FindMedianSortedArrays: " + f.findMedianSortedArrays(t1, t2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result;
        int num1Len = nums1.length, num2Len = nums2.length;

        ArrayList<Integer> arrayList = new ArrayList<>(num1Len + num2Len);

        // add nums1 to arrayList
        for(int i : nums1) {
            arrayList.add(i);
        }

        while (num2Len > 0) {
            int curNum = nums2[num2Len - 1];

            if(arrayList.isEmpty()) {
                arrayList.add(curNum);
            } else {
                if(curNum <= arrayList.get(0)) {
                    arrayList.add(0, curNum);

                } else if (curNum >= arrayList.get(arrayList.size() - 1)) {
                    arrayList.add(curNum);

                } else {
                    int start = 0, end = arrayList.size() - 1;

                    while (true) {
                        int tmpIndex = (start + end) / 2;
                        int num1MedianValue = arrayList.get(tmpIndex);

                        if(curNum > num1MedianValue) {
                            start = tmpIndex;
                        } else {
                            end = tmpIndex;
                        }

                        if(end - start == 1) {
                            arrayList.add(end, curNum);
                            break;
                        }
                    }
                }
            }

            num2Len--;
        }

        int totalSize = arrayList.size();
        if(totalSize % 2 != 0) {
            result = arrayList.get(totalSize / 2);
        } else {
            result = (arrayList.get(totalSize / 2) + arrayList.get(totalSize / 2 - 1)) / 2f;
        }

        System.out.println("FindMedianSortedArrays: " + arrayList);

        return result;
    }

}
