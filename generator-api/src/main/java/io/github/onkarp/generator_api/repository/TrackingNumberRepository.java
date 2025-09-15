package io.github.onkarp.generator_api.repository;

import io.github.onkarp.generator_api.entity.TrackingNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingNumberRepository extends JpaRepository<TrackingNumber,Long> {
}
