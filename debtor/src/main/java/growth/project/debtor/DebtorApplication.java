package growth.project.debtor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DebtorApplication {
    public static void main(String[] args) {

        SpringApplication.run(DebtorApplication.class, args);
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