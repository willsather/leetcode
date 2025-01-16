package com.willsather.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCache2Test {

    @Test
    void testPutAndGet() {
        LRUCache2 cache = new LRUCache2(3);

        // Add entries to the cache
        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);

        // Verify entries can be retrieved
        assertThat(cache.get(1)).isEqualTo(100);
        assertThat(cache.get(2)).isEqualTo(200);
        assertThat(cache.get(3)).isEqualTo(300);
    }

    @Test
    void testEvictionWhenCapacityIsExceeded() {
        LRUCache2 cache = new LRUCache2(2);

        // Add entries to the cache
        cache.put(1, 100);
        cache.put(2, 200);

        // Access key 1 to make it recently used
        assertThat(cache.get(1)).isEqualTo(100);

        // Add another entry, causing eviction of key 2
        cache.put(3, 300);

        // Key 2 should have been evicted
        assertThat(cache.get(2)).isEqualTo(-1);

        // Key 1 and 3 should still be accessible
        assertThat(cache.get(1)).isEqualTo(100);
        assertThat(cache.get(3)).isEqualTo(300);
    }

    @Test
    void testUpdateValueForExistingKey() {
        LRUCache2 cache = new LRUCache2(2);

        // Add entries to the cache
        cache.put(1, 100);
        cache.put(2, 200);

        // Update the value of an existing key
        cache.put(1, 150);

        // Verify the value is updated
        assertThat(cache.get(1)).isEqualTo(150);

        // Add another entry, causing eviction of key 2
        cache.put(3, 300);

        // Key 2 should have been evicted
        assertThat(cache.get(2)).isEqualTo(-1);

        // Key 1 and 3 should still be accessible
        assertThat(cache.get(1)).isEqualTo(150);
        assertThat(cache.get(3)).isEqualTo(300);
    }

    @Test
    void testAccessOrderIsMaintained() {
        LRUCache2 cache = new LRUCache2(3);

        // Add entries to the cache
        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);

        // Access key 1 to make it recently used
        assertThat(cache.get(1)).isEqualTo(100);

        // Add another entry, causing eviction of key 2
        cache.put(4, 400);

        // Key 2 should have been evicted
        assertThat(cache.get(2)).isEqualTo(-1);

        // Keys 1, 3, and 4 should be accessible
        assertThat(cache.get(1)).isEqualTo(100);
        assertThat(cache.get(3)).isEqualTo(300);
        assertThat(cache.get(4)).isEqualTo(400);
    }

    @Test
    void testEmptyCacheReturnsMinusOne() {
        LRUCache2 cache = new LRUCache2(2);

        // Try to get a key from an empty cache
        assertThat(cache.get(1)).isEqualTo(-1);
    }

    @Test
    void testEvictionWhenAddingMultipleEntries() {
        LRUCache2 cache = new LRUCache2(3);

        // Add entries to the cache
        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);

        // Access key 2 to make it recently used
        assertThat(cache.get(2)).isEqualTo(200);

        // Add another entry, causing eviction of key 1
        cache.put(4, 400);

        // Key 1 should have been evicted
        assertThat(cache.get(1)).isEqualTo(-1);

        // Keys 2, 3, and 4 should be accessible
        assertThat(cache.get(2)).isEqualTo(200);
        assertThat(cache.get(3)).isEqualTo(300);
        assertThat(cache.get(4)).isEqualTo(400);
    }
}
