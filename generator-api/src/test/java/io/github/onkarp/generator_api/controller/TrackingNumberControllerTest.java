package io.github.onkarp.generator_api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TrackingNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetTrackingNumber_Success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/next-tracking-number")
                        .param("originCountryId", "IN")
                        .param("destinationCountryId", "FR")
                        .param("weight", "3.234")
                        .param("createdAt", "2025-09-12T23:45:32+05:30")
                        .param("customerId", "550e8400-e29b-41d4-a716-446655440000")
                        .param("customerName", "TestBox Logistics")
                        .param("customerSlug", "Testbox-logistics"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tracking_number").exists())
                .andExpect(jsonPath("$.created_at").exists());
    }

    @Test
    void testGetTrackingNumber_MissingParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/next-tracking-number")
                        .param("origin_country_id", "IN"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Missing required parameter"));
    }
}
