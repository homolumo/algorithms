package SingleLink;

public class SingleLink<T> {
    private int count = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    public int getCount() {
        return count;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public Node<T> insertHead(T value) {
        Node<T> tNode = new Node<T>(value, head);
        head = tNode;
        count++;
        if (tail == null) tail = tNode;
        return tNode;
    }

    public Node<T> insertTail(T value) {
        Node<T> tNode = new Node<>(value, null);
        tail.setNext(tNode);
        tail = tNode;
        count++;
        if (head == null) head = tNode;
        return tNode;
    }

    public Node<T> insert(int index, T value) throws Exception {
        if (index == 0) return insertHead(value);
        if (index == count - 1) return insertTail(value);
        Node<T> preNode = getNode(index);
        Node<T> tNode = new Node<T>(value, preNode.getNext());
        preNode.setNext(tNode);
        count++;
        return tNode;
    }

    public T removeHead() {
        if (head == null) return null;
        T value = head.getValue();
        head = head.getNext();
        if (head == null) tail = null;
        count--;
        return value;
    }

    public T removeTail() {
        if (tail == null) return null;
        T value = tail.getValue();
        // 只有一个元素
        if (head == tail) {
            head = null;
            tail = null;
            count--;
            return value;
        }
        // 找到上一个
        Node<T> tNode = head;
        while (tNode.getNext() != tail) {
            tNode = tNode.getNext();
        }
        tNode.setNext(null);
        tail = tNode;
        count--;
        return value;
    }

    public T getValue(int index) throws Exception {
        Node<T> tNode = getNode(index);
        if (tNode == null) return null;
        return tNode.getValue();
    }

    public Node<T> getNode(int index) throws Exception {
        Node<T> tNode = head;
        while (index > 0) {
            if (tNode == null) throw new Exception("index out of bound");
            tNode = tNode.getNext();
            index--;
        }
        return tNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> tNode = head;
        while (tNode != null) {
            sb.append(tNode.getValue().toString()).append(" ");
            tNode = tNode.getNext();
        }
        return sb.toString().trim();
    }
}
