package com.test.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {

    public Product(){}
    public Product(String productType,String productName,BigDecimal productPrice){
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
    }

    @Id
    @GeneratedValue(generator = "prod_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "prod_id_seq",initialValue = 1,allocationSize = 1,sequenceName = "PRODUCT_ID_SEQ")
    public int productId;
    public String productName;
    public String productType;
    public BigDecimal productPrice;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}
