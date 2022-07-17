package learn.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class OpenLock {

    private String plusOne(String num, int index) {
        char[] numArray = num.toCharArray();
        char one = numArray[index];

        if(one == '9') {
            numArray[index] = 0;
        } else {
            numArray[index] = (char) (one + 1);
        }

        return new String(numArray);
    }

    private String reduceOne(String num, int index) {
        char[] numArray = num.toCharArray();
        char one = numArray[index];

        if(one == '0') {
            numArray[index] = 9;
        } else {
            numArray[index] = (char) (one - 1);
        }

        return new String(numArray);

    }

    public int openLock(String target) {
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int count = 0;

        queue.push("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String curNum = queue.poll();

                assert curNum != null;
                if(curNum.equals(target)) {
                    return count;
                }

                for(int k = 0; k < 4; k++) {
                    String plusNum = plusOne(curNum, k);
                    if(!visited.contains(plusNum)) {
                        queue.push(plusNum);
                        visited.add(plusNum);
                    }

                    String reduceNum = reduceOne(curNum, k);
                    if(!visited.contains(reduceNum)) {
                        queue.push(reduceNum);
                        visited.add(reduceNum);
                    }
                }
            }

            count++;
        }

        return -1;
    }

    public int openLock_with_dead(String target, String[] deadNum) {
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        Set<String> deadNumList = new HashSet<>(Arrays.asList(deadNum));

        int count = 0;

        queue.push("0000");
        visited.add("0000");


        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String curNum = queue.poll();

                assert curNum != null;

                if(deadNumList.contains(curNum)) {
                    continue;
                }

                if(curNum.equals(target)) {
                    return count;
                }

                for(int k = 0; k < 4; k++) {
                    String plusNum = plusOne(curNum, k);
                    if(!visited.contains(plusNum)) {
                        queue.push(plusNum);
                        visited.add(plusNum);
                    }

                    String reduceNum = reduceOne(curNum, k);
                    if(!visited.contains(reduceNum)) {
                        queue.push(reduceNum);
                        visited.add(reduceNum);
                    }
                }
            }

            count++;
        }

        return -1;
    }

    public int openLock_with_dead_opt(String target, String[] deadNum) {
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadNum));

        int count = 0;

        queue.push("0000");
        visited.add("0000");


        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String curNum = queue.poll();

                assert curNum != null;

                if(curNum.equals(target)) {
                    return count;
                }

                for(int k = 0; k < 4; k++) {
                    String plusNum = plusOne(curNum, k);
                    if(!visited.contains(plusNum)) {
                        queue.push(plusNum);
                        visited.add(plusNum);
                    }

                    String reduceNum = reduceOne(curNum, k);
                    if(!visited.contains(reduceNum)) {
                        queue.push(reduceNum);
                        visited.add(reduceNum);
                    }
                }
            }

            count++;
        }

        return -1;
    }
}
