package io.github.onkarp.generator_api.controller;

import io.github.onkarp.generator_api.dto.TrackingNumberDto;
import io.github.onkarp.generator_api.entity.TrackingNumber;
import io.github.onkarp.generator_api.service.TrackingNumberService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Validated
public class TrackingNumberController {

    private final TrackingNumberService trackingNumberService;



    @GetMapping("/next-tracking-number")
    public ResponseEntity<Map<String,Object>> getTrackingNumber( @RequestParam String originCountryId,
                                                                @RequestParam String destinationCountryId,
                                                                @RequestParam  Double weight,
                                                                @RequestParam UUID customerId,
                                                                @RequestParam String customerName ,
                                                                @RequestParam String customerSlug)
    {
         TrackingNumberDto trackingNumberDto = new TrackingNumberDto();
         trackingNumberDto.setOriginCountryId(originCountryId);
         trackingNumberDto.setDestinationCountryId(destinationCountryId);
         trackingNumberDto.setWeight(weight);
         trackingNumberDto.setCustomerId(customerId);
         trackingNumberDto.setCustomerName(customerName);
         trackingNumberDto.setCustomerSlug(customerSlug);
        TrackingNumber trackingNumber = trackingNumberService.createTracking(trackingNumberDto);

        Map<String , Object> response = new HashMap<>();
        response.put("tracking_number", trackingNumber.getTrackingNumber());
        response.put("created_at", trackingNumber.getCreatedAt().toString());

        return ResponseEntity.ok(response);
    }


}
