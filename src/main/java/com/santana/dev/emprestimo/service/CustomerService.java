package com.santana.dev.emprestimo.service;

import com.santana.dev.emprestimo.model.Customer;
import com.santana.dev.emprestimo.model.CustomerLoan;
import com.santana.dev.emprestimo.model.Loans;
import com.santana.dev.emprestimo.validation.IValidationCheck;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final List<IValidationCheck> validation;

    public CustomerService(List<IValidationCheck> validation) {
        this.validation = validation;
    }

    public CustomerLoan loans(Customer customer){
        List<Loans> loansDtos = new ArrayList<>();

        validation.forEach(v -> v.validation(customer, loansDtos));

        return new CustomerLoan(customer.getName(), loansDtos);
    }


}
