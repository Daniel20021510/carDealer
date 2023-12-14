package com.example.cardealer.web.controllers;

import com.example.cardealer.dtos.ShortOfferDto;
import com.example.cardealer.repositories.ModelRepository;
import com.example.cardealer.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private final OfferService offerService;

    @Autowired
    private final ModelRepository modelRepository;

    public HomeController(OfferService offerService, ModelRepository modelRepository) {
        this.offerService = offerService;
        this.modelRepository = modelRepository;
    }

    @GetMapping("/")
    public String homePage(Model model) {

        List<ShortOfferDto> latestOffers = offerService.getLatestOffers();
//        List<Optional<com.example.cardealer.models.enteties.Model>> models = new ArrayList<>();

//        for (ShortOfferDto offer : latestOffers){
//            models.add(modelRepository.findByName(offer.getModelName()));
//        }

        System.out.println(latestOffers.size());

        model.addAttribute("latestOffers", latestOffers);
//        model.addAttribute("brands", model);

        return "index";
    }
}

