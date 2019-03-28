/*
 * Copyright (C) 2018 Trant Batey <trant.batey at trantbatey.com>
 *
 * 
 */
package com.trantbatey.groceries;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String searchSubmit(@RequestParam("description") String description,
            @RequestParam("department") String department,
            @RequestParam("maxPrice") String maxPrice,
            @RequestParam("minPrice") String minPrice) {
        System.out.println("ProductSearchController02 productSearch: " + description);
        System.out.println("ProductSearchController02 productSearch.department: " + department);
        System.out.println("ProductSearchController02 productSearch.maxPrice: " + maxPrice);
        System.out.println("ProductSearchController02 productSearch.minPrice: " + minPrice);
        HomeController.setSearchFilters(description, department, maxPrice, minPrice);
        return "redirect:/hello?description="+description
                +"&department="+department
                +"&maxPrice="+maxPrice
                +"&minPrice="+minPrice;
    }
}
