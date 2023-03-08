package io.mosip.idrepository.identity.repository;

import io.mosip.idrepository.identity.entity.ExtractionFailTracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtractionFailTrackingRepo extends JpaRepository<ExtractionFailTracking,String> {


}
