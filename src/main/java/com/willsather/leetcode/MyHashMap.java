package com.willsather.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashMap<K, V> {
    private static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 10;
    private final List<LinkedList<Node<K, V>>> buckets;

    public MyHashMap() {
        buckets = new ArrayList<>(SIZE);

        // initialize each bucket to an empty LinkedList
        for (int i = 0; i < SIZE; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets.get(index);

        // check if key exists and update it
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        // if key does not exist, add new Node to bucket
        bucket.add(new Node<>(key, value));
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets.get(index);

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null; // key not found
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets.get(index);

        // remove node if key matches
        bucket.removeIf(node -> node.key.equals(key));
    }

    public int size() {
        int count = 0;
        for (LinkedList<Node<K, V>> bucket : buckets) {
            count += bucket.size();
        }
        return count;
    }
}
