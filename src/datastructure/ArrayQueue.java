package datastructure;

/**
 *
 * @author hoang
 */
public class ArrayQueue {
    protected Object[] a;
    protected int max;
    protected int first;
    protected int last;

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

    private boolean grow() {
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

    void enqueue(Object x) {
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

    Object dequeue() throws Exception {
        if (isEmpty())
            throw new Exception();
        Object x = a[first];

        if (first == last) {
            first = last = - 1;
        } else if (first == max - 1) {
            first = 0;
        } else {
            first++;
        }

        return x;
    }

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue();

        aq.enqueue("1");
        aq.enqueue("2");
        aq.enqueue("3");
        aq.enqueue("4");

        while (!aq.isEmpty()) {
            try {
                System.out.print(aq.dequeue() + " ");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                break;
            }
        }
    }
}