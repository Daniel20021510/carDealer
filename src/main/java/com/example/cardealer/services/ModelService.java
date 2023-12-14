package com.example.cardealer.services;

import com.example.cardealer.dtos.AddModelDto;
import com.example.cardealer.dtos.ShowModelInfoDto;
import com.example.cardealer.models.enteties.Model;
import com.example.cardealer.repositories.BrandRepository;
import com.example.cardealer.repositories.ModelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class ModelService {
    private final ModelRepository modelRepository;

    private final BrandRepository brandRepository;

    private final ModelMapper mapper;

    public ModelService(ModelRepository modelRepository, BrandRepository brandRepository, ModelMapper mapper) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.mapper = mapper;
    }

    @CacheEvict(cacheNames = "models", allEntries = true)
    public void addModel(AddModelDto modelDto) {

        Model model = mapper.map(modelDto, Model.class);
        model.setBrand(brandRepository.findByName(modelDto.getBrandName()).orElse(null));

        modelRepository.saveAndFlush(model);
    }

    public List<ShowModelInfoDto> allModels() {
        return modelRepository.findAll().stream().map(model -> mapper.map(model, ShowModelInfoDto.class))
                .collect(Collectors.toList());
    }
}
