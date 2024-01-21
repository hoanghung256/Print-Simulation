package datastructure;

/**
 *
 * @author hoang
 */
public class ArrayQueue {
    public Object[] a;
    public int max;
    public int first;
    public int last;

    public ArrayQueue(int max) {
        this.max = max;
        a = new Object[max];
        first = last = -1;
    }

    public ArrayQueue() {
        this(10);
    }

    public boolean isEmpty() {
        return (first == -1);
    }

    public boolean isFull() {
        return ((first == 0 && last == max - 1) || first == last + 1);
    }

    public boolean grow() {
        int i, j;
        int newMax = max + max / 2;
        Object[] a1 = new Object[newMax];

        if (last >= first) {
            for (i = first; i < last; i++) {
                a1[i - first] = a[i];
            }
        } else {
            for (i = first; i < last; i++) {
                a1[i - first] = a[i];
            }
            i = max - first;
            for (j = 0; j <= last; j++) {
                a1[i + j] = a[j];
            }
        }
        a = a1;
        first = 0;
        last = max - 1;
        max = newMax;
        return true;
    }

    public void enqueue(Object x) {
        if (isFull() && !grow())
            return;

        if (last == max - 1 || last == -1) {
            a[0] = x;
            last = 0;
            if (first == -1) {
                first = 0;
            }
        } else {
            a[++last] = x;
        }
    }

    public Object dequeue() throws Exception {
        if (isEmpty())
            throw new Exception();
        Object x = a[first];

        if (first == last) {
            first = last = -1;
        } else if (first == max - 1) {
            first = 0;
        } else {
            first++;
        }

        return x;
    }

    public void insert(int index, Object x) throws Exception {
        if (index < 0 || index > max) {
            throw new Exception("Index out of bounds");
        }
        if (isFull() && !grow()) {
            return;
        }
        for (int i = last; i >= index; i--) {
            a[(i + 1) % max] = a[i];
        }
        a[index] = x;
        if (index > last) {
            last = index;
        } else {
            last = (last + 1) % max;
        }
        if (first == -1) {
            first = 0;
        }
    }

    public Object front() throws Exception {
        if (isEmpty())
            throw new Exception();
        return (a[first]);
    }
}