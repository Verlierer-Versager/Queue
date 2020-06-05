package CustomQueue;

import java.util.Arrays;

public class CustomQueue {

    private int[] arr = new int[11];
    private int size = 0;
    private int indexFirst = 0; //first element index
    private int indexLast = 0;  //last element index

    public int size() {
        return size;
    }

    public void add(int data) {
        if (arr.length == indexLast) {
            if (!removeNonexistentElements(0)) {
                int newSize = (int) (arr.length * 1.5 + 1);
                arr = Arrays.copyOf(arr, newSize);
            }
        }
        arr[indexLast] = data;
        size++;
        indexLast++;
    }

    public Integer poll() {
        if (isEmpty()) {
            return null;
        }
        int data = arr[indexFirst];
        if(!removeNonexistentElements((int) (0.2*arr.length))) {
            indexFirst++;
            size--;
        }
        return data;
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return arr[indexFirst];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean removeNonexistentElements(int limit) {
        if (indexFirst > limit) {
            System.arraycopy(arr, indexFirst, arr, 0, size);
            indexLast -= indexFirst;
            indexFirst = 0;
            return true;
        }
        return false;
    }

    public int getIndexFirst() {
        return indexFirst;
    }
}
