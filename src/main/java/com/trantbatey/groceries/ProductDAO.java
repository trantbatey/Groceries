/*
 * Copyright (C) 2018 Trant Batey <trant.batey at trantbatey.com>
 *
 * 
 */
package com.trantbatey.groceries;

import java.util.List;
  
/**
 * Defines DAO operations for the product model.
 * @author Trant Batey <trant.batey at trantbatey.com>
 *
 */
public interface ProductDAO {
     
    public void saveOrUpdate(Product product);
     
    public void delete(int productId);
     
    public Product get(int productId);
     
    public List<Product> list(String description);
}
