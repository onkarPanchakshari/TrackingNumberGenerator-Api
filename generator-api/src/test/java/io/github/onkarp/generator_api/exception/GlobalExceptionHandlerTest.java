package io.github.onkarp.generator_api.exception;

import io.github.onkarp.generator_api.controller.TrackingNumberController;
import io.github.onkarp.generator_api.service.TrackingNumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(GlobalExceptionHandler.class)
@ActiveProfiles("test")
public class GlobalExceptionHandlerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TrackingNumberService trackingNumberService;

    @Test
    void testInvalidWeight_ShouldReturnBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/next-tracking-number")
                        .param("originCountryId", "MY")
                        .param("destinationCountryId", "ID")
                        .param("weight", " ")
                        .param("createdAt", "2025-09-12T23:45:32+05:30")
                        .param("customerId", "de619854-b59b-425e-9db4-943979e1bd49")
                        .param("customerName", "RedBox Logistics")
                        .param("customerSlug", "redbox-logistics"))
                .andExpect(status().isBadRequest());
    }
}
