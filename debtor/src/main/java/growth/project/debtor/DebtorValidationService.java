package growth.project.debtor;

import org.springframework.stereotype.Service;

@Service
public class DebtorValidationService {

    public boolean validate(Debtor debtor) {
        if(!validateName(debtor.getName())) {
            System.out.println(debtor.getName() + " is not allowed as a name");
            return false;
        }
        if(!validateLastName(debtor.getLastName())) {
            System.out.println(debtor.getLastName() + " is not allowed as a last name");
            return false;
        }
        if(!validatePesel(debtor.getPesel())) {
            System.out.println(debtor.getPesel() + " is not allowed as pesel");
            return false;
        }
        return true;
    }

    private boolean validateName(String name) { return name.matches("[a-zA-Z]+") ? true : false;}

    private boolean validateLastName(String lastName) { return lastName.chars().allMatch(Character::isLetter) ? true : false;}

    private boolean validatePesel(String pesel) { return pesel.matches("[0-9]+") && pesel.length() == 11 ? true : false;}


}
