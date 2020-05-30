package CustomQueue;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomQueue {

    private int[] arr = new int[11];
    private int size = 0;

    public int size() {
        return size;
    }

    public void add(int data) {
        if (arr.length == size) {
            int newSize = (int) (arr.length * 1.5 + 1);
            arr = Arrays.copyOf(arr, newSize);
        }
        arr[size] = data;
        size++;
    }

    public int poll() {
        if (isEmpty()) {
            return 0;
        }
        int data = arr[0];
        System.arraycopy(arr, 1, arr, 0, size - 1);
        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            return 0;
        }
        return arr[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
