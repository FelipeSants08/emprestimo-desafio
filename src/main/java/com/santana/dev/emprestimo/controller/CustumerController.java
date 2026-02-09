package com.santana.dev.emprestimo.controller;

import com.santana.dev.emprestimo.model.Customer;
import com.santana.dev.emprestimo.model.CustomerLoan;
import com.santana.dev.emprestimo.service.CustumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustumerController {

    private final CustumerService service;

    public CustumerController(CustumerService service) {
        this.service = service;
    }

    @PostMapping("/customer-loans")
    @ResponseStatus(HttpStatus.OK)
    public CustomerLoan custumer(@RequestBody Customer custumer) {
        log.info("Vendo quais empréstimos tem disponível para o usuário: {}", custumer.getName());
        CustomerLoan loan = service.loans(custumer);
        log.info("Vendo loan: {}", loan);
        return service.loans(custumer);
    }

}
