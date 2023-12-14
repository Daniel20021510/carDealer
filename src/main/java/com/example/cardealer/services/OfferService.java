package com.example.cardealer.services;

import com.example.cardealer.dtos.AddModelDto;
import com.example.cardealer.dtos.AddOfferDto;
import com.example.cardealer.dtos.ShortOfferDto;
import com.example.cardealer.models.enteties.Offer;
import com.example.cardealer.repositories.BrandRepository;
import com.example.cardealer.repositories.ModelRepository;
import com.example.cardealer.repositories.OfferRepository;
import com.example.cardealer.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class OfferService {
    private final OfferRepository offerRepository;

    private final ModelRepository modelRepository;

    private final UserRepository userRepository;

    private final ModelMapper mapper;

    public OfferService(OfferRepository offerRepository, ModelRepository modelRepository, UserRepository userRepository, ModelMapper mapper) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

//    @CacheEvict(cacheNames = "offers", allEntries = true)
    public void addOffer(AddOfferDto offerDto) {

        Offer offer = mapper.map(offerDto, Offer.class);
        offer.setModel(modelRepository.findByName(offerDto.getModelName()).orElse(null));
        offer.setSeller(userRepository.findByUsername(offerDto.getSeller()).orElse(null));

        offerRepository.saveAndFlush(offer);
    }

    @Cacheable("offers")
    public List<ShortOfferDto> getLatestOffers() {
        List<ShortOfferDto> latestOffers = offerRepository.findTop6ByOrderByModifiedDesc().stream().map((offer) ->
                mapper.map(offer, ShortOfferDto.class)).collect(Collectors.toList());;
        for (ShortOfferDto offer: latestOffers){
             offer.setBrandName(mapper.map(modelRepository.findByName(offer.getModelName()), AddModelDto.class).getBrandName());
        }
        return latestOffers;
    }
}
