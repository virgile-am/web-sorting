package com.mydomain.websorting.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SortingServiceTests {

    @Autowired
    private SortingService sortingService;

    @Test
    public void testQuickSort() {
        int[] input = { 9, 5, 7, 1, 3 };
        int[] expected = { 1, 3, 5, 7, 9 };

        int[] result = sortingService.sort("quick", input);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testHeapSort() {
        int[] input = { 9, 5, 7, 1, 3 };
        int[] expected = { 1, 3, 5, 7, 9 };

        int[] result = sortingService.sort("heap", input);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeSort() {
        int[] input = { 9, 5, 7, 1, 3 };
        int[] expected = { 1, 3, 5, 7, 9 };

        int[] result = sortingService.sort("merge", input);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testRadixSort() {
        int[] input = { 9, 5, 7, 1, 3 };
        int[] expected = { 1, 3, 5, 7, 9 };

        int[] result = sortingService.sort("radix", input);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testBucketSort() {
        int[] input = { 9, 5, 7, 1, 3, 12 };
        int[] expected = { 1, 3, 5, 7, 9, 12 };

        int[] result = sortingService.sort("bucket", input);

        assertArrayEquals(expected, result);
    }
}
