/*
 * Copyright (C) 2018 Trant Batey <trant.batey at trantbatey.com>
 *
 * 
 */
package com.trantbatey.groceries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ProductDAO interface.
 *
 * @author Trant Batey <trant.batey at trantbatey.com>
 *
 */
public class ProductDAOImpl implements ProductDAO {

    private JdbcTemplate jdbcTemplate;

    public ProductDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Product product) {
        if (product.getProductID() > 0) {
            // update
            String sql = "UPDATE Product SET name=?, email=?, address=?, "
                    + "telephone=? WHERE Product_id=?";
            jdbcTemplate.update(sql, product.getDescription(),
                    product.getLastSold(), product.getShelfLife(), product.getDepartment(),
                    product.getPrice(), product.getUnit(), product.getxFor(), product.getCost());
        } else {
            // insert
            String sql = "INSERT INTO Product (productID, description, lastSold, shelfLife,\n"
                    + "                department, price, unit, xFor, cost)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, product.getProductID(), product.getDescription(),
                    product.getLastSold(), product.getShelfLife(), product.getDepartment(),
                    product.getPrice(), product.getUnit(), product.getxFor(), product.getCost());
        }
    }

    @Override
    public void delete(int productId) {
        String sql = "DELETE FROM product WHERE productId = ?";
        jdbcTemplate.update(sql, productId);
    }

    @Override
    public List<Product> list() {
        String sql = "SELECT * FROM product";
        List<Product> listProduct = jdbcTemplate.query(sql, new RowMapper<Product>() {

            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();

                product.setProductID(rs.getInt("productId"));
                product.setDescription(rs.getString("description"));
                product.setLastSold(rs.getDate("lastSold"));
                product.setShelfLife(rs.getInt("shelfLife"));
                product.setDepartment(rs.getString("department"));
                product.setPrice(rs.getFloat("price"));
                product.setUnit(rs.getString("unit"));
                product.setxFor(rs.getInt("xFor"));
                product.setCost(rs.getFloat("cost"));

                return product;
            }
        });

        return listProduct;
    }

    @Override
    public Product get(int productId) {
        String sql = "SELECT * FROM product WHERE productId=" + productId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Product>() {

            @Override
            public Product extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Product product = new Product();
                    product.setProductID(rs.getInt("productId"));
                    product.setDescription(rs.getString("description"));
                    product.setLastSold(rs.getDate("lastSold"));
                    product.setShelfLife(rs.getInt("shelfLife"));
                    product.setDepartment(rs.getString("department"));
                    product.setPrice(rs.getFloat("price"));
                    product.setUnit(rs.getString("unit"));
                    product.setxFor(rs.getInt("xFor"));
                    product.setCost(rs.getFloat("cost"));
                    return product;
                }

                return null;
            }
        });
    }
}
