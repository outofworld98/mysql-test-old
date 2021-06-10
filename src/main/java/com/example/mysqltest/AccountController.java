package com.example.mysqltest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final JpaAccountRepository accountService;

    public AccountController(JpaAccountRepository accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public void create() {
        String str = new Date().toString();
        accountService.save(AccountEntity.builder()
                .accountId("test".concat(str))
                .accountName("testName".concat(str))
                .build());
    }

    @GetMapping
    public List<AccountEntity> getAccount() {
        return accountService.findAll();
    }
}
