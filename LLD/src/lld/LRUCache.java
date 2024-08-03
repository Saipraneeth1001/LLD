package lld;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<T> {

    int capacity = 0;
    int size;
    public Map<String, Node> map;
    public DoublyLinkedList<Node> queue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        queue = new DoublyLinkedList<>();
    }

    public class Node {
        String key;
        T value;
        Node prev, next;

        public Node(String key, T value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public T get(String key) {
        Node node = map.get(key);
        if (node == null) return null;
        queue.moveCurrentNodeToFront(node);
        return map.get(key).value;
    }

    public void put(String key, T value) {
       Node currentNode = map.get(key);
       if (currentNode != null) {
           currentNode.value = value;
           queue.moveCurrentNodeToFront(currentNode);
           return;
       }

       if (size == capacity) {
           String rearKey = queue.getRearKey();
           queue.removeElementFromEnd();
           map.remove(rearKey);
           size--;
       }

       Node node = new Node(key, value);
       queue.addElementToFront(node);
       map.put(key, node);
       size++;
    }

    public class DoublyLinkedList<T> {
        Node front, rear;
        public DoublyLinkedList() {
            front = rear = null;
        }

        public void moveCurrentNodeToFront(Node node) {
            if (front == node) {
                return;
            }
            if (rear == node) {
                rear = rear.prev;
                rear.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = front;
            front.prev = node;
            front = node;
        }

        public void addElementToFront(Node node) {
            if (rear == null) {
                front = rear = node;
                return;
            }
            node.next = front;
            front.prev = node;
            front = node;
        }

        public void removeElementFromEnd() {
            if (rear == null) {
                return;
            }
            System.out.println("removing element "+getRearKey());
            if (front == rear) {
                front = rear = null;
            } else {
                rear = rear.prev;
                rear.next = null;
            }
        }

        public String getRearKey() {
            return rear.key;
        }
    }
}
