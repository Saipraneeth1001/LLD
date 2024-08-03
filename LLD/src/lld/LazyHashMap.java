package lld;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LazyHashMap<K, V> {
    int default_size = 4;
    int N = 4;
    public int n = 0;
    public class Node {
        K key;
        V value;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return key+"="+value;
        }
    }
    public LinkedList<Node> []buckets;
    public LazyHashMap() {
        buckets = new LinkedList[default_size];
        for (int i = 0;i < default_size;i++) {
             buckets[i] = new LinkedList<Node>();
        }
    }

    public List<Node> keySet() {
        List<Node> list = new ArrayList<>();
        for (LinkedList<Node> data : this.buckets) {
            list.addAll(data);
        }
        return list;
    }

    public int generateIndex(K key) {
        return Math.abs(key.hashCode()) % N;
    }

    public V remove(K key) {
        int index = generateIndex(key);
        int nodeIndex = getNodeIndex(key, index);
        if (nodeIndex != -1) {
            LinkedList<Node> data = buckets[index];
            n--;
            return data.remove(nodeIndex).value;
        }
        return null;
    }

    public V get(K key) {
        int index = generateIndex(key);
        int nodeIndex = getNodeIndex(key, index);
        if (nodeIndex != -1) {
            return this.buckets[index].get(nodeIndex).value;
        } else return null;
    }

    public int getNodeIndex(K key, int keyIndex) {
        LinkedList<Node> data = this.buckets[keyIndex];
        for (int j = 0;j < data.size();j++) {
            Node node = data.get(j);
            if (node.key == key) {
                return j;
            }
        }
        return -1;
    }

    public boolean containsKey(K key) {
        int keyIndex = generateIndex(key);
        int nodeIndex = getNodeIndex(key, keyIndex);
        if (nodeIndex != -1) {
            return true;
        } else return false;
    }

    public void put(K key, V value) {
        int index = generateIndex(key);
        int nodeIndex = getNodeIndex(key, index);
        if (nodeIndex != -1) {
            Node node = this.buckets[index].get(nodeIndex);
            node.value = value;

        } else {
            Node newNode = new Node(key, value);
            buckets[index].add(newNode);
            n++;
        }
        if (n / N >= default_size) {
            rehash();
        }
    }

    public void rehash() {
        N = N * 2;
        n = 0;
        LinkedList<Node>  []oldBuckets = this.buckets;
        this.buckets = new LinkedList[N];

        for (int i = 0; i < N;i++) {
            this.buckets[i] = new LinkedList<Node>();
        }

        for (int i = 0;i < oldBuckets.length;i++) {
            LinkedList<Node> data = oldBuckets[i];
            for (int j = 0;j < data.size();j++) {
                Node node = data.get(j);
                put(node.key, node.value);
            }
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

}
