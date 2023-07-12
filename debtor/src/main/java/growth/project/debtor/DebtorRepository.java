package growth.project.debtor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebtorRepository extends JpaRepository<Debtor, Integer> {
    List<Debtor> getDebtorByName(String name);
    List<Debtor> getDebtorByLastName(String lastName);
    Debtor getDebtorByPesel(String pesel);
}
