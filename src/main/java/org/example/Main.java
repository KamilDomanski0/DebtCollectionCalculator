package org.example;

import org.example.Debtor.Debtor;
import org.example.Debtor.DebtorRepository;
import org.example.Debtor.DebtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }
}

//Prosty crud dla dłużników z możliwością kalkulowania terminu spłaty