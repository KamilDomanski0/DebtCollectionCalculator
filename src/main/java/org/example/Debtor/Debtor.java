package org.example.Debtor;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Debtor {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String lastName;
    @Column(unique=true)
    private String pesel;
    private double debtAmount;
    private double maxMonthlyRepaymentAmount;
    private String address;

    public Debtor(String name, String lastName, String pesel, double debtAmount, double maxMonthlyRepaymentAmount, String address) {
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.debtAmount = debtAmount;
        this.maxMonthlyRepaymentAmount = maxMonthlyRepaymentAmount;
        this.address = address;
    }

    public Debtor() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public double getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(double debtAmount) {
        this.debtAmount = debtAmount;
    }

    public double getMaxMonthlyRepaymentAmount() {
        return maxMonthlyRepaymentAmount;
    }

    public void setMaxMonthlyRepaymentAmount(double maxMonthlyRepaymentAmount) {
        this.maxMonthlyRepaymentAmount = maxMonthlyRepaymentAmount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
