package com.oxygen.shop.common.po;

public class Quotation {
    private Integer id;

    private String product;

    private String offer;

    private String topPrice;

    private String floorPrice;

    private String path;

    private String date;

    private String stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer == null ? null : offer.trim();
    }

    public String getTopPrice() {
        return topPrice;
    }

    public void setTopPrice(String topPrice) {
        this.topPrice = topPrice == null ? null : topPrice.trim();
    }

    public String getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(String floorPrice) {
        this.floorPrice = floorPrice == null ? null : floorPrice.trim();
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

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock == null ? null : stock.trim();
    }
}