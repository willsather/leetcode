package com.willsather.leetcode;

import java.util.HashMap;

class Node {
    Node next;
    Node prev;

    int key;
    int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = new Node(0, 0); // dummy head
        this.tail = new Node(0, 0); // dummy tail

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void addToFront(Node node) {
        node.next = this.head.next;
        node.prev = this.head;

        this.head.next.prev = node;
        this.head.next = node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public Node removeLast() {
        // list is empty
        if (tail.prev == head) {
            return null;
        }

        Node lastNode = tail.prev;
        remove(lastNode);

        return lastNode;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//
//        Node current = head.next; // Skip dummy head
//        while (current != tail) { // Stop before dummy tail
//            sb.append("(").append(current.key).append(", ").append(current.value).append(")");
//            if (current.next != tail) {
//                sb.append(" <-> "); // Use arrow to indicate links
//            }
//            current = current.next;
//        }
//
//        sb.append("]");
//        return sb.toString();
//    }
}

class LRUCache {
    int capacity;                   // maintain allowed capacity
    HashMap<Integer, Node> map;     // maintain fast key/value lookup
    DoublyLinkedList list;          // maintain order

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }

        Node current = this.map.get(key);
        this.list.remove(current);
        this.list.addToFront(current);

        return current.value;
    }

    public void put(int key, int value) {
        // if present, move to front
        if (this.map.containsKey(key)) {
            Node node = this.map.get(key);
            node.value = value;

            this.list.remove(node);
            this.list.addToFront(node);

        // if not present, add to front
        } else {
            Node newNode = new Node(key, value);
            this.list.addToFront(newNode);
            this.map.put(key, newNode);

            // if over capacity, delete last
            if (this.map.size() > this.capacity) {
                Node last = this.list.removeLast();
                this.map.remove(last.key);
            }
        }
    }
}