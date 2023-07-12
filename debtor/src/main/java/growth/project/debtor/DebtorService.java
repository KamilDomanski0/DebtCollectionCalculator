package growth.project.debtor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.lang.Math.round;

@Service
public class DebtorService {

    @Autowired
    DebtorRepository repository;

    @Autowired
    DebtorValidationService validationService;

    public void createDebtor(Debtor debtor) {
        if(validationService.validate(debtor)){
            repository.save(debtor);
        }
    }

    public Debtor getDebtorById(Integer id) {
        Debtor debtor = repository.getById(id);
        if(!ObjectUtils.isEmpty(debtor)) {
            return debtor;
        } else {
            System.out.println("No user with given ID");
            return null;
        }
    }

    public List<Debtor> getDebtorByName(String name) {
        return repository.getDebtorByName(name);
    }

    public List<Debtor> getDebtorByLastName(String lastName) {
        return repository.getDebtorByLastName(lastName);
    }

    public List<Debtor> getAllDebtors() {return repository.findAll();}

    public void editDebtor(Debtor debtor) {
        if (repository.existsById(debtor.getId())) {
            repository.save(debtor);
        }
    }

    public Debtor getDebtorByPesel(String pesel) { return repository.getDebtorByPesel(pesel); }

    public void deleteDebtorBy(Integer id) {repository.deleteById(id);}

    public String calculateRepaymentDate(Integer id){
        Debtor debtor = getDebtorById(id);
        double collectionRate = debtor.getDebtAmount()/debtor.getMaxMonthlyRepaymentAmount();
        LocalDate repaymentDate = LocalDate.now().plusMonths((long)Math.ceil(collectionRate));
        String repaymentDateFormatted = repaymentDate.format(DateTimeFormatter.ofPattern("yyyy/MM")).toString();
        return repaymentDateFormatted;
    }

}
