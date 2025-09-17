package com.dusan.plantshop.service;

import com.dusan.plantshop.model.Plant;
import com.dusan.plantshop.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantService {
    private final PlantRepository plantRepository;

    public List<Plant> getAllPlants() {
        return plantRepository.findByDeletedAtIsNull();
    }

    public Plant createPlant(Plant plant) {
        return plantRepository.save(plant);
    }

    public Plant updatePlant(Long id, Plant plantDetails) {
        Plant plant = plantRepository.findById(id).orElseThrow();
        plant.setName(plantDetails.getName());
        plant.setPrice(plantDetails.getPrice());
        plant.setCategory(plantDetails.getCategory());
        return plantRepository.save(plant);
    }

    public void softDeletePlant(Long id) {
        Plant plant = plantRepository.findById(id).orElseThrow();
        plant.setDeletedAt(LocalDateTime.now());
        plantRepository.save(plant);
    }
}
