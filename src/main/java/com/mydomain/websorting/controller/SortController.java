package com.mydomain.websorting.controller;

import com.mydomain.websorting.service.SortingService;
import com.mydomain.websorting.resource.SortedDataResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class SortController {

    @Autowired
    private SortingService sortingService;

    // ObjectMapper class
    private ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/sort")
    public ResponseEntity<?> sort(@RequestParam String algorithm, @RequestParam String data) {
        try {
            // Convert input data to integer array
            String[] stringData = data.split(",");
            int[] intData = new int[stringData.length];
            for (int i = 0; i < stringData.length; i++) {
                intData[i] = Integer.parseInt(stringData[i].trim());
            }

            // Perform sorting
            int[] sortedData = sortingService.sort(algorithm, intData);

            // Create SortedDataResource
            SortedDataResource resource = new SortedDataResource(sortedData);

            // Add HATEOAS link
            resource.add(WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(SortController.class).sort(algorithm, data))
                    .withRel("sort"));

            // Serialize the response to JSON
            String json = mapper.writeValueAsString(resource);

            return ResponseEntity.ok(json);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid data format. Please enter comma-separated integers.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging purposes
            return ResponseEntity.internalServerError().body("Internal Server Error: " + e.getMessage());
        }
    }

    @GetMapping("/sorted-sample")
    public ResponseEntity<?> getSortedSample() {
        try {
            // Sample array to sort (can be replaced with your actual data or generated dynamically)
            int[] sampleArray = { 9, 5, 7, 1, 3 };

            // Perform sorting (using a default algorithm, can be customized)
            int[] sortedSample = sortingService.sort("quick", sampleArray);

            // Create SortedDataResource
            SortedDataResource resource = new SortedDataResource(sortedSample);

            // Add HATEOAS links
            resource.add(WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(SortController.class).getSortedSample())
                    .withSelfRel());

            resource.add(WebMvcLinkBuilder.linkTo(
                            WebMvcLinkBuilder.methodOn(SortController.class).sort("QuickSort", "9,5,7,1,3"))
                    .withRel("sort"));

            // Serialize the response to JSON
            String json = mapper.writeValueAsString(resource);

            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging purposes
            return ResponseEntity.internalServerError().body("Internal Server Error: " + e.getMessage());
        }
    }
}
