package SingleLink;

public class Node<T> {
    private Node<T> next;
    private T value;

    Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> setNext(Node<T> next) {
        this.next = next;
        return this;
    }

    public T getValue() {
        return value;
    }

    public Node<T> setValue(T value) {
        this.value = value;
        return this;
    }
}
