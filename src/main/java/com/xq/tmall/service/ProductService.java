package com.xq.tmall.service;

import com.xq.tmall.entity.Product;
import com.xq.tmall.util.OrderUtil;
import com.xq.tmall.util.PageUtil;

import java.util.List;

public interface ProductService {
    boolean add(Product product);
    boolean update(Product product);

    List<Product> getList(Product product, OrderUtil orderUtil, PageUtil pageUtil);
    Product get(Integer product_Id);
    Integer getTotal(Product product);
}