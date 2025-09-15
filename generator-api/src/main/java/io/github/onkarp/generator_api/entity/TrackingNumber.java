package io.github.onkarp.generator_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "tracking_num")
public class TrackingNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tracking_number", unique = true, nullable = false, length = 16)
    private String trackingNumber;

    private String originCountryId;
    private String destinationCountryId;
    private Double weight;
    private OffsetDateTime createdAt;
    private UUID customerId;
    private String customerName;
    private String customerSlug;
}
