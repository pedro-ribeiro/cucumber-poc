package com.byclosure;

import cucumber.api.Pending;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class BankAccountSteps {
    private BankAccount ba;
    private List<BankAccount> accounts = new ArrayList<BankAccount>();

    @Given("^I have a bank account$")
    public void I_have_a_bank_account() throws Throwable {
        this.ba = new BankAccount("Me");
    }

    @Given("^my balance is \\$(\\d+)$")
    public void my_balance_is_$(int b) throws Throwable {
        ba.setBalance(b);
    }

    @When("^I withdraw \\$(\\d+)$")
    public void I_withdraw_$(int value) throws Throwable {
        ba.withdraw(value);
    }

    @Then("^my bank account balance should be \\$(\\d+)$")
    public void my_bank_account_balance_should_be_$(int balance) throws Throwable {
//        Assert.assertEquals(balance, ba.getBalance());
        throw new PendingException();
    }

    @When("^I add \\$(\\d+)$")
    public void I_add_$(int value) throws Throwable {
        ba.add(value);
    }

    @Given("^these people have bank accounts with balances:$")
    public void these_people_have_bank_accounts_with_balances(List<AccountInfo> accountInfos) throws Throwable {
        for(AccountInfo ai : accountInfos) {
            final BankAccount b = new BankAccount(ai.name);
            b.setBalance(ai.balance);
            accounts.add(b);
        }
    }

    @When("^I take all their money$")
    public void I_take_all_their_money() throws Throwable {
        for(BankAccount bankAccount : accounts) {
            ba.add(bankAccount.balance);
        }
    }

    public static class AccountInfo {
        private String name;
        private int balance;
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
