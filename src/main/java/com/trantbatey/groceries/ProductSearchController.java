/*
 * Copyright (C) 2018 Trant Batey <trant.batey at trantbatey.com>
 *
 * 
 */
package com.trantbatey.groceries;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Trant Batey <trant.batey at trantbatey.com>
 */
@Controller
public class ProductSearchController {
    @GetMapping("/productSearch")
    public String searchForm(Model model) {
        System.out.println("ProductSearchController01 productSearch.getDescription:");
        model.addAttribute("productSearch", new ProductSearch());
        return "productSearch";
    }

    @RequestMapping("/productSearch")
    public String searchSubmit(@ModelAttribute ProductSearch productSearch) {
        System.out.println("ProductSearchController02 productSearch.getDescription:" + productSearch.getDescription());
        HomeController.setProductSearchString(productSearch.getDescription());
        return "redirect:/hello";
    }
}
