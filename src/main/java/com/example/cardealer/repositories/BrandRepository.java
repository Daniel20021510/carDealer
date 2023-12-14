package com.example.cardealer.repositories;

import com.example.cardealer.models.enteties.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {

    Optional<Brand> findByName(String name);

    @Transactional
    void deleteByName(String name);
}
