package com.willsather.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

class Node2 {
    int key;
    int value;

    public Node2(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache2 {
    int capacity;                   // maintain allowed capacity
    HashMap<Integer, Node2> map;     // maintain fast key/value lookup
    LinkedList<Node2> list;          // maintain order

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new LinkedList<>();
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }

        Node2 current = this.map.get(key);
        this.list.remove(current);
        this.list.addFirst(current);

        return current.value;
    }

    public void put(int key, int value) {
        // if present, move to front
        if (this.map.containsKey(key)) {
            Node2 node = this.map.get(key);
            node.value = value;

            this.list.remove(node);
            this.list.addFirst(node);

        // if not present, add to front
        } else {
            Node2 newNode = new Node2(key, value);
            this.list.addFirst(newNode);
            this.map.put(key, newNode);

            // if over capacity, delete last
            if (this.map.size() > this.capacity) {
                Node2 last = this.list.removeLast();
                this.map.remove(last.key);
            }
        }
    }
}