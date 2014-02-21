package com.byclosure;

import org.jbehave.core.annotations.*;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class BankAccountSteps extends Embedder {

    private BankAccount ba;
    private List<BankAccount> accounts = new ArrayList<BankAccount>();

    @Given("some step")
    public void givenSomeStep() {

    }

    @Given("I have a bank account")
    public void I_have_a_bank_account(){
        this.ba = new BankAccount("Me");
    }

    @Given("my balance is $balance")
    public void my_balance_is(int balance){
        ba.setBalance(balance);
    }

    @When("I withdraw $value")
    public void I_withdraw(int value){
        ba.withdraw(value);
    }

    @Then("my bank account balance should be $balance")
    @Alias("my bank account balance should be <balance>")
    public void my_bank_account_balance_should_be(@Named("balance")int balance){
        System.out.println(ba);

        Assert.assertEquals(balance, ba.getBalance());
    }

    @When("I add $value")
    @Alias("I add <value>")
    public void I_add(@Named("value")int value) {
        ba.add(value);
    }

    @Given("these people have bank accounts with balances: $accountInfos")
    public void these_people_have_bank_accounts_with_balances(@Named("accountInfos")ExamplesTable accountInfos) throws Throwable {
        for(Map<String, String> ai : accountInfos.getRows()) {
            final BankAccount b = new BankAccount(ai.get("Name"));
            final int balance = Integer.parseInt(ai.get("balance"));
            b.setBalance(balance);
            accounts.add(b);
        }
    }

    @When("I take all their money")
    public void I_take_all_their_money() {
        for(BankAccount bankAccount : accounts) {
            ba.add(bankAccount.balance);
        }
    }

    public static class BankAccount {
        private int balance;
        private final String name;

        public BankAccount(String name) {
            this.name = name;
        }

        public int getBalance() {
            return this.balance;
        }
        public void setBalance(int balance) {
            this.balance = balance;
        }

        public void add(int v) {
            this.balance += v;
        }

        public void withdraw(int v) {
            this.balance -= v;
        }
    }
}
