package io.github.onkarp.generator_api.service;

import io.github.onkarp.generator_api.dto.TrackingNumberDto;
import io.github.onkarp.generator_api.entity.TrackingNumber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TrackingServiceTest {
    @Autowired
    private TrackingNumberService trackingNumberService;

    @Test
    void testTrackingNumberGeneration() {
        UUID customerId = UUID.randomUUID();

        TrackingNumberDto trackingNumberDto = new TrackingNumberDto();
        trackingNumberDto.setOriginCountryId("IN");
        trackingNumberDto.setDestinationCountryId("UK");
        trackingNumberDto.setWeight(4.566);
        trackingNumberDto.setCustomerId(customerId);
        trackingNumberDto.setCustomerName("TestBox Logistics");
        trackingNumberDto.setCustomerSlug("Testbox-logistics");

        TrackingNumber tn = trackingNumberService.createTracking(trackingNumberDto);

        assertNotNull(tn.getTrackingNumber());
        assertTrue(tn.getTrackingNumber().matches("^[A-Z0-9]{1,16}$"));
    }


}
