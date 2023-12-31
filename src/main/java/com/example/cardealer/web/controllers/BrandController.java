package com.example.cardealer.web.controllers;

import com.example.cardealer.dtos.AddBrandDto;
import com.example.cardealer.services.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/add")
    public String addBrand() {
        return "brand-add";
    }

    @ModelAttribute("brandModel")
    public AddBrandDto initBrand() {
        return new AddBrandDto();
    }

    @PostMapping("/add")
    public String addBrand(@Valid AddBrandDto brandModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("brandModel", brandModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.brandModel",
                    bindingResult);
            return "redirect:/brands/add";
        }
        brandService.addBrand(brandModel);

        return "redirect:/";
    }

    @GetMapping("/all")
    public String showAllBrands(Model model) {
        model.addAttribute("brandInfos", brandService.allBrands());

        return "brand-all";
    }
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
