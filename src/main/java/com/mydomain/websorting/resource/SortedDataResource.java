package com.mydomain.websorting.resource;

import org.springframework.hateoas.RepresentationModel;

import java.util.Arrays;

public class SortedDataResource extends RepresentationModel<SortedDataResource> {
    private int[] content;

    public SortedDataResource(int[] content) {
        this.content = content;
    }

    public int[] getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "SortedDataResource{" +
                "content=" + Arrays.toString(content) +
                '}';
    }

    public int[] getSortedData() {
        // Implement sorting logic here (for example, sorting the content array)
        int[] sortedArray = Arrays.copyOf(content, content.length);
        Arrays.sort(sortedArray);
        return sortedArray;
    }
}
