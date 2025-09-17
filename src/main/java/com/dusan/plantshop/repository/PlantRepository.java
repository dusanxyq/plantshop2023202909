package com.dusan.plantshop.repository;

import com.dusan.plantshop.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    List<Plant> findByDeletedAtIsNull();
}
