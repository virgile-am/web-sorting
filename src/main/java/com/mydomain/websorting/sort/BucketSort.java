package com.mydomain.websorting.sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static int[] sort(int[] array) {
        int n = array.length;
        if (n == 0) return array;

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] buckets = new ArrayList[n];

        // Create empty buckets
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Add elements into the buckets
        for (int j : array) {
            int bucketIndex = (j * n) / (n + 1);
            if (bucketIndex >= n) {
                bucketIndex = n - 1;  // Correct the index if it's out of bounds
            }
            buckets[bucketIndex].add(j);
        }

        // Sort the elements of each bucket
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Get the sorted array
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                array[index++] = num;
            }
        }
        return array;
    }
}
