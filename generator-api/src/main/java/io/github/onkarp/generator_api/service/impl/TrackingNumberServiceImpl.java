package io.github.onkarp.generator_api.service.impl;

import io.github.onkarp.generator_api.dto.TrackingNumberDto;
import io.github.onkarp.generator_api.entity.TrackingNumber;
import io.github.onkarp.generator_api.repository.TrackingNumberRepository;
import io.github.onkarp.generator_api.service.TrackingNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class TrackingNumberServiceImpl implements TrackingNumberService {

    private final TrackingNumberRepository trackingNumberRepository;

     private final AtomicLong counter = new AtomicLong();

     public TrackingNumber createTracking(TrackingNumberDto trackingNumberDto) {


         String trackingnumber = generateTrackingNumber(trackingNumberDto.getOriginCountryId(),trackingNumberDto.getDestinationCountryId());

         TrackingNumber trackingNumber = new TrackingNumber();

         trackingNumber.setTrackingNumber(trackingnumber);
         trackingNumber.setOriginCountryId(trackingNumberDto.getOriginCountryId());
         trackingNumber.setDestinationCountryId(trackingNumberDto.getDestinationCountryId());
         trackingNumber.setWeight(trackingNumberDto.getWeight());
         trackingNumber.setCustomerId(trackingNumberDto.getCustomerId());
         trackingNumber.setCreatedAt(OffsetDateTime.now());
         trackingNumber.setCustomerName(trackingNumberDto.getCustomerName());
         trackingNumber.setCustomerSlug(trackingNumberDto.getCustomerSlug());

         return trackingNumberRepository.save(trackingNumber);
     }

     private String generateTrackingNumber(String origin, String destination){
         long id =  counter.incrementAndGet();

         return String.format("%s%012d", origin + destination, id);
     }

}
