package com.oxygen.shop.common.po;

public class Shopping {
    private Integer id;

    private Integer userId;

    private String product;

    private String originalPrice;

    private String location;

    private String rates;

    private String quantity;

    private String path;

    private String date;

    private String quotationId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice == null ? null : originalPrice.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getRates() {
        return rates;
    }

    public void setRates(String rates) {
        this.rates = rates == null ? null : rates.trim();
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity == null ? null : quantity.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId == null ? null : quotationId.trim();
    }
}