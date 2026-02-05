package com.santana.dev.emprestimo.model;

import java.util.List;

public record CustomerLoan(String custumer, List<Loans> loans) {

}
