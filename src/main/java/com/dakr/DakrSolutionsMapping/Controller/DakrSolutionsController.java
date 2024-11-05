package com.dakr.DakrSolutionsMapping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dakr.DakrSolutionsMapping.Entity.DakrSolutions;
import com.dakr.DakrSolutionsMapping.Service.DakrSolutionsService;


import jakarta.validation.Valid;

@Controller
@RequestMapping("/dakr-solutions")
public class DakrSolutionsController {

    @Autowired
    private DakrSolutionsService dakrSolutionsService;

    @GetMapping("/form")
    public String showDAKRSolutionsForm(Model model) {
        model.addAttribute("dakrSolutions", new DakrSolutions());
        return "dakr-solutions-form";
    }

    @PostMapping("/submit")
    public String submitDAKRSolutionsForm(@ModelAttribute @Valid DakrSolutions dakrSolutions, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "dakr-solutions-form";
        }
        
        dakrSolutionsService.save(dakrSolutions);
        model.addAttribute("message", "DAKR Solutions entry created successfully.");
        return "dakr-solutions-success";
    }

    @GetMapping("/list")
    public String listDAKRSolutions(Model model) {
        model.addAttribute("dakrSolutionsList", dakrSolutionsService.findAll());
        return "dakr-solutions-list";
    }
}
