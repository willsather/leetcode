package com.willsather.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    private static class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;                   // maintain allowed capacity
    HashMap<Integer, Node> map;     // maintain fast key/value lookup
    LinkedList<Node> list;          // maintain order

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new LinkedList<>();
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }

        Node current = this.map.get(key);
        this.list.remove(current);
        this.list.addFirst(current);

        return current.value;
    }

    public void put(int key, int value) {
        // if present, move to front
        if (this.map.containsKey(key)) {
            Node node = this.map.get(key);
            node.value = value;

            this.list.remove(node);
            this.list.addFirst(node);

        // if not present, add to front
        } else {
            Node newNode = new Node(key, value);
            this.list.addFirst(newNode);
            this.map.put(key, newNode);

            // if over capacity, delete last
            if (this.map.size() > this.capacity) {
                Node last = this.list.removeLast();
                this.map.remove(last.key);
            }
        }
    }
}