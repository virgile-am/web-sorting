

package com.mydomain.websorting.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.mydomain.websorting.service.SortingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(SortController.class)
public class SortControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private SortingService sortingService;

    @InjectMocks
    private SortController sortController;

    @Test
    public void testSortEndpoint() throws Exception {
        String requestBody = "9,5,7,1,3";
        int[] input = { 9, 5, 7, 1, 3 };
        int[] expected = { 1, 3, 5, 7, 9 };

        Mockito.when(sortingService.sort("quick", input)).thenReturn(expected);

        mockMvc.perform(MockMvcRequestBuilders.post("/sort")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("algorithm", "quick")
                        .param("data", requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sortedData").isArray());
        // Add more assertions based on your specific JSON response format
    }

    @Test
    public void testGetSortedSampleEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sorted-sample"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sortedData").isArray());
        // Add more assertions based on your specific JSON response format
    }
}
