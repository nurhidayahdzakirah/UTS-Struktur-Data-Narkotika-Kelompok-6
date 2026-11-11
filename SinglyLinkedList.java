public class SinglyLinkedList<T> implements StrukturData<T> {

    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);

        if (index == 0) {
            T removedData = head.data;
            head = head.next;
            size--;
            return removedData;
        }

        Node<T> current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        T removedData = current.next.data;
        current.next = current.next.next;

        size--;

        return removedData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T data) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index tidak valid: " + index
            );
        }
    }

    public void display() {
        Node<T> current = head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}