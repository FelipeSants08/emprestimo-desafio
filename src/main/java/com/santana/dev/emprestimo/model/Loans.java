package com.santana.dev.emprestimo.model;

public record Loans(String type, Integer interestRate) {
    public Loans(FeesType loan) {
        this(loan.toString(), loan.getFees());
    }
}
