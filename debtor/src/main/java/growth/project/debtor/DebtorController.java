package growth.project.debtor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/debtor")
public class DebtorController {
    @Autowired
    DebtorService service;

    @PostMapping
    public void createDebtors(@RequestBody Debtor debtor) { service.createDebtor(debtor); }

    @DeleteMapping("{id}")
    public void deleteUserBy(@PathVariable Integer id) { service.deleteDebtorBy(id); }

    @GetMapping("{id}")
    public Debtor getUserById(@PathVariable Integer id) { return service.getDebtorById(id); }

    @GetMapping("{name}")
    public List<Debtor> getDebtorByName(@PathVariable String name) { return service.getDebtorByName(name); }

    @GetMapping("{lastName}")
    public List<Debtor> getDebtorByLastName(@PathVariable String lastName) { return service.getDebtorByLastName(lastName); }

    @GetMapping
    public List<Debtor> getAllDebtors() {
        return service.getAllDebtors();
    }

    @PutMapping
    public void editDebtor(@RequestBody Debtor debtor) { service.editDebtor(debtor); }

    @GetMapping("calculate/{id}")
    public String calculateDebtCollectionRatePerMonth (@PathVariable Integer id) { return service.calculateRepaymentDate(id); }
}
