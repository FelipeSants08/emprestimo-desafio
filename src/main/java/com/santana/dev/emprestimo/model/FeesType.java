package com.santana.dev.emprestimo.model;

import lombok.Getter;

@Getter
public enum FeesType {

    PERSONAL("Personal", 4),
    GUARANTEED("Guaranteed", 3),
    CONSIGNMENT("Consignment", 2);

    private String name;
    private Integer fees;

    FeesType(String name, Integer fees) {
        this.name = name;
        this.fees = fees;
    }


}
