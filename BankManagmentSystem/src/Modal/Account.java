/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

import java.sql.Date;

/**
 *
 * @author SSC
 */
public class Account {

    private String accountNumber;
    private String clientUsername;
    private Date createDate;
    private int AccountTypeId;
    private double balance;
    private double transferLimit;
    private double withdrawLimit;
    private String status;

    public Account() {
    }

    public Account(String accountNumber, String clientUsername, Date createDate, int AccountTypeId, double balance, double transferLimit, double withdrawLimit, String status) {
        this.accountNumber = accountNumber;
        this.clientUsername = clientUsername;
        this.createDate = createDate;
        this.AccountTypeId = AccountTypeId;
        this.balance = balance;
        this.transferLimit = transferLimit;
        this.withdrawLimit = withdrawLimit;
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getAccountTypeId() {
        return AccountTypeId;
    }

    public void setAccountTypeId(int AccountTypeId) {
        this.AccountTypeId = AccountTypeId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getTransferLimit() {
        return transferLimit;
    }

    public void setTransferLimit(double transferLimit) {
        this.transferLimit = transferLimit;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
