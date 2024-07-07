package com.mydomain.websorting.resource;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SortedDataResourceTests {

    @Test
    public void testSortedDataResource() {
        int[] data = { 1, 3, 5, 7, 9 };

        // Assuming SortedDataResource constructor takes int[]
        SortedDataResource resource = new SortedDataResource(data);

        assertNotNull(resource);

        // Assuming there's a method to retrieve sorted data
        int[] sortedData = resource.getSortedData();

        assertArrayEquals(data, sortedData);
        // Add more assertions based on SortedDataResource behavior
    }
}
