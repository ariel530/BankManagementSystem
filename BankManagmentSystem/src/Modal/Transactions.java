/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author SSC
 */
public abstract class Transactions {

    private int id;
    private String senderAccountNumber;
    private Date sendingDate;
    private Time sendingTime;
    private String transactionType;
    private double transactionAmount;

    public Transactions() {
    }

    public Transactions(int id, String senderAccountNumber, Date sendingDate, Time sendingTime, String transactionType, double transactionAmount) {
        this.id = id;
        this.senderAccountNumber = senderAccountNumber;
        this.sendingDate = sendingDate;
        this.sendingTime = sendingTime;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public Date getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

    public Time getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(Time sendingTime) {
        this.sendingTime = sendingTime;
    }

    public abstract String getTransactionType();

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString()
    {
        return  String.format("%8s %20s %20s %20s %20s %10s %5s", ""+id,senderAccountNumber,"",""+sendingDate.toString(),""+sendingTime,"","₪: "+transactionAmount);
    }
    
}
