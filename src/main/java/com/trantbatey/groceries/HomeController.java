/*
 * Copyright (C) 2018 Trant Batey <trant.batey at trantbatey.com>
 *
 * 
 */
package com.trantbatey.groceries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Trant Batey <trant.batey at trantbatey.com>
 */
public class HomeController {
    
    private static String productSearchString;
    
    public static void setProductSearchString(String searchString) {
        productSearchString = searchString;
        System.out.println("HomeController searchString :" + searchString);
    }
 
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/products");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
         
        return dataSource;
    }
    
    private ProductDAOImpl aProductDAOImpl;
    
    @Bean
    public ProductDAO getProductDAO() {
        if (aProductDAOImpl == null)
            aProductDAOImpl = new ProductDAOImpl(getDataSource());
        return aProductDAOImpl;
    }

    public List<Product> listProduct() throws IOException {
        ProductDAO productDAO = getProductDAO();
        System.out.println("HomeController productSearchString:" + productSearchString);
        List<Product> productList = productDAO.list(productSearchString);
        return productList;
    }

    @RequestMapping(value = "/newProduct", method = RequestMethod.GET)
    public ModelAndView newProduct(ModelAndView model) {
        Product newProduct = new Product();
        model.addObject("product", newProduct);
        model.setViewName("ProductForm");
        return model;
    }

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public ModelAndView saveProduct(@ModelAttribute Product product) {
        ProductDAO productDAO = getProductDAO();
        productDAO.saveOrUpdate(product);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public ModelAndView deleteProduct(HttpServletRequest request) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        ProductDAO productDAO = getProductDAO();
        productDAO.delete(productId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editProduct", method = RequestMethod.GET)
    public ModelAndView editProduct(HttpServletRequest request) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        ProductDAO productDAO = getProductDAO();
        Product product = productDAO.get(productId);
        ModelAndView model = new ModelAndView("ProductForm");
        model.addObject("product", product);

        return model;
    }
}
