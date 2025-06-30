package com.promocode_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Promotions {
    @Id
    private String promoCode;

    private String promoType;

    private String description;

    private Double promoAmount;

    public String getPromoCode() {
        return promoCode;
    }

    public String getPromoType() {
        return promoType;
    }

    public String getDescription() {
        return description;
    }

    public Double getPromoAmount() {
        return promoAmount;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public void setPromoType(String promoType) {
        this.promoType = promoType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPromoAmount(Double promoAmount) {
        this.promoAmount = promoAmount;
    }

    public Promotions(String promoCode, String promoType, Double promoAmount, String description) {
        this.promoCode = promoCode;
        this.promoType = promoType;
        this.promoAmount = promoAmount;
        this.description = description;
    }
}
