package com.reptile.carwebreptileyqy.entity;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class AutoPartsInfoEntity implements Serializable {
    private static final long serialVersionUID = -8742074947015792578L;
    private Integer id;
    private String productNumber;
    private String productName;
    private String vehicleModel;
    private BigDecimal wholesalePrize;
    private BigDecimal retailPrice;
    private BigDecimal discountPrize;
    private String factoryNumber;
    private String specification;
}
