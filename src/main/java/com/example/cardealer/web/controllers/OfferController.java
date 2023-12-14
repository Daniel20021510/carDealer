package com.example.cardealer.web.controllers;

import com.example.cardealer.dtos.AddModelDto;
import com.example.cardealer.dtos.AddOfferDto;
import com.example.cardealer.models.enteties.Offer;
import com.example.cardealer.services.AppUserDetailsService;
import com.example.cardealer.services.ModelService;
import com.example.cardealer.services.OfferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    private final ModelService modelService;

    @Autowired
    public OfferController(OfferService offerService, ModelService modelService) {
        this.offerService = offerService;
        this.modelService = modelService;
    }

    @GetMapping("/add")
    public String addOffer(Model offer) {

        offer.addAttribute("availableModels", modelService.allModels());
//        offer.addAttribute("availableSellers", userService.allSeller());

        return "offer-add";
    }

    @ModelAttribute("offerModel")
    public AddOfferDto initOffer() {
        return new AddOfferDto();
    }

    @PostMapping("/add")
    public String addOffer(@Valid AddOfferDto offerModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel",
                    bindingResult);
            return "redirect:/offers/add";
        }
        offerService.addOffer(offerModel);

        return "redirect:/";
    }

//    @GetMapping("/all")
//    public String showAllBrands(Model model) {
//        model.addAttribute("brandInfos", brandService.allBrands());
//
//        return "brand-all";
//    }
//
//    @GetMapping("/brand-details/{brand-name}")
//    public String brandDetails(@PathVariable("brand-name") String brandName, Model model) {
//        model.addAttribute("brandDetails", brandService.brandDetails(brandName));
//
//        return "brand-details";
//    }
//
//    @GetMapping("/brand-delete/{brand-name}")
//    public String deleteBrand(@PathVariable("brand-name") String brandName) {
//        brandService.removeBrand(brandName);
//
//        return "redirect:/brands/all";
//    }
}
