package com.xq.tmall.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Product {
    private Integer product_id;
    private String product_name;
    private String product_title;
    private Double product_price;
    private Double product_sale_price;
    private Date product_create_date;
    private Category product_category;
    private Byte product_isEnabled;
    private List<PropertyValue> propertyValueList;
    private List<ProductImage> singleProductImageList;
    private List<ProductImage> detailProductImageList;
    private List<Review> reviewList;
    private List<ProductOrderItem> productOrderItemList;
    //销量数
    private Integer product_sale_count;
    //评价数
    private Integer product_review_count;

    public Product(){

    }

    public Product(Integer product_id, String product_name, Double product_sale_price, Category product_category, Byte product_isEnabled) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_sale_price = product_sale_price;
        this.product_category = product_category;
        this.product_isEnabled = product_isEnabled;
    }

    public Product(Integer product_id, String product_name, String product_title, Double product_price, Double product_sale_price, Date product_create_date, Category product_category, Byte product_isEnabled, List<PropertyValue> propertyValueList, List<ProductImage> singleProductImageList, List<ProductImage> detailProductImageList, List<Review> reviewList, List<ProductOrderItem> productOrderItemList,Integer product_sale_count,Integer product_review_count) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_title = product_title;
        this.product_price = product_price;
        this.product_sale_price = product_sale_price;
        this.product_create_date = product_create_date;
        this.product_category = product_category;
        this.product_isEnabled = product_isEnabled;
        this.propertyValueList = propertyValueList;
        this.singleProductImageList = singleProductImageList;
        this.detailProductImageList = detailProductImageList;
        this.reviewList = reviewList;
        this.productOrderItemList = productOrderItemList;
        this.product_sale_count = product_sale_count;
        this.product_review_count = product_review_count;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public Double getProduct_sale_price() {
        return product_sale_price;
    }

    public void setProduct_sale_price(Double product_sale_price) {
        this.product_sale_price = product_sale_price;
    }

    public String getProduct_create_date() {
        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.UK);
        return time.format(product_create_date);
    }

    public void setProduct_create_date(Date product_create_date) {
        this.product_create_date = product_create_date;
    }

    public Category getProduct_category() {
        return product_category;
    }

    public void setProduct_category(Category product_category) {
        this.product_category = product_category;
    }

    public String getProduct_isEnabled() {
        switch (product_isEnabled){
            case 0:
                return "停售中";
            case 1:
                return "销售中";
            default:
                return "促销中";
        }
    }

    public void setProduct_isEnabled(Byte product_isEnabled) {
        this.product_isEnabled = product_isEnabled;
    }

    public List<ProductImage> getSingleProductImageList() {
        return singleProductImageList;
    }

    public void setSingleProductImageList(List<ProductImage> singleProductImageList) {
        this.singleProductImageList = singleProductImageList;
    }

    public List<ProductImage> getdetailProductImageList() {
        return detailProductImageList;
    }

    public void setdetailProductImageList(List<ProductImage> detailProductImageList) {
        this.detailProductImageList = detailProductImageList;
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }

    public void setPropertyValueList(List<PropertyValue> propertyValueList) {
        this.propertyValueList = propertyValueList;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public List<ProductOrderItem> getProductOrderItemList() {
        return productOrderItemList;
    }

    public void setProductOrderItemList(List<ProductOrderItem> productOrderItemList) {
        this.productOrderItemList = productOrderItemList;
    }

    public Integer getProduct_sale_count() {
        return product_sale_count;
    }

    public void setProduct_sale_count(Integer product_sale_count) {
        this.product_sale_count = product_sale_count;
    }

    public Integer getProduct_review_count() {
        return product_review_count;
    }

    public void setProduct_review_count(Integer product_review_count) {
        this.product_review_count = product_review_count;
    }
}