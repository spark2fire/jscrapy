package cn.spark2fire.jscrapy.util;

public class PriorityQueue<T extends Comparable> {
    private T[] tree;
    private int size = 10;
    private int lastIdx;

    public PriorityQueue() {
        tree = (T[]) new Comparable[size];
        lastIdx = -1;
    }

    public boolean isEmpty() {
        return lastIdx < 0;
    }

    public void insert(T item) {
        if (lastIdx + 1 >= size) {
            extendSize();
        }
        tree[++lastIdx] = item;
        if (lastIdx > 0) {
            siftUp(lastIdx);
        }
    }

    public T getTop() {
        return tree[0];
    }

    public T pop() {
        T top = tree[0];
        tree[0] = tree[lastIdx];
        tree[lastIdx--] = null;
        siftDown(0);
        return top;
    }

    private void siftUp(int idx) {
        while (getParent(idx) >= 0) {
            if (tree[idx].compareTo(tree[getParent(idx)]) < 0) {
                T temp = tree[idx];
                tree[idx] = tree[getParent(idx)];
                tree[getParent(idx)] = temp;
                idx = getParent(idx);
            } else {
                break;
            }
        }
    }

    private void siftDown(int idx) {
        while (getLeft(idx) <= lastIdx) {
            if (getRight(idx) > lastIdx) {
                if (tree[idx].compareTo(tree[getLeft(idx)]) > 0) {
                    T tempData = tree[idx];
                    tree[idx] = tree[getLeft(idx)];
                    tree[getLeft(idx)] = tempData;

                    idx = getLeft(idx);
                } else {
                    break;
                }
            } else {
                int childIdx = tree[getLeft(idx)].compareTo(tree[getRight(idx)]) < 0 ? getLeft(idx) : getRight(idx);
                if (tree[idx].compareTo(tree[childIdx]) > 0) {
                    T tempData = tree[idx];
                    tree[idx] = tree[childIdx];
                    tree[childIdx] = tempData;
                    idx = childIdx;
                } else {
                    break;
                }
            }
        }
    }

    private int getParent(int idx) {
        if (idx == 0) {
            return -1;
        } else {
            return (idx - 1) / 2;
        }
    }

    private int getLeft(int idx) {
        return 2 * idx + 1;
    }

    private int getRight(int idx) {
        return 2 * idx + 2;
    }

    private void extendSize() {
        T[] temp = (T[]) new Comparable[size + size / 2];
        for (int i = 0; i < size; i++) {
            temp[i] = tree[i];
        }
        tree = temp;
    }
}
