package com.willsather.leetcode;

public class DoublyLinkedList {
    public static class Node {
        Node next;
        Node prev;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

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

        // clear references to help with garbage collection
        node.next = null;
        node.prev = null;
    }

    public Node removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node lastNode = tail.prev;
        remove(lastNode);
        return lastNode;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }
}
