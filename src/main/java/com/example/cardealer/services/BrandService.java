package com.example.cardealer.services;

import com.example.cardealer.dtos.AddBrandDto;
import com.example.cardealer.dtos.ShowBrandInfoDto;
import com.example.cardealer.models.enteties.Brand;
import com.example.cardealer.repositories.BrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper mapper;

    public BrandService(BrandRepository brandRepository, ModelMapper mapper) {
        this.brandRepository = brandRepository;
        this.mapper = mapper;
    }

    @CacheEvict(cacheNames = "brands", allEntries = true)
    public void addBrand(AddBrandDto brandDto) {
        brandRepository.saveAndFlush(mapper.map(brandDto, Brand.class));
    }

    public List<ShowBrandInfoDto> allBrands() {
        return brandRepository.findAll().stream().map(brand -> mapper.map(brand, ShowBrandInfoDto.class))
                .collect(Collectors.toList());
    }
//
//    public ShowDetailedCompanyInfoDto brandDetails(String brandName) {
//        return mapper.map(brandRepository.findByName(brandName).orElse(null), ShowDetailedCompanyInfoDto.class);
//    }
//
//    public void removeBrand(String brandName) {
//        brandRepository.deleteByName(brandName);
//    }
}
