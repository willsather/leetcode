package com.willsather.leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class DoublyLinkedListTest {

    @Test
    void testAddToFront() {
        DoublyLinkedList list = new DoublyLinkedList();
        DoublyLinkedList.Node node1 = new DoublyLinkedList.Node(1, 100);
        DoublyLinkedList.Node node2 = new DoublyLinkedList.Node(2, 200);

        list.addToFront(node1);
        list.addToFront(node2);

        assertThat(list.head.next).isEqualTo(node2);
        assertThat(list.head.next.next).isEqualTo(node1);
        assertThat(list.tail.prev).isEqualTo(node1);
    }

    @Test
    void testRemoveNode() {
        DoublyLinkedList list = new DoublyLinkedList();
        DoublyLinkedList.Node node1 = new DoublyLinkedList.Node(1, 100);
        DoublyLinkedList.Node node2 = new DoublyLinkedList.Node(2, 200);
        DoublyLinkedList.Node node3 = new DoublyLinkedList.Node(3, 300);

        list.addToFront(node1);
        list.addToFront(node2);
        list.addToFront(node3);

        list.remove(node2);

        assertThat(list.head.next).isEqualTo(node3);
        assertThat(list.head.next.next).isEqualTo(node1);
        assertThat(list.tail.prev).isEqualTo(node1);
        assertThat(node2.next).isNull();
        assertThat(node2.prev).isNull();
    }

    @Test
    void testRemoveLast() {
        DoublyLinkedList list = new DoublyLinkedList();
        DoublyLinkedList.Node node1 = new DoublyLinkedList.Node(1, 100);
        DoublyLinkedList.Node node2 = new DoublyLinkedList.Node(2, 200);
        DoublyLinkedList.Node node3 = new DoublyLinkedList.Node(3, 300);

        list.addToFront(node1);
        list.addToFront(node2);
        list.addToFront(node3);

        DoublyLinkedList.Node removedNode = list.removeLast();

        assertThat(removedNode).isEqualTo(node1);
        assertThat(list.tail.prev).isEqualTo(node2);
    }

    @Test
    void testRemoveLastOnEmptyList() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertThat(list.removeLast()).isNull();
    }

    @Test
    void testRemoveLastWithOneNode() {
        DoublyLinkedList list = new DoublyLinkedList();
        DoublyLinkedList.Node node = new DoublyLinkedList.Node(1, 100);

        list.addToFront(node);
        DoublyLinkedList.Node removedNode = list.removeLast();

        assertThat(removedNode).isEqualTo(node);
        assertThat(list.head.next).isEqualTo(list.tail);
        assertThat(list.tail.prev).isEqualTo(list.head);
    }
}
