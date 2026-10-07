/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Object_Stream;

/**
 *
 * @author Lenovo
 */
import java.util.*; 
import java.io.*; 
public class BankAccount implements  Serializable{
    private static final long serialVersionUID = 20210601L; 
    private int accountId ; 
    private String accountHolder ; 
    private double balance; 
    private List<Double> transactions; 
    private String balanceSummary; 

    public BankAccount() {
    }

    public BankAccount(int accountId, String accountHolder, double balance, List<Double> transactions, String balanceSummany) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactions = transactions;
        this.balanceSummary = balanceSummany;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Double> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Double> transactions) {
        this.transactions = transactions;
    }

    public String getBalanceSummany() {
        return balanceSummary;
    }

    public void setBalanceSummary(String balanceSummany) {
        this.balanceSummary = balanceSummany;
    }
    
}
