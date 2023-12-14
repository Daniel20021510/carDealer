package com.example.cardealer.repositories;

import com.example.cardealer.models.enteties.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {

    Optional<Model> findByName(String name);

    @Transactional
    void deleteByName(String name);
}
