package com.mydomain.websorting.service;

import com.mydomain.websorting.sort.*;
import org.springframework.stereotype.Service;

@Service
public class SortingService {

    public int[] sort(String algorithm, int[] data) {
        return switch (algorithm.toLowerCase()) {
            case "heap" -> HeapSort.sort(data);
            case "quick" -> QuickSort.sort(data);
            case "merge" -> MergeSort.sort(data);
            case "radix" -> RadixSort.sort(data);
            case "bucket" -> BucketSort.sort(data);
            default -> throw new IllegalArgumentException("Unknown sorting algorithm: " + algorithm);
        };
    }
}
