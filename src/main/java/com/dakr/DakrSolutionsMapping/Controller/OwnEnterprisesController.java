package com.dakr.DakrSolutionsMapping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.dakr.DakrSolutionsMapping.Entity.DakrSolutions;
import com.dakr.DakrSolutionsMapping.Entity.OwnEnterprises;
import com.dakr.DakrSolutionsMapping.Service.DakrSolutionsService;
import com.dakr.DakrSolutionsMapping.Service.OwnEnterprisesService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/own-enterprises")
public class OwnEnterprisesController {

    @Autowired
    private OwnEnterprisesService ownEnterprisesService;

    @Autowired
    private DakrSolutionsService dakrSolutionsService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("ownEnterprises", new OwnEnterprises());
        return "own-enterprises-form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute @Valid OwnEnterprises ownEnterprises, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "own-enterprises-form";
        }

        DakrSolutions dakrSolutions = dakrSolutionsService.findByName(ownEnterprises.getName());

        if (dakrSolutions == null) {
            result.rejectValue("name", "error.name", "No matching DAKR Solutions entry found for this Name.");
            return "own-enterprises-form";
        }

        ownEnterprises.setDakrSolutions(dakrSolutions);
        ownEnterprisesService.save(ownEnterprises);

        model.addAttribute("message", "Form submitted successfully.");
        return "own-enterprises-success";
    }
}
