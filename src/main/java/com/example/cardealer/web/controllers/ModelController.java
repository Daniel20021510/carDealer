package com.example.cardealer.web.controllers;

import com.example.cardealer.dtos.AddModelDto;
import com.example.cardealer.services.BrandService;
import com.example.cardealer.services.ModelService;
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
@RequestMapping("/models")
public class ModelController {

    @Autowired
    private final ModelService modelService;

    @Autowired
    private final BrandService brandService;

    public ModelController(ModelService modelService, BrandService brandService) {
        this.modelService = modelService;
        this.brandService = brandService;
    }

    @GetMapping("/add")
    public String addModel(Model model) {

        model.addAttribute("availableBrands", brandService.allBrands());

        return "model-add";
    }

    @ModelAttribute("modelModel")
    public AddModelDto initModel() {
        return new AddModelDto();
    }

    @PostMapping("/add")
    public String addModel(@Valid AddModelDto modelModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("modelModel", modelModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelModel",
                    bindingResult);
            return "redirect:/models/add";
        }
        modelService.addModel(modelModel);

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
