package com.santana.dev.emprestimo.validation;

import com.santana.dev.emprestimo.model.Customer;
import com.santana.dev.emprestimo.model.FeesType;
import com.santana.dev.emprestimo.model.Loans;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckLoanGuaranteed implements IValidationCheck{

    @Override
    public void validation(Customer customer, List<Loans> loans) {
        if (customer.getIncome() <= 3000 || (customer.getIncome() <= 5000 && customer.getAge() < 30 && "SP".equalsIgnoreCase(customer.getLocation()))){
            loans.add(new Loans(FeesType.GUARANTEED));
        }
    }
}
