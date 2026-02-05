package com.santana.dev.emprestimo.service;

import com.santana.dev.emprestimo.model.Customer;
import com.santana.dev.emprestimo.model.FeesType;
import com.santana.dev.emprestimo.model.CustomerLoan;
import com.santana.dev.emprestimo.model.Loans;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustumerService {

    public CustomerLoan loans(Customer customer){
        List<Loans> loansDtos = new ArrayList<>();
        if (checkLoanPersonal(customer)){
            loansDtos.add(new Loans(FeesType.PERSONAL));
        }
        if (checkLoanGuaranteed(customer)){
            loansDtos.add(new Loans(FeesType.GUARANTEED));
        }
        if (checkLeanConsigment(customer)){
            loansDtos.add(new Loans(FeesType.CONSIGNMENT));
        }

        return new CustomerLoan(customer.getName(), loansDtos);
    }


    public Boolean checkLoanPersonal(Customer customer){
        return customer.getIncome() <= 3000 ||
                (customer.getIncome() <= 5000 && customer.getAge() < 30 && "SP".equalsIgnoreCase(customer.getLocation()));
    }

    public Boolean checkLoanGuaranteed(Customer customer){
        return customer.getIncome() <= 3000 ||
                (customer.getIncome() <= 5000 && customer.getAge() < 30 && "SP".equalsIgnoreCase(customer.getLocation()));
    }

    public Boolean checkLeanConsigment(Customer customer){
        return customer.getIncome() >= 5000;
    }


}
