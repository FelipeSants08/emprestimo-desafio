package com.santana.dev.emprestimo.service;

import com.santana.dev.emprestimo.model.Customer;
import com.santana.dev.emprestimo.model.CustomerLoan;
import com.santana.dev.emprestimo.model.FeesType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustumerServiceTest {

    CustumerService custumerService = new CustumerService();

    @Test
    @DisplayName("Deve conceder empréstimo pessoal e garantia quando a renda for menor ou igual a 3000")
    public void deveRetornarLoansPessoalEGarantiaQuandoRendaForBaixa() {

        Customer cliente = new Customer(25, "123", "Fulano", 3000.0, "RJ");


        CustomerLoan resultado = custumerService.loans(cliente);


        assertEquals(2, resultado.loans().size(), "A lista deveria conter 2 empréstimos");


        assertEquals(FeesType.PERSONAL.toString(), resultado.loans().get(0).type());
        assertEquals(FeesType.GUARANTEED.toString(), resultado.loans().get(1).type());
    }

    @Test
    @DisplayName("Deve conceder empréstimo consignato quando a renda for superior a 5000")
    public void deveRetornarLoansConsignatoQuandoRendaForSuperiorA5000() {
        Customer customer = new Customer(25, "555555555", "Astrogildo", 5100.0, "SP");

        CustomerLoan resultado = custumerService.loans(customer);

        assertEquals(1, resultado.loans().size());
        assertEquals(FeesType.CONSIGNMENT.toString(), resultado.loans().get(0).type());
    }

    @Test
    @DisplayName("Deve conceder todos os tipos de loans, caso a renda seja de 5000, more em SP e tenha menos de 30 anos")
    public void deveRetornarTodosOsEmprestimosQuandoRendaIgualA5000MorarEmSPETerMenosDe30Anos(){

        Customer customer = new Customer(25, "555555555", "Antrolopoulos", 5000.0, "SP");

        CustomerLoan resultado = custumerService.loans(customer);

        assertEquals(3, resultado.loans().size());
        assertEquals(FeesType.PERSONAL.toString(), resultado.loans().get(0).type());
        assertEquals(FeesType.GUARANTEED.toString(), resultado.loans().get(1).type());
        assertEquals(FeesType.CONSIGNMENT.toString(), resultado.loans().get(2).type());
    }


}