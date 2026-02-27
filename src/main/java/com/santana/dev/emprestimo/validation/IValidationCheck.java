package com.santana.dev.emprestimo.validation;

import com.santana.dev.emprestimo.model.Customer;
import com.santana.dev.emprestimo.model.Loans;

import java.util.List;

public interface IValidationCheck {

    void validation(Customer customer, List<Loans> loans);

}
