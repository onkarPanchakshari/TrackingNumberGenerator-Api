package io.github.onkarp.generator_api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class TrackingNumberDto {
    @NotBlank(message = "OriginCountry Id is required")
    private String originCountryId;

    @NotBlank(message = "destinationCountryId Id is required")
    private String destinationCountryId;

    @NotNull
    @Min(value = 1, message = "Weight must be greater than 0")
    private Double weight;

    @NotBlank(message = "customerId Id is required")
    private UUID customerId;

    @NotBlank
    private String customerName;

    @NotBlank
    private String customerSlug;

}
