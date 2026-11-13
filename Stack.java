public class stack<T> {

    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);

        newNode.next = top;
        top = newNode;

        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack kosong");
        }

        T removedData = top.data;
        top = top.next;

        size--;

        return removedData;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack kosong");
        }

        return top.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public void display() {
        Node<T> current = top;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}