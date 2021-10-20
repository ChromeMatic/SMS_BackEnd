package com.schManSys.sms.repository;

import com.schManSys.sms.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region,Long> {

    Region findByRegionId (Long regionId);
    Region findByRegionName (String regionName);
}
