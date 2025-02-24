package com.willsather.leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MyHashMapTest {

    @Test
    void testPutAndGet() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        assertThat(map.get("one")).isEqualTo(1);
        assertThat(map.get("two")).isEqualTo(2);
        assertThat(map.get("three")).isEqualTo(3);
    }

    @Test
    void testOverwriteValue() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("key", 100);
        assertThat(map.get("key")).isEqualTo(100);

        map.put("key", 200);
        assertThat(map.get("key")).isEqualTo(200);
    }

    @Test
    void testRemoveExistingKey() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("key1", 10);
        map.put("key2", 20);

        map.remove("key1");
        assertThat(map.get("key1")).isNull();
        assertThat(map.get("key2")).isEqualTo(20);
    }

    @Test
    void testRemoveNonExistentKey() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("one", 1);
        map.remove("two"); // should not throw an error

        assertThat(map.get("one")).isEqualTo(1);
    }

    @Test
    void testCollisionHandling() {
        MyHashMap<Integer, String> map = new MyHashMap<>();

        // these two keys should ideally hash to the same bucket
        int key1 = 10;
        int key2 = 10 + 10;

        map.put(key1, "first");
        map.put(key2, "second");

        assertThat(map.get(key1)).isEqualTo("first");
        assertThat(map.get(key2)).isEqualTo("second");

        // now remove one and check that the other still exists
        map.remove(key1);
        assertThat(map.get(key1)).isNull();
        assertThat(map.get(key2)).isEqualTo("second");
    }

    @Test
    void testGetFromEmptyMap() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        assertThat(map.get("nonexistent")).isNull();
    }

    @Test
    void testRemoveFromEmptyMap() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.remove("randomKey"); // should not throw an error
        assertThat(map.get("randomKey")).isNull();
    }
}
