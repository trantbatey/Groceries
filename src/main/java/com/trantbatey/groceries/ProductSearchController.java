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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Trant Batey <trant.batey at trantbatey.com>
 */
@Controller
public class ProductSearchController {
    @GetMapping("/productSearch")
    public String searchForm(Model model) {
        ProductSearch productSearch = new ProductSearch();
        System.out.println("ProductSearchController01 productSearch: " + productSearch);
        model.addAttribute("productSearch", productSearch);
        return "hello";
    }

    @PostMapping("/productSearch")
    public String searchSubmit(@RequestParam("description") String description) {
        System.out.println("ProductSearchController02 productSearch:" + description);
        System.out.println("ProductSearchController02 productSearch.getDescription:" + description);
        HomeController.setProductSearchString(description);
        return "redirect:/hello";
    }
}
