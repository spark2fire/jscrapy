package cn.spark2fire.jscrapy.util;

public class PriorityQueue<T extends Comparable> {
    private T[] array;
    private int size = 10;
    private int lastIdx;

    public PriorityQueue() {
        array = (T[]) new Comparable[size];
        lastIdx = -1;
    }

    public void insert(T item) {
        if (lastIdx + 1 >= size) {
            extendSize();
        }
        array[++lastIdx] = item;
        if (lastIdx > 0) {
            siftUp(lastIdx);
        }
    }

    private void siftUp(int idx) {
        while (getParent(idx) >= 0) {
            if (array[idx].compareTo(array[getParent(idx)]) < 0) {
                T temp = array[idx];
                array[idx] = array[getParent(idx)];
                array[getParent(idx)] = temp;
                idx = getParent(idx);
            } else {
                break;
            }
        }
    }

    private void siftDown() {
    }

    private int getParent(int idx) {
        if (idx == 0) {
            return -1;
        } else {
            return (idx - 1) / 2;
        }
    }

    private void extendSize() {
        T[] temp = (T[]) new Comparable[size + size / 2];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }
}
