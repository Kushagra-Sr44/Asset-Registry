package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "corporate_assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetName;
    private String category;
    private Double purchaseValue;
    private String assignedTo;

    public Asset() {
    }

    public Asset(String assetName, String category, Double purchaseValue, String assignedTo) {
        this.assetName = assetName;
        this.category = category;
        this.purchaseValue = purchaseValue;
        this.assignedTo = assignedTo;
    }
}
