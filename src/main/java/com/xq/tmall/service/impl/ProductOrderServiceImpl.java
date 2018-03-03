package com.xq.tmall.service.impl;

import com.xq.tmall.dao.ProductOrderMapper;
import com.xq.tmall.entity.ProductOrder;
import com.xq.tmall.service.ProductOrderService;
import com.xq.tmall.util.OrderUtil;
import com.xq.tmall.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("productOrderService")
public class ProductOrderServiceImpl implements ProductOrderService{
    private ProductOrderMapper productOrderMapper;
    @Resource(name = "productOrderMapper")
    public void setProductOrderMapper(ProductOrderMapper productOrderMapper) {
        this.productOrderMapper = productOrderMapper;
    }
    @Override
    public boolean add(ProductOrder productOrder) {
        return productOrderMapper.insertOne(productOrder)>0;
    }

    @Override
    public boolean update(ProductOrder productOrder) {
        return productOrderMapper.updateOne(productOrder)>0;
    }

    @Override
    public boolean deleteList(Integer[] productOrder_id_list) {
        return productOrderMapper.deleteList(productOrder_id_list)>0;
    }

    @Override
    public List<ProductOrder> getList(ProductOrder productOrder, OrderUtil orderUtil, PageUtil pageUtil) {
        return productOrderMapper.select(productOrder,orderUtil,pageUtil);
    }

    @Override
    public ProductOrder get(Integer productOrder_id) {
        return productOrderMapper.selectOne(productOrder_id);
    }

    @Override
    public ProductOrder getByCode(String productOrder_code) {
        return productOrderMapper.selectByCode(productOrder_code);
    }

    @Override
    public Integer getTotal(ProductOrder productOrder) {
        return productOrderMapper.selectTotal(productOrder);
    }
}