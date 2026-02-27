package com.santana.dev.emprestimo.validation;

import com.santana.dev.emprestimo.model.Customer;
import com.santana.dev.emprestimo.model.FeesType;
import com.santana.dev.emprestimo.model.Loans;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckLoanConsigment implements IValidationCheck {

    public void validation(Customer customer, List<Loans> loans) {
        if (customer.getIncome() >= 5000){
            loans.add(new Loans(FeesType.CONSIGNMENT));
        }
    }
}
