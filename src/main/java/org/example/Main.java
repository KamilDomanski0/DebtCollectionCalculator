package org.example;

import org.example.Debtor.Debtor;
import org.example.Debtor.DebtorRepository;
import org.example.Debtor.DebtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
=======
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
>>>>>>> 1cb6552 (added postresql)

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

    @Autowired
    private DebtorRepository repository;

    //dodanie pierwszego rekordu
    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        Debtor debtor = new Debtor();
        debtor.setName("Kamil");
        debtor.setLastName("Domanski");
        this.repository.save(debtor);
    }
}

//Prosty crud dla dłużników z możliwością kalkulowania terminu spłaty