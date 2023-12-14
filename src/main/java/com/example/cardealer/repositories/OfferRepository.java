package com.example.cardealer.repositories;

import com.example.cardealer.models.enteties.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {

    Optional<Offer> findById(String id);

    @Transactional
    void deleteById(String id);

    List<Offer> findTop6ByOrderByModifiedDesc();
}
