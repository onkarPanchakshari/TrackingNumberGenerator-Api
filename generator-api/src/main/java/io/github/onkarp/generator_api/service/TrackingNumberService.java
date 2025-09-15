package io.github.onkarp.generator_api.service;


import io.github.onkarp.generator_api.dto.TrackingNumberDto;
import io.github.onkarp.generator_api.entity.TrackingNumber;

import java.util.UUID;

public interface TrackingNumberService {

    public TrackingNumber createTracking(TrackingNumberDto trackingNumberDto);
}
